package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelEsecuzione extends JPanel implements ActionListener {
	private MainFrame mainframe = MainFrame.getIstance();
	private String fileNameSpaceShip, fileNameAsteroid, fileNameMeteorite, fileNameEnemies, fileNameBomb;
	private SpaceShip spaceShip;
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
	private List<Meteorite> meteorites;
	private List<Bomb> bombeVaganti;
	private BufferedImage scrollingBackground;
	private int yOffset = 0;
	private int yDelta = 1;
	private static int countToAddAsteroid = 0;
	private static int countToAddMeteorite = 0;
	private static int countToAddEnemies = 0;
	private final int DELAY = 20;
	private Timer timer;
	private JLabel labelLiveScore;
	private boolean bombe_flag = false;
	
	private List<EnemiesSpaceShip> enemies;
//	private List<Missile> missile;

	public PanelEsecuzione() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(false);
		mainframe.getScore().setScoreValue(0);
		this.labelLiveScore = new JLabel("Live Score: " + Integer.toString(mainframe.getScore().getScoreValue()));
		this.add(this.labelLiveScore);
		this.setLayout(null);

		this.labelLiveScore.setBounds(10, 10, 400, 50);
		this.labelLiveScore.setForeground(Color.WHITE);
		this.labelLiveScore.setFont(new Font("Serif", Font.BOLD, 22));

		this.fileNameSpaceShip = "../resources/images/spaceship.png";
		this.fileNameAsteroid = "../resources/images/asteroid-icon.png";
		this.fileNameMeteorite = "../resources/images/meteorite.png";
		this.fileNameBomb = "../resources/images/missile_enemy.png";
		this.fileNameEnemies = "../resources/images/firstEnemy.png";
		
		this.spaceShip = new SpaceShip(500, 400, fileNameSpaceShip);
		this.missiles = this.spaceShip.getMissiles();
		this.asteroids = new ArrayList<Asteroid>();
		this.meteorites = new ArrayList<Meteorite>();
		//this.bombs = new ArrayList<Bomb>();
		this.enemies = new ArrayList<EnemiesSpaceShip>();
		this.bombeVaganti = new ArrayList<Bomb>();


		try {
			this.scrollingBackground = ImageIO.read(getClass().getResource("../resources/images/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

//		  Random random = new Random();
//		
//			for(int i = 0; i<15; i++) {
//	        	int rand = random.nextInt(700);
//	        	
//	        	EnemiesSpaceShip enemy = new EnemiesSpaceShip(rand+getX()+50*i, getY()+rand,  fileNameEnemies);
//	        	enemies.add(enemy);
//	        	
//	        } 
			
		this.timer = new Timer(DELAY, this);
		this.timer.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (scrollingBackground != null) {
			Graphics2D g2d = (Graphics2D) g.create();

			int xPos = (getWidth() - scrollingBackground.getWidth()) / 2;
			int yPos = yOffset;

			while (yPos > 0) {
				yPos -= scrollingBackground.getHeight();
				g2d.drawImage(scrollingBackground, xPos, yPos, this);
			}

			yPos = yOffset;
			while (yPos < getHeight()) {
				g2d.drawImage(scrollingBackground, xPos, yPos, this);
				yPos += scrollingBackground.getHeight();
			}

			g2d.dispose();
		}

		doDrawing(g);

		Toolkit.getDefaultToolkit().sync();
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), this);

		List<Missile> missiles = spaceShip.getMissiles();

		for (Missile missile : missiles) {

			g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
		}

		for (Asteroid asteroid : asteroids) {
			g2d.drawImage(asteroid.getImage(), asteroid.getTransform(), this);
		}

		for (Meteorite meteorite : meteorites) {
			g2d.drawImage(meteorite.getImage(), meteorite.getTransform(), this);
		}
		if(!bombeVaganti.isEmpty()) {
			for (Bomb bomb : bombeVaganti) {
				g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
			}
		}
		
		for(EnemiesSpaceShip enemy : enemies) {
        	List<Bomb> lista = enemy.getBombs();
        	g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), 50, 60, this);

        	for(Bomb bomb : lista) {
        		g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
        	}
     
        }

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.updateSpaceShip();
		this.updateMissiles();
		this.updateObstacles();
		this.updateEnemies();
		this.updateBombs();
		this.updateBombeVaganti();
		this.checkCollisions();
		yOffset += yDelta;

		mainframe.getScore().updateScoreValue(1);
		this.labelLiveScore.setText("Live Score: " + Integer.toString(mainframe.getScore().getScoreValue()));
		this.repaint();

	}

	private void updateMissiles() {

		List<Missile> missiles = spaceShip.getMissiles();

		for (int i = 0; i < missiles.size(); i++) {

			Missile missile = missiles.get(i);

			if (missile.isVisible()) {

				missile.move();
				missile.setBounds();
			} else {

				missiles.remove(i);
			}
		}
		
	

	}

	public void updateSpaceShip() {
		spaceShip.move();
		spaceShip.setBounds();
		
	}

	public void updateObstacles() {
		Random random = new Random();

		int y_asteroid = -500;
		int y_meteorite = -500;
		int D_W = 1000;
		int D_H = 600;

		// maggiore � il valore minore � la frequenza di uscita degli asteroidi
		if (countToAddAsteroid >= 150) {
			int randX1 = random.nextInt(D_W);
			asteroids.add(new Asteroid(randX1, y_asteroid, fileNameAsteroid));
			countToAddAsteroid = 0;
		}
		countToAddAsteroid++;

		if (countToAddMeteorite >= 150) {
			int randX2 = random.nextInt(D_W);
			meteorites.add(new Meteorite(randX2, y_meteorite, fileNameMeteorite));
			countToAddMeteorite = 0;
		}
		countToAddMeteorite++;

		Iterator<Asteroid> it_asteroids = asteroids.iterator();

		while (it_asteroids.hasNext()) {
			Asteroid asteroid = (Asteroid) it_asteroids.next();
			if (asteroid.getY() >= D_H || !asteroid.isVisible()) {
				it_asteroids.remove();
			} else {
				asteroid.move();
				asteroid.setBounds();
			}
		}

		Iterator<Meteorite> it_meteorites = meteorites.iterator();

		while (it_meteorites.hasNext()) {
			Meteorite meteorite = (Meteorite) it_meteorites.next();
			if (meteorite.getY() >= D_H || !meteorite.isVisible()) {
				it_meteorites.remove();
			} else {
				meteorite.move();
				meteorite.setBounds();
			}
		}	
		
	}
	
	public void updateEnemies() {
		int D_W = 1000;
		int D_H = 600;
		Random random = new Random();
		
		if (countToAddEnemies >= 150) {
			int randX2 = random.nextInt(D_W);
			enemies.add(new EnemiesSpaceShip(randX2, -20, fileNameEnemies));
			enemies.get(enemies.size()-1).fire();
			countToAddEnemies = 0;
		}
		countToAddEnemies++;
		
		Iterator<EnemiesSpaceShip> et = enemies.iterator();
		
    	while(et.hasNext()) {
    		EnemiesSpaceShip enemy = (EnemiesSpaceShip)et.next();
    		if (enemy.getY() >= D_H || !enemy.isVisible()) {
    			bombeVaganti = enemy.getBombs();;
				et.remove();
			} else {
				enemy.move();
				enemy.setBounds();
			}
    		
    	}
	}
	
	private void updateBombs() {
		
		for(int i=0; i< enemies.size();i++) {
			List<Bomb> bomb = enemies.get(i).getBombs();
			for(int j=0;j< bomb.size();j++) {
				Bomb bomba = bomb.get(j);			
				if(bomba.isVisible()) {
					bomba.move();
					bomba.setBounds();
		        	if(bomba.getY()>650) {		        		
		        		bomba.setY(enemies.get(i).getY()+50);
		        		bomba.setX(enemies.get(i).getX()+15);
	        	}
				}else {
					bomb.remove(j);
				}
			}
		}
	

	}
	
	public void updateBombeVaganti() {
		if(!bombeVaganti.isEmpty()) {
		for(int i=0; i<bombeVaganti.size();i++) {
			Bomb bomba = bombeVaganti.get(i);
			if(bomba.isVisible()) {
				bomba.move();
				bomba.setBounds();
				if(bomba.getY()>650) {
					bombeVaganti.remove(i);
				}
			}
		}
	}
	}
	
	

	public class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			spaceShip.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			spaceShip.keyPressed(e);
		}
	}

	public void checkCollisions() {

		Rectangle2D spaceShipBounds = spaceShip.getBounds();
		Rectangle2D asteroidBounds;
		Rectangle2D meteoriteBounds;
		Rectangle2D missileBounds;
		Rectangle2D enemyBounds;
		Rectangle2D bombBounds;
		Rectangle2D bombeVagantiBounds;

		for (Meteorite meteorite : meteorites) {

			meteoriteBounds = meteorite.getBounds();

			if (meteoriteBounds.intersects(spaceShipBounds)) {
				timer.stop();
				MainFrame.getIstance().updateModalita("game_over");
			}

		}

		for (Asteroid asteroid : asteroids) {

			asteroidBounds = asteroid.getBounds();

			if (spaceShipBounds.intersects(asteroidBounds)) {
				timer.stop();
				MainFrame.getIstance().updateModalita("game_over");
			}

			for (Missile missile : missiles) {
				missileBounds = missile.getBounds();

				if (missileBounds.intersects(asteroidBounds)) {

					missile.setVisible(false);

					asteroid.setVisible(false);
				}

			}
		}
		
		for(EnemiesSpaceShip enemy : enemies) {
			
			enemyBounds = enemy.getBounds();
			//System.out.println(bombBounds);
			for(Missile missile : missiles) {
				missileBounds = missile.getBounds();
				if(missileBounds.intersects(enemyBounds)) {
				missile.setVisible(false);
				enemy.setVisible(false);
				
				}
			}
			
			if(enemyBounds.intersects(spaceShipBounds)) {
				timer.stop();
				MainFrame.getIstance().updateModalita("game_over");
			}
			
			for(Bomb bomb : enemy.getBombs()) {
				bombBounds = bomb.getBounds();
				if(bombBounds.intersects(spaceShipBounds)) {
					bomb.setVisible(false);
					timer.stop();
					MainFrame.getIstance().updateModalita("game_over");
				}
			}
			
		}
		if(!bombeVaganti.isEmpty()) {
		for(Bomb bomb : bombeVaganti){
			bombeVagantiBounds = bomb.getBounds();
			if(bombeVagantiBounds.intersects(spaceShipBounds)) {
				bomb.setVisible(false);
				timer.stop();
				MainFrame.getIstance().updateModalita("game_over");
			}
		}
		}
		
	}
}

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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.patterns.factoryMethod.SpriteFactory;

@SuppressWarnings("serial")
public class PanelEsecuzione extends JPanel implements ActionListener {
	private MainFrame mainframe = MainFrame.getIstance();
	private String fileNameSpaceShip, fileNameLife, fileNameEnemy, fileNameBomb;
	private SpaceShip spaceShip;
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
	private List<Meteorite> meteorites;
	private List<Bomb> bombeVaganti;
	private Deque<Life> lives;
	private BufferedImage scrollingBackground;
	private int yOffset = 0; //variabile per lo scrollingBackground
	private int yDelta = 1;  //variabile per lo scrollingBackground
	private static int countToAddAsteroid = 0;
	private static int countToAddMeteorite = 0;
	private static int countToAddEnemies = 0;
	private final int DELAY = 20;
	private Timer timer;
	private JLabel labelLiveScore;
	private JLabel labelScoreUpdate;
	private JDialog dialog;
	private List<EnemySpaceShip> enemies;
	private boolean flagPause = false;
	private String scoreUpdate = "";
	private int count = 0; //serve per conteggiare il tempo in cui la label del bonus rimane sullo schermo

	public PanelEsecuzione() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(false);
		mainframe.getScore().setScoreValue(0);
		this.labelLiveScore = new JLabel("Live Score: " + Integer.toString(mainframe.getScore().getScoreValue()));
		this.labelScoreUpdate = new JLabel("");
		this.add(this.labelLiveScore);
		this.add(this.labelScoreUpdate);
		this.labelScoreUpdate.setVisible(false);
		
		this.setLayout(null);

		this.labelLiveScore.setBounds(10, 10, 400, 50);
		this.labelLiveScore.setForeground(Color.WHITE);
		this.labelLiveScore.setFont(new Font("Serif", Font.BOLD, 22));
		
		this.labelScoreUpdate.setBounds(200, 10, 400, 50);
		this.labelScoreUpdate.setForeground(Color.RED);
		this.labelScoreUpdate.setFont(new Font("Serif", Font.BOLD, 22));
		
		this.fileNameSpaceShip = "../resources/images/spaceship.png";
		this.fileNameEnemy = "../resources/images/firstEnemy.png";
		this.fileNameLife = "../resources/images/life.png";
		this.fileNameBomb = "../resources/images/missile_enemy.png";
		
		this.spaceShip = new SpaceShip(500, 400, fileNameSpaceShip);
		this.missiles = this.spaceShip.getMissiles();
		this.asteroids = new ArrayList<Asteroid>();
		this.meteorites = new ArrayList<Meteorite>();
		this.lives = new ArrayDeque<Life>();
		this.initLives(lives);
		this.enemies = new ArrayList<EnemySpaceShip>();
		this.bombeVaganti = new ArrayList<Bomb>();

		try {
			this.scrollingBackground = ImageIO.read(getClass().getResource("../resources/images/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

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

		for (Life life : lives) {
			g2d.drawImage(life.getImage(), life.getX(), life.getY(), this);
		}
		
		if(!bombeVaganti.isEmpty()) {
			for (Bomb bomb : bombeVaganti) {
				g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
			}
		}
		
		for(EnemySpaceShip enemy : enemies) {
        	List<Bomb> lista = enemy.getBombs();
        	g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), 50, 60, this);
        	
        	for(Bomb bomb : lista) {
        		g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
        	}
     
        }

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (flagPause) {
			if (dialog == null) {
				DialogStart deDialogPanel = new DialogStart(this);
				dialog = new JDialog();
				dialog.getContentPane().add(deDialogPanel); 
				dialog.setUndecorated(true); 
				dialog.pack(); 
				dialog.setAlwaysOnTop(true);
				dialog.setLocationRelativeTo(this);
				dialog.setVisible(true);
			}
		} else {
			if (dialog != null) {
				dialog.dispose();
				dialog.setVisible(false);
				dialog = null;
			}
			
			if (count < 100) {
				count++;
			}
			else {
				this.labelScoreUpdate.setVisible(false);
			}
			
			this.updateSpaceShip();
			this.updateMissiles();
			this.updateObstacles();
			this.updateBombs();
			this.updateBombeVaganti();
			this.updateEnemies();
			this.updateLives();
			this.checkCollisions();
			this.yOffset += this.yDelta;

			mainframe.getScore().updateScoreValue(1);
			this.labelLiveScore.setText("Live Score: " + Integer.toString(mainframe.getScore().getScoreValue()));
			this.labelScoreUpdate.setText(this.scoreUpdate);
			this.repaint();
		}

	}

	public boolean isFlagPause() {
		return flagPause;
	}

	public void setFlagPause(boolean flagPause) {
		this.flagPause = flagPause;
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

		// maggiore � il valore minore � la frequenza di uscita degli asteroidi
		if (countToAddAsteroid >= 150) {
			asteroids.add((Asteroid) new SpriteFactory().getSprite("asteroid"));  //FACTORY METHOD TO CREATE ASTEROIDS
			countToAddAsteroid = 0;
		}
		countToAddAsteroid++;

		if (countToAddMeteorite >= 150) {
			meteorites.add((Meteorite) new SpriteFactory().getSprite("meteorite"));  //FACTORY METHOD TO CREATE METEORITES
			countToAddMeteorite = 0;
		}
		countToAddMeteorite++;

		Iterator<Asteroid> it_asteroids = asteroids.iterator();

		while (it_asteroids.hasNext()) {
			Asteroid asteroid = (Asteroid) it_asteroids.next();
			if (asteroid.getY() >= 600 || !asteroid.isVisible()) {
				it_asteroids.remove();
			} else {
				asteroid.move();
				asteroid.setBounds();
			}
		}

		Iterator<Meteorite> it_meteorites = meteorites.iterator();

		while (it_meteorites.hasNext()) {
			Meteorite meteorite = (Meteorite) it_meteorites.next();
			if (meteorite.getY() >= 600 || !meteorite.isVisible()) {
				it_meteorites.remove();
			} else {
				meteorite.move();
				meteorite.setBounds();
			}
		}
	}

	public void initLives(Deque<Life> lives) {
		Life life;
		int xCoordLife = 10;

		for (int i = 0; i < 3; i++) {
			final int shift = 30; // COSTANTE
			life = new Life(xCoordLife, 60, fileNameLife);
			lives.add(life);
			xCoordLife += shift;
		}
	}

	public void updateLives() {
		Life life = lives.getLast();
		if (life.isVisible() == false) {
			lives.removeLast();
		}
	}
	
	public void updateEnemies() {
		
		int D_W = 1000; //COSTANTE
		int D_H = 600; // COSTANTE
		Random random = new Random();
		int randX1;
		
		if (countToAddEnemies >= 150) {
			randX1 = random.nextInt(D_W);
			enemies.add(new EnemySpaceShip(randX1, -20, fileNameEnemy));
			enemies.get(enemies.size()-1).fire();
			countToAddEnemies = 0;
		}
		countToAddEnemies++;
		
		Iterator<EnemySpaceShip> et = enemies.iterator();
		
    	while(et.hasNext()) {
    		EnemySpaceShip enemy = (EnemySpaceShip)et.next();
    		if (enemy.getY() >= D_H || !enemy.isVisible()) {
    			bombeVaganti = enemy.getBombs();;
				et.remove();
			} else {
				enemy.fire();
				enemy.move();
				enemy.setBounds();
			}
    		
    	}
	}
	
	private void updateBombs() {
		
		for(int i=0; i< enemies.size();i++) {
			List<Bomb> bombs = enemies.get(i).getBombs();

			for(int j=0;j< bombs.size();j++) {
				Bomb bomba = bombs.get(j);			
				if(bomba.isVisible()) {
					bomba.move();
					bomba.setBounds();
		        	if(bomba.getY()>650){		        		
//		        		bomba.setY(enemies.get(i).getY()+50);
//		        		bomba.setX(enemies.get(i).getX()+15);
		        		bomba.setVisible(false);
		        	}
				}else {
					bombs.remove(bomba);
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
						bomba.setVisible(false);
					}
				}else {
					bombeVaganti.remove(bomba);
				}
			}
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
				meteorite.removeBounds();
				spaceShip.loseLife();
				lives.getLast().setVisible(false);

				if (spaceShip.getLives() == 0) {
					timer.stop();
					MainFrame.getIstance().updateModalita("game_over");
				} else {
					meteorite.setVisible(false);
				}
			}

		}

		for (Asteroid asteroid : asteroids) {

			asteroidBounds = asteroid.getBounds();

			if (spaceShipBounds.intersects(asteroidBounds)) {
				asteroid.removeBounds();
				spaceShip.loseLife();
				lives.getLast().setVisible(false);

				if (spaceShip.getLives() == 0) {
					timer.stop();
					MainFrame.getIstance().updateModalita("game_over");
				} else {
					asteroid.setVisible(false);
				}
			}

			for (Missile missile : missiles) {
				missileBounds = missile.getBounds();

				if (missileBounds.intersects(asteroidBounds)) {
					missile.removeBounds();
					missile.setVisible(false);
					asteroid.setVisible(false);
					mainframe.getScore().updateScoreValue(100);
					this.scoreUpdate = "+100";
					this.labelScoreUpdate.setVisible(true);
					this.count = 0;
				}

			}
			
			for(EnemySpaceShip enemy : enemies) {
				
				enemyBounds = enemy.getBounds();

				for(Missile missile : missiles) {
					missileBounds = missile.getBounds();
					if(missileBounds.intersects(enemyBounds)) {
						missile.removeBounds();
						missile.setVisible(false);
						enemy.setVisible(false);
						mainframe.getScore().updateScoreValue(500);
						this.scoreUpdate = "+500";
						this.labelScoreUpdate.setVisible(true);
						this.count = 0;
					}
				}
				

				if(enemyBounds.intersects(spaceShipBounds)) {
					enemy.removeBounds();
					
					spaceShip.loseLife();
					lives.getLast().setVisible(false);
					
					if (spaceShip.getLives() == 0) {
						timer.stop();
						MainFrame.getIstance().updateModalita("game_over");
					} else {
						enemy.setVisible(false);
					}
				}
				
				for(Bomb bomb : enemy.getBombs()) {
					bombBounds = bomb.getBounds();
					if(bombBounds.intersects(spaceShipBounds)) {
						bomb.removeBounds();
						spaceShip.loseLife();
						lives.getLast().setVisible(false);
						
						if (spaceShip.getLives() == 0) {
							timer.stop();
							MainFrame.getIstance().updateModalita("game_over");
						} else {
							bomb.setVisible(false);
						}
					}
				}
				
			}
			
			if(!bombeVaganti.isEmpty()) {
				for(Bomb bomb : bombeVaganti){
					bombeVagantiBounds = bomb.getBounds();
					if(bombeVagantiBounds.intersects(spaceShipBounds)) {
						bomb.removeBounds();
						spaceShip.loseLife();
						lives.getLast().setVisible(false);
						if (spaceShip.getLives() == 0) {
							timer.stop();
							MainFrame.getIstance().updateModalita("game_over");
						} else {
							bomb.setVisible(false);
						}
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
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_PAUSE) {
				flagPause = !flagPause;
			} else
				spaceShip.keyPressed(e);
		}
	}
	public JDialog getDialog() {
		return dialog;
	}


}

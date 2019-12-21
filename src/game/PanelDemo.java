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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelDemo extends JPanel implements ActionListener {
	private String fileNameSpaceShip, fileNameAsteroid, fileNameMeteorite, fileNameBomb, fileNameEnemies;
	private SpaceShip spaceShip;
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
	private List<Meteorite> meteorites;
	private List<Bomb> bombeVaganti;
	private BufferedImage scrollingBackground;
	private int yOffset = 0; // variabile per lo scrollingBackground
	private int yDelta = 1; // variabile per lo scrollingBackground
	private static int countToAddAsteroid = 0;
	private static int countToAddMeteorite = 0;
	private static int countToAddEnemies = 0;
	private final int DELAY = 20;
	private Timer timer;
	private List<EnemySpaceShip> enemies;
	private boolean moveSpaceShip = true;
	private JLabel labelMoveSpaceShip;
	private boolean flagEnemies = false;
	private int count = 0;
	private boolean flagObstacles = false;
	private boolean flagSpace = false;

	public PanelDemo() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(false);

		this.setLayout(null);

		this.fileNameSpaceShip = "../resources/images/spaceship.png";
		this.fileNameAsteroid = "../resources/images/asteroid-icon.png";
		this.fileNameMeteorite = "../resources/images/meteorite.png";
		this.fileNameBomb = "../resources/images/missile_enemy.png";
		this.fileNameEnemies = "../resources/images/firstEnemy.png";

		this.spaceShip = new SpaceShip(500, 400, fileNameSpaceShip);
		this.missiles = this.spaceShip.getMissiles();
		this.asteroids = new ArrayList<Asteroid>();
		this.meteorites = new ArrayList<Meteorite>();

		this.enemies = new ArrayList<EnemySpaceShip>();
		this.bombeVaganti = new ArrayList<Bomb>();

		try {
			this.scrollingBackground = ImageIO.read(getClass().getResource("../resources/images/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.labelMoveSpaceShip = new JLabel("Press an arrow to move the spaceship");
		this.add(this.labelMoveSpaceShip);

		this.labelMoveSpaceShip.setBounds(270, 50, 600, 400);
		this.labelMoveSpaceShip.setForeground(Color.WHITE);
		this.labelMoveSpaceShip.setFont(new Font("Serif", Font.BOLD, 30));

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

		if (!bombeVaganti.isEmpty()) {
			for (Bomb bomb : bombeVaganti) {
				g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
			}
		}

		for (EnemySpaceShip enemy : enemies) {
			List<Bomb> lista = enemy.getBombs();
			g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), 50, 60, this);

			for (Bomb bomb : lista) {
				g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
			}

		}

	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(isMoveSpaceShip()) {
//			
//		}
//		else if(isFlagEnemies()) {
//			if(count>50) {
//				setFlagEnemies(false);
//				this.labelMoveSpaceShip.setVisible(false);
//				this.updateEnemy();
//				count=0;
//			}
//			else;
//				count++;
//				this.updateSpaceShip();
//				this.repaint();
//		}
//		else {
//			
//			this.updateMissiles();
////			this.updateObstacles();
////			this.updateBombs();
////			this.updateBombeVaganti();
////			this.updateEnemies();
//			this.moveEnemy();
//			this.checkCollisions();
//			this.yOffset += this.yDelta;
//			this.updateSpaceShip();
//			this.repaint();
//			
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isMoveSpaceShip()) {

		} else if (isFlagObstacles()) {
			if (count > 300) {
				count = 0;
				this.labelMoveSpaceShip.setText("Be careful to enemies");
				this.labelMoveSpaceShip.setVisible(true);
				this.deleteObstacles();
				setFlagObstacles(false);
				setFlagEnemies(true);
			} else if (count > 50) {
				this.labelMoveSpaceShip.setVisible(false);
				this.updateObstacles();
				this.updateSpaceShip();
				this.repaint();
				count++;
			} else {
				count++;
				this.updateSpaceShip();
				this.repaint();
			}
		} else if (isFlagEnemies()) {
			if (count > 50) {
				setFlagEnemies(false);
				setFlagSpace(true);
				this.labelMoveSpaceShip.setVisible(false);
				this.updateEnemy();
				count = 0;
			}
			count++;
			this.updateSpaceShip();
			this.repaint();

		} else if(isFlagSpace()){
			this.labelMoveSpaceShip.setText("Press space to kill the enemies");
			this.labelMoveSpaceShip.setVisible(true);
			this.updateMissiles();
			this.moveEnemy();
			this.checkCollisions();
			this.yOffset += this.yDelta;
			this.updateSpaceShip();
			this.repaint();
		}
		else {
			if(count<50) {
				this.labelMoveSpaceShip.setText("In the space is not so easy");
				this.labelMoveSpaceShip.setVisible(true);
				count++;
			}
			if(count<100) {
				this.labelMoveSpaceShip.setText("Good Game");
				this.labelMoveSpaceShip.setForeground(Color.RED);
				count++;
			}
			else {
				MainFrame.getIstance().updateModalita("play");
			}
			this.updateMissiles();
			this.moveEnemy();
			this.checkCollisions();
			this.yOffset += this.yDelta;
			this.updateSpaceShip();
			this.repaint();
		}
	}

	private void deleteObstacles() {
		meteorites.removeAll(meteorites);
		asteroids.removeAll(asteroids);
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
		int D_W = 1000; // COSTANTE
		int D_H = 600; // COSTANTE

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

	public void updateEnemy() {
//		int D_W = 1000;
//		int D_H = 600;
//		Random random = new Random();
		enemies.add(new EnemySpaceShip(500, 100, fileNameEnemies));
//		if (countToAddEnemies >= 150) {
//			int randX2 = random.nextInt(D_W);
//			enemies.add(new EnemySpaceShip(500, -20, fileNameEnemies));
//			enemies.get(enemies.size() - 1).fire();
//			countToAddEnemies = 0;
//		}
//		countToAddEnemies++;

		Iterator<EnemySpaceShip> et = enemies.iterator();

//		while (et.hasNext()) {
//			EnemySpaceShip enemy = (EnemySpaceShip) et.next();
//			if (enemy.getY() >= D_H || !enemy.isVisible()) {
//				bombeVaganti = enemy.getBombs();
//				;
//				et.remove();
//			} else {
//				enemy.fire();
//				enemy.move();
//				enemy.setBounds();
//			}
//
//		}
		while (et.hasNext()) {
			EnemySpaceShip enemy = (EnemySpaceShip) et.next();
			if (!enemy.isVisible()) {
				et.remove();
			} else {
				enemy.move1();
				enemy.setBounds();
			}
		}
	}

	public void moveEnemy() {
		Iterator<EnemySpaceShip> et = enemies.iterator();

//		while (et.hasNext()) {
//			EnemySpaceShip enemy = (EnemySpaceShip) et.next();
//			if (enemy.getY() >= D_H || !enemy.isVisible()) {
//				bombeVaganti = enemy.getBombs();
//				;
//				et.remove();
//			} else {
//				enemy.fire();
//				enemy.move();
//				enemy.setBounds();
//			}
//
//		}
		while (et.hasNext()) {
			EnemySpaceShip enemy = (EnemySpaceShip) et.next();
			if (!enemy.isVisible()) {
				et.remove();
			}
		}
	}

	public void updateEnemies() {
		int D_W = 1000;
		int D_H = 600;
		Random random = new Random();

		if (countToAddEnemies >= 150) {
			int randX2 = random.nextInt(D_W);
			enemies.add(new EnemySpaceShip(randX2, -20, fileNameEnemies));
			enemies.get(enemies.size() - 1).fire();
			countToAddEnemies = 0;
		}
		countToAddEnemies++;

		Iterator<EnemySpaceShip> et = enemies.iterator();

		while (et.hasNext()) {
			EnemySpaceShip enemy = (EnemySpaceShip) et.next();
			if (enemy.getY() >= D_H || !enemy.isVisible()) {
				bombeVaganti = enemy.getBombs();
				;
				et.remove();
			} else {
				enemy.fire();
				enemy.move();
				enemy.setBounds();
			}

		}
	}

	private void updateBombs() {

		for (int i = 0; i < enemies.size(); i++) {
			List<Bomb> bombs = enemies.get(i).getBombs();

			for (int j = 0; j < bombs.size(); j++) {
				Bomb bomba = bombs.get(j);
				if (bomba.isVisible()) {
					bomba.move();
					bomba.setBounds();
					if (bomba.getY() > 650) {
//		        		bomba.setY(enemies.get(i).getY()+50);
//		        		bomba.setX(enemies.get(i).getX()+15);
						bomba.setVisible(false);
					}
				} else {
					bombs.remove(bomba);
				}
			}
		}

	}

	public void updateBombeVaganti() {
		if (!bombeVaganti.isEmpty()) {
			for (int i = 0; i < bombeVaganti.size(); i++) {
				Bomb bomba = bombeVaganti.get(i);
				if (bomba.isVisible()) {
					bomba.move();
					bomba.setBounds();
					if (bomba.getY() > 650) {
						bomba.setVisible(false);
					}
				} else {
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

//		for (Meteorite meteorite : meteorites) {
//
//			meteoriteBounds = meteorite.getBounds();
//
//			if (meteoriteBounds.intersects(spaceShipBounds)) {
//				meteorite.removeBounds();
//				meteorite.setVisible(false);
//				
//			}
//
//		}

//		for (Asteroid asteroid : asteroids) {
//
//			asteroidBounds = asteroid.getBounds();
//
//			if (spaceShipBounds.intersects(asteroidBounds)) {
//				asteroid.removeBounds();
//				asteroid.setVisible(false);
//				
//			}
//
//			for (Missile missile : missiles) {
//				missileBounds = missile.getBounds();
//
//				if (missileBounds.intersects(asteroidBounds)) {
//					missile.removeBounds();
//					missile.setVisible(false);
//					asteroid.setVisible(false);
//				}
//
//			}
//
//			for (EnemySpaceShip enemy : enemies) {
//
//				enemyBounds = enemy.getBounds();
//
//				for (Missile missile : missiles) {
//					missileBounds = missile.getBounds();
//					if (missileBounds.intersects(enemyBounds)) {
//						missile.removeBounds();
//						missile.setVisible(false);
//						enemy.setVisible(false);
//					}
//				}
//
//				if (enemyBounds.intersects(spaceShipBounds)) {
//					enemy.removeBounds();
//					enemy.setVisible(false);
//					
//				}
//
//				for (Bomb bomb : enemy.getBombs()) {
//					bombBounds = bomb.getBounds();
//					if (bombBounds.intersects(spaceShipBounds)) {
//						bomb.removeBounds();
//						bomb.setVisible(false);
//						
//					}
//				}
//
//			}
//
//			if (!bombeVaganti.isEmpty()) {
//				for (Bomb bomb : bombeVaganti) {
//					bombeVagantiBounds = bomb.getBounds();
//					if (bombeVagantiBounds.intersects(spaceShipBounds)) {
//						bomb.removeBounds();
//						bomb.setVisible(false);
//					}
//				}
//			}
//		}

		for (EnemySpaceShip enemy : enemies) {

			enemyBounds = enemy.getBounds();

			for (Missile missile : missiles) {
				missileBounds = missile.getBounds();
				if (missileBounds.intersects(enemyBounds)) {
					missile.removeBounds();
					missile.setVisible(false);
					enemy.setVisible(false);
					setFlagSpace(false);
				}
			}
		}
	}

	public boolean isMoveSpaceShip() {
		return moveSpaceShip;
	}

	public void setMoveSpaceShip(boolean moveSpaceShip) {
		this.moveSpaceShip = moveSpaceShip;
	}

	public boolean isFlagEnemies() {
		return flagEnemies;
	}

	public void setFlagEnemies(boolean flagEnemies) {
		this.flagEnemies = flagEnemies;
	}

	public boolean isFlagObstacles() {
		return flagObstacles;
	}

	public void setFlagObstacles(boolean flagObstacles) {
		this.flagObstacles = flagObstacles;
	}

	public boolean isFlagSpace() {
		return flagSpace;
	}

	public void setFlagSpace(boolean flagSpace) {
		this.flagSpace = flagSpace;
	}

	public class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			spaceShip.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (isMoveSpaceShip() && (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_DOWN
					|| key == KeyEvent.VK_UP)) {
				labelMoveSpaceShip.setText("Avoid meteorites and asteroids");
				labelMoveSpaceShip.setBounds(330, 50, 600, 400);
				labelMoveSpaceShip.setFont(new Font("Serif", Font.BOLD, 40));
				setFlagObstacles(true);
				setFlagEnemies(false);
				setMoveSpaceShip(false);
			} else if(isFlagSpace() || !(key == KeyEvent.VK_SPACE))
				spaceShip.keyPressed(e);

		}
	}

}

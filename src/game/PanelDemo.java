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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelDemo extends JPanel implements ActionListener {
	private String fileNameSpaceShip, fileNameAsteroid, fileNameMeteorite, fileNameEnemies, fileNameLife;
	private SpaceShip spaceShip;
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
	private List<Meteorite> meteorites;
	private BufferedImage scrollingBackground;
	private int yOffset = 0; // variabile per lo scrollingBackground
	private int yDelta = 1; // variabile per lo scrollingBackground
	private static int countToAddAsteroid = 0;
	private static int countToAddMeteorite = 0;
	private Deque<Life> lives;
	private final int DELAY = 20;
	private Timer timer;
	private List<EnemySpaceShip> enemies;
	private boolean moveSpaceShip = true;
	private JLabel labelMoveSpaceShip;
	private boolean flagEnemies = false;
	private int count = 0;
	private boolean flagObstacles = false;
	private boolean flagSpace = false;
	private int countAhia = 0;
	private JLabel labelLiveScore;

	public PanelDemo() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(false);

		this.setLayout(null);
		
		this.labelLiveScore = new JLabel("Live Score: " + Integer.toString(5231));
		this.add(this.labelLiveScore);

		this.labelLiveScore.setBounds(10, 10, 400, 50);
		this.labelLiveScore.setForeground(Color.WHITE);
		this.labelLiveScore.setFont(new Font("Serif", Font.BOLD, 22));
		
		this.fileNameLife = "../resources/images/life.png";
		
		this.fileNameSpaceShip = "../resources/images/spaceship.png";
		this.fileNameAsteroid = "../resources/images/asteroid-icon.png";
		this.fileNameMeteorite = "../resources/images/meteorite.png";
		this.fileNameEnemies = "../resources/images/firstEnemy.png";

		this.spaceShip = new SpaceShip(350, 500, fileNameSpaceShip);
		this.missiles = this.spaceShip.getMissiles();
		this.asteroids = new ArrayList<Asteroid>();
		this.meteorites = new ArrayList<Meteorite>();
		this.lives = new ArrayDeque<Life>();
		this.initLives(lives);

		this.enemies = new ArrayList<EnemySpaceShip>();

		try {
			this.scrollingBackground = ImageIO.read(getClass().getResource("../resources/images/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.labelMoveSpaceShip = new JLabel("Press an arrow to move the spaceship");
		this.add(this.labelMoveSpaceShip);

		this.labelMoveSpaceShip.setBounds(140, 70, 600, 400);
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


		for (EnemySpaceShip enemy : enemies) {
			List<Bomb> lista = enemy.getBombs();
			g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), 50, 60, this);

			for (Bomb bomb : lista) {
				g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
			}

		}
		
		for (Life life : lives) {
			g2d.drawImage(life.getImage(), life.getX(), life.getY(), this);
		}

	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (isMoveSpaceShip()) {

		} else if (isFlagObstacles()) {
			if (count > 800) {
				count = 0;
				this.labelMoveSpaceShip.setText("Be careful to enemies");
				this.labelMoveSpaceShip.setForeground(Color.WHITE);
				this.labelMoveSpaceShip.setVisible(true);
				this.deleteObstacles();
				setFlagObstacles(false);
				setFlagEnemies(true);
			} else if (count > 51) {
				if (this.labelMoveSpaceShip.isVisible() && countAhia < 20) {
					countAhia++;
				} else {
					this.labelMoveSpaceShip.setVisible(false);
				}
				this.updateLives();
				this.updateObstacles();
				this.updateSpaceShip();
				this.checkCollisions();
				this.repaint();
				count++;
			} else if (count > 50) {
				this.labelMoveSpaceShip.setVisible(false);
				this.updateLives();
				this.updateObstacles();
				this.updateSpaceShip();
				this.checkCollisions();
				this.repaint();
				count++;
			} else {
				count++;
				this.updateLives();
				this.checkCollisions();
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

		} else if (isFlagSpace()) {
			this.labelMoveSpaceShip.setText("Press space to kill the enemies");
			this.labelMoveSpaceShip.setVisible(true);
			this.updateMissiles();
			this.moveEnemy();
			this.checkCollisions();
			this.yOffset += this.yDelta;
			this.updateSpaceShip();
			this.repaint();
		} else {
			if (count < 50) {
				this.labelMoveSpaceShip.setText("In the space is not so easy");
				this.labelMoveSpaceShip.setVisible(true);
				count++;
			}
			else if (count < 100) {
				this.labelMoveSpaceShip.setText("Good Game");
				this.labelMoveSpaceShip.setForeground(Color.RED);
				count++;
			} else {
				timer.stop();
				MainFrame.getIstance().updateModalita("in_esecuzione");
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
		enemies.add(new EnemySpaceShip(500, 100, fileNameEnemies));
		Iterator<EnemySpaceShip> et = enemies.iterator();
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
		while (et.hasNext()) {
			EnemySpaceShip enemy = (EnemySpaceShip) et.next();
			if (!enemy.isVisible()) {
				et.remove();
			}
		}
	}

	public void checkCollisions() {

		Rectangle2D spaceShipBounds = spaceShip.getBounds();
		Rectangle2D asteroidBounds;
		Rectangle2D meteoriteBounds;
		Rectangle2D missileBounds;
		Rectangle2D enemyBounds;

		for (Meteorite meteorite : meteorites) {

			meteoriteBounds = meteorite.getBounds();

			if (meteoriteBounds.intersects(spaceShipBounds)) {
				meteorite.removeBounds();
				countAhia = 0;
				this.labelMoveSpaceShip.setForeground(Color.RED);
				this.labelMoveSpaceShip.setText("AHIA, you lost a life");
				this.labelMoveSpaceShip.setVisible(true);
				
				
				if (lives.size()==0) {
					//passaggio alla fase successiva
				} else {
					lives.getLast().setVisible(false);
					meteorite.setVisible(false);
				}

			}

		}

		for (Asteroid asteroid : asteroids) {

			asteroidBounds = asteroid.getBounds();

			if (spaceShipBounds.intersects(asteroidBounds)) {
				this.labelMoveSpaceShip.setForeground(Color.RED);
				countAhia = 0;
				asteroid.removeBounds();
				this.labelMoveSpaceShip.setText("AHIA, you lost a life");
				this.labelMoveSpaceShip.setVisible(true);
				
				
				if (lives.size()==0) {
					//passggio alla fase successiva
				} else {
					lives.getLast().setVisible(false);
					asteroid.setVisible(false);
				}

			}

		}

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
		if (lives.size() > 0) {
			Life life = lives.getLast();
			if (life.isVisible() == false) {
				lives.removeLast();
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
				labelMoveSpaceShip.setBounds(140, 70, 600, 400);
				labelMoveSpaceShip.setFont(new Font("Serif", Font.BOLD, 30));
				setFlagObstacles(true);
				setFlagEnemies(false);
				setMoveSpaceShip(false);
			} else if (isFlagSpace() || !(key == KeyEvent.VK_SPACE))
				spaceShip.keyPressed(e);

		}
	}

}

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
import javax.swing.JTextArea;
import javax.swing.Timer;

import game.patterns.factoryMethodBonus.BonusFactory;

@SuppressWarnings("serial")
public class PanelDemo extends JPanel implements ActionListener {
	private String fileNameSpaceShip, fileNameAsteroid, fileNameMeteorite, fileNameEnemies, fileNameLife, fileRedArrow;
	private JLabel levelLabel;
	private SpaceShip spaceShip;
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
	private List<Meteorite> meteorites;
	private List<EnemySpaceShip> enemies;
	private List<ScoreBonus> scoreBonus;
	private List<LifeBonus> lifeBonus;
	private Deque<Life> lives;
	private BufferedImage scrollingBackground;
	private int yOffsetScrolling = 0;
	private int yDeltaScrolling = 1; 
	private static int countForStepToAddAsteroid = 120;
	private static int countForStepToAddMeteorite = 50;
	private static int countForStepToScoreBonus = 200;
	private static int countForStepToLifeBonus = 280;
	private final int DELAY = 20;
	private Timer timer;
	private boolean moveSpaceShip = false;
	private boolean flagScore = true;
	private boolean flagLife = false;
	private JLabel labelText;
	private boolean flagEnemies = false;
	private int countForStep = 0;
	private boolean flagObstacles = false;
	private boolean flagSpace = false;
	private int countForStepDefeat = 0;
	private JLabel labelLiveScore;
	private JTextArea textArea;
	private boolean flagBonus = false;
	private boolean flagBonusTrue = false;
	private boolean flagScoreBonus=false;
	private boolean flagLifeBonus=false;

	/**
	 * 
	 */
	public PanelDemo() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(false);
		this.setLayout(null);		
		this.levelLabel = new JLabel("Level: 1");
		this.labelLiveScore = new JLabel("Live Score: " + Integer.toString(5231));
		this.add(this.labelLiveScore);
		this.labelLiveScore.setBounds(10, 10, 400, 50);
		this.labelLiveScore.setForeground(Color.GREEN);
		this.labelLiveScore.setFont(new Font("Serif", Font.BOLD, 22));
		this.textArea = new JTextArea(
				"This number indicates the score scored \nduring the game.\nIf you hit an enemy and destroy obstacles \nthe score will increase faster.");
		this.add(this.textArea);
		this.textArea.setBounds(200, 130, 300, 100);
		this.textArea.setBackground(Color.green);
		this.textArea.setFont(new Font("Serif", Font.BOLD, 16));
		this.textArea.setEditable(false);

		this.fileNameLife = "../resources/images/life.png";
		this.fileRedArrow = "../resources/images/freccia-png-rossa-ok.png";
		this.fileNameSpaceShip = "../resources/images/spaceship.png";
		this.fileNameAsteroid = "../resources/images/asteroid-icon.png";
		this.fileNameMeteorite = "../resources/images/meteorite.png";
		this.fileNameEnemies = "../resources/images/firstEnemy.png";

		this.spaceShip = new SpaceShip(350, 500, fileNameSpaceShip);
		this.missiles = this.spaceShip.getMissiles();
		this.asteroids = new ArrayList<Asteroid>();
		this.scoreBonus = new ArrayList<ScoreBonus>();
		this.lifeBonus = new ArrayList<LifeBonus>();
		this.meteorites = new ArrayList<Meteorite>();
		this.lives = new ArrayDeque<Life>();
		this.initLives(lives);
		this.enemies = new ArrayList<EnemySpaceShip>();

		try {
			this.scrollingBackground = ImageIO.read(getClass().getResource("../resources/images/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.labelText = new JLabel("Press ESC to skip this part");
		this.add(this.labelText);
		this.labelText.setVisible(true);
		this.labelText.setBounds(140, 100, 600, 400);
		this.labelText.setForeground(Color.WHITE);
		this.labelText.setFont(new Font("Serif", Font.BOLD, 30));		
		this.levelLabel.setBounds(10, 35, 400, 50);
		this.levelLabel.setForeground(Color.WHITE);
		this.levelLabel.setFont(new Font("Serif", Font.BOLD, 22));
		this.levelLabel.setVisible(true);
		this.add(this.levelLabel);

		this.timer = new Timer(DELAY, this);
		this.timer.start();
	}

	/**
	 *
	 */
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		if (scrollingBackground != null) {
			Graphics2D g2d = (Graphics2D) g.create();

			int xPos = (getWidth() - scrollingBackground.getWidth()) / 2;
			int yPos = yOffsetScrolling;

			while (yPos > 0) {
				yPos -= scrollingBackground.getHeight();
				g2d.drawImage(scrollingBackground, xPos, yPos, this);
			}

			yPos = yOffsetScrolling;
			
			while (yPos < getHeight()) {
				g2d.drawImage(scrollingBackground, xPos, yPos, this);
				yPos += scrollingBackground.getHeight();
			}

			g2d.dispose();
		}

		try {
			doDrawing(g);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * @param g
	 * @throws IOException
	 */
	private void doDrawing(Graphics g) throws IOException {

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
		for (LifeBonus life: this.lifeBonus) {
			g2d.drawImage(life.getImage(), life.getX(), life.getY(), this);
		}		
		for (ScoreBonus score: this.scoreBonus) {
			g2d.drawImage(score.getImage(), score.getX(), score.getY(), this);
		}
		for (Life life : lives) {
			g2d.drawImage(life.getImage(), life.getX(), life.getY(), this);
		}
		
		if (flagScore)
			g2d.drawImage(ImageIO.read(getClass().getResource(fileRedArrow)), 200, 5, this);
		
		if (flagLife)
			g2d.drawImage(ImageIO.read(getClass().getResource(fileRedArrow)), 150, 50, this);

	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (flagScore) {
			this.stepScore();
		} else if (flagLife) {
			this.stepLife();
		} else if (isMoveSpaceShip()) {
			this.stepSpaceship();
		} else if (isFlagObstacles()) {
			this.stepObstacles();
		} else if (isFlagBonus()) {
			this.stepBonus();
		} else if (isFlagBonusTrue()) {
			this.stepBonusTrue();
		}
		else if (isFlagEnemies()) {
			this.stepEnemies();
		} else if (isFlagSpace()) {
			this.stepKillEnemies();
		} else {
			this.stepFinal();		
		}
	}

	/**
	 * 
	 */
	private void stepBonusTrue() {
		if(countForStep>100) {
			this.labelText.setText("Be careful to enemies");
			this.labelText.setForeground(Color.WHITE);
			this.labelText.setVisible(true);
			setFlagEnemies(true);
			setFlagBonusTrue(false);
			countForStep = 0;
		}
		countForStep++;
	}

	/**
	 * 
	 */
	private void stepBonus() {
		if(flagLifeBonus && flagScoreBonus) {
			setFlagBonus(false);
			setFlagBonusTrue(true);
			countForStep=0;
			deleteBonus();
			this.repaint();
		}
		else if (countForStep > 800 ) {
			countForStep = 0;
			this.labelText.setText("Be careful to enemies");
			this.labelText.setForeground(Color.WHITE);
			this.labelText.setVisible(true);
			setFlagEnemies(true);
			setFlagBonus(false);
		} else if (countForStep > 51) {
			this.updateLives();
			this.updateBonus();
			this.updateSpaceShip();
			this.checkCollisions();
			this.repaint();
			countForStep++;
		} else if (countForStep > 50) {
			this.labelText.setVisible(false);
			this.updateLives();
			this.updateBonus();
			this.updateSpaceShip();
			this.checkCollisions();
			this.repaint();
			countForStep++;
		} else {
			countForStep++;
			this.updateLives();
			this.updateBonus();
			this.checkCollisions();
			this.updateSpaceShip();
			this.deleteObstacles();
			this.repaint();
		}
	}

	/**
	 * 
	 */
	private void stepLife() {
		if (countForStep > 500) {
			flagLife = false;
			countForStep = 0;
			this.textArea.setVisible(false);
			moveSpaceShip = true;
			this.repaint();
		}
		countForStep++;
	}

	/**
	 * 
	 */
	private void stepScore() {
		if (countForStep > 500) { 
			flagScore = false;
			countForStep = 0;
			this.textArea.setVisible(false);
			flagLife = true;
			this.textArea = new JTextArea(
					"These are the lives. \nIf you get hit by an obstacle or an enemy \nbullet you will lose one.\r\n"
							+ "If you reach zero you will be \nforced to start again.");
			this.add(this.textArea);
			this.textArea.setBounds(200, 150, 300, 120);
			this.textArea.setBackground(Color.green);
			this.textArea.setFont(new Font("Serif", Font.BOLD, 16));
			this.textArea.setEditable(false);
			this.repaint();
		}
		countForStep++;
	}

	/**
	 * 
	 */
	private void stepFinal() {
		if (countForStep < 70) {
			this.labelText.setText("In the space is not so easy");
			this.labelText.setForeground(Color.WHITE);
			this.labelText.setVisible(true);
			countForStep++;
		} else if (countForStep < 120) {
			this.labelText.setText("Good Game");
			this.labelText.setForeground(Color.RED);
			countForStep++;
		} else {
			timer.stop();
			if(Settings.soundMusic == true) {
				DemoFrame.soundInGame.stopSound();	
				}			
			MainFrame.getIstance().updateModality("running");
		}
		this.updateMissiles();
		this.moveEnemy();
		this.checkCollisions();
		this.yOffsetScrolling += this.yDeltaScrolling;
		this.updateSpaceShip();
		this.repaint();
	}

	/**
	 * 
	 */
	private void stepKillEnemies() {
		this.labelText.setText("Press space to kill the enemies");
		this.labelText.setForeground(Color.WHITE);
		this.labelText.setVisible(true);
		this.updateMissiles();
		this.moveEnemy();
		this.checkCollisions();
		this.yOffsetScrolling += this.yDeltaScrolling;
		this.updateSpaceShip();
		this.repaint();

	}

	/**
	 * 
	 */
	private void stepEnemies() {
		if (countForStep > 50) {
			setFlagEnemies(false);
			setFlagSpace(true);
			this.labelText.setVisible(false);
			this.updateEnemy();
			countForStep = 0;
		}
		countForStep++;
		this.deleteBonus();
		this.updateLives();
		this.deleteObstacles();
		this.updateSpaceShip();
		this.repaint();

	}

	/**
	 * 
	 */
	private void stepSpaceship() {
		if (moveSpaceShip) {
			this.textArea.setVisible(false);
			this.labelText.setText("Press an arrow to move the spaceship");
			this.repaint();
		}
	}

	/**
	 * 
	 */
	private void stepObstacles() {
		if (countForStep > 800) {
			countForStep = 0;
			this.labelText.setText("There aren't only bad things. Take a bonus");
			this.labelText.setForeground(Color.WHITE);
			this.labelText.setVisible(true);
			this.deleteObstacles();
			setFlagObstacles(false);
			setFlagBonus(true);
		} else if (countForStep > 100) {
			if (this.labelText.isVisible() && countForStepDefeat < 50) {
				countForStepDefeat++;
			} else {
				this.labelText.setVisible(false);
			}
			this.updateLives();
			this.updateObstacles();
			this.updateSpaceShip();
			this.checkCollisions();
			this.repaint();
			countForStep++;
		} else if (countForStep > 100) {
			this.labelText.setVisible(false);
			this.updateLives();
			this.updateObstacles();
			this.updateSpaceShip();
			this.checkCollisions();
			this.repaint();
			countForStep++;
		} else {
			countForStep++;
			this.updateLives();
			this.checkCollisions();
			this.updateSpaceShip();
			this.repaint();
		}
	}

	/**
	 * 
	 */
	private void deleteObstacles() {
		meteorites.removeAll(meteorites);
		asteroids.removeAll(asteroids);
	}
	
	/**
	 * 
	 */
	private void deleteBonus() {
		lifeBonus.removeAll(lifeBonus);
		scoreBonus.removeAll(scoreBonus);
	}

	/**
	 * 
	 */
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

	/**
	 * 
	 */
	public void updateSpaceShip() {
		spaceShip.move();
		spaceShip.setBounds();

	}

	/**
	 * 
	 */
	public void updateObstacles() {
		
		Random random = new Random();
		int yAsteroid = -500;
		int yMeteorite = -500;
		int panelWidth = 800;
		int panelHeight = 800; 

		if (countForStepToAddAsteroid >= 150) {
			int randX1 = random.nextInt(panelWidth);
			asteroids.add(new Asteroid(randX1, yAsteroid, fileNameAsteroid));
			countForStepToAddAsteroid = 0;
		}
		countForStepToAddAsteroid++;

		if (countForStepToAddMeteorite >= 150) {
			int randX2 = random.nextInt(panelWidth);
			meteorites.add(new Meteorite(randX2, yMeteorite, fileNameMeteorite));
			countForStepToAddMeteorite = 0;
		}
		countForStepToAddMeteorite++;

		Iterator<Asteroid> iteratorAsteroids = asteroids.iterator();

		while (iteratorAsteroids.hasNext()) {
			Asteroid asteroid = (Asteroid) iteratorAsteroids.next();
			if (asteroid.getY() >= panelHeight || !asteroid.isVisible()) {
				iteratorAsteroids.remove();
			} else {
				asteroid.move();
				asteroid.setBounds();
			}
		}

		Iterator<Meteorite> iteratorMeteorites = meteorites.iterator();

		while (iteratorMeteorites.hasNext()) {
			Meteorite meteorite = (Meteorite) iteratorMeteorites.next();
			if (meteorite.getY() >= panelHeight || !meteorite.isVisible()) {
				iteratorMeteorites.remove();
			} else {
				meteorite.move();
				meteorite.setBounds();
			}
		}
	}

	/**
	 * 
	 */
	public void updateEnemy() {
		enemies.add(new EnemySpaceShip(350, 100, fileNameEnemies));
		Iterator<EnemySpaceShip> et = enemies.iterator();
		while (et.hasNext()) {
			EnemySpaceShip enemy = (EnemySpaceShip) et.next();
			if (!enemy.isVisible()) {
				et.remove();
			} else {
				enemy.setY(enemy.getY()+1);;
				enemy.setBounds();
			}
		}
	}

	/**
	 * 
	 */
	public void moveEnemy() {
		Iterator<EnemySpaceShip> et = enemies.iterator();
		while (et.hasNext()) {
			EnemySpaceShip enemy = (EnemySpaceShip) et.next();
			if (!enemy.isVisible()) {
				et.remove();
			}
		}
	}

	/**
	 * 
	 */
	private void checkCollisions() {

		Rectangle2D spaceShipBounds = spaceShip.getBounds();
		Rectangle2D asteroidBounds;
		Rectangle2D meteoriteBounds;
		Rectangle2D missileBounds;
		Rectangle2D enemyBounds;
		Rectangle2D scoreBounds;
		Rectangle2D bonusBounds;

		for (Meteorite meteorite : meteorites) {

			meteoriteBounds = meteorite.getBounds();

			if (meteoriteBounds.intersects(spaceShipBounds)) {
				meteorite.removeBoundsEnemies();
				countForStepDefeat = 0;
				this.labelText.setForeground(Color.RED);
				this.labelText.setText("AHIA, you lost a life");
				this.labelText.setVisible(true);
				lives.getLast().setVisible(false);
				if (lives.size() == 1) {
					setFlagObstacles(false);
					setFlagBonus(true);
					countForStep=0;
					this.labelText.setText("There aren't only bad things. Take a bonus");
					this.labelText.setForeground(Color.WHITE);
					this.labelText.setVisible(true);
				}
				meteorite.setVisible(false);
			}

		}
		
		for (LifeBonus life : this.lifeBonus) {
			bonusBounds = life.getBounds();

			if (bonusBounds.intersects(spaceShipBounds)) {
				this.labelText.setText("This bonus gives an additional life");
				this.labelText.setVisible(true);
				this.labelText.setForeground(Color.green);
				life.removeBoundsObstacles();
				int actual_lives = this.spaceShip.getLives();
				if(actual_lives < 6) {
				spaceShip.setLives(actual_lives+1);
				int x_shift = 0;
				if(lives.size()>0) {
					x_shift = lives.getLast().getX();
				}
				lives.add(new Life(x_shift+30,80,fileNameLife));
				lives.getLast().setVisible(true);
				}
				life.removeBoundsObstacles();
				life.setVisible(false);
				flagLifeBonus=true;
			}

		}
		
		for (ScoreBonus score : this.scoreBonus) {
			scoreBounds = score.getBounds();

			if (scoreBounds.intersects(spaceShipBounds)) {
				this.labelText.setText("This bonus gives an incremental score");
				this.labelText.setVisible(true);
				this.labelText.setForeground(Color.green);
				score.removeBoundsBonus();
				score.setVisible(false);
				flagScoreBonus=true;
			}
		}

		for (Asteroid asteroid : asteroids) {
			asteroidBounds = asteroid.getBounds();

			if (spaceShipBounds.intersects(asteroidBounds)) {
				this.labelText.setForeground(Color.RED);
				countForStepDefeat = 0;
				asteroid.removeBoundsEnemies();
				this.labelText.setText("AHIA, you lost a life");
				this.labelText.setVisible(true);
				lives.getLast().setVisible(false);

				if (lives.size() == 1) {
					setFlagObstacles(false);
					setFlagBonus(true);
					countForStep = 0;
					this.labelText.setText("There aren't only bad things. Take a bonus");
					this.labelText.setForeground(Color.WHITE);
					this.labelText.setVisible(true);					
				}
				asteroid.setVisible(false);
			}
		}

		for (EnemySpaceShip enemy : enemies) {
			enemyBounds = enemy.getBounds();

			for (Missile missile : missiles) {
				missileBounds = missile.getBounds();
				if (missileBounds.intersects(enemyBounds)) {
					missile.removeBoundsEnemies();
					missile.setVisible(false);
					enemy.setVisible(false);
					setFlagSpace(false);
				}
			}
		}
	}

	/**
	 * @param lives
	 */
	public void initLives(Deque<Life> lives) {
		Life life;
		int xCoordLife = 10;

		for (int i = 0; i < 3; i++) {
			final int shift = 30; // COSTANTE
			life = new Life(xCoordLife, 80, fileNameLife);
			lives.add(life);
			xCoordLife += shift;
		}
	}

	/**
	 * 
	 */
	public void updateLives() {
		if (lives.size() > 0) {
			Life life = lives.getLast();
			if (life.isVisible() == false) {
				lives.removeLast();
			}
		}
	}
	
	/**
	 * 
	 */
	public void updateBonus() {

		if (countForStepToLifeBonus >= 300 && !flagLifeBonus) {
			lifeBonus.add((LifeBonus) new BonusFactory().getBonus("life"));  //FACTORY METHOD TO CREATE ASTEROIDS
			countForStepToLifeBonus = 0;
		}
		countForStepToLifeBonus++;

		Iterator<LifeBonus> iteratorLifeBonus = lifeBonus.iterator();

		while (iteratorLifeBonus.hasNext()) {
			LifeBonus life = (LifeBonus) iteratorLifeBonus.next();
			if (life.getY() >= 1000 || !life.isVisible()) {
				iteratorLifeBonus.remove();
			} else {
				life.move();
				life.setBounds();
			}
		}

		if (countForStepToScoreBonus >= 300 && !flagScoreBonus) {
			scoreBonus.add((ScoreBonus) new BonusFactory().getBonus("score"));  //FACTORY METHOD TO CREATE ASTEROIDS
			countForStepToScoreBonus = 0;
		}
		countForStepToScoreBonus++;

		Iterator<ScoreBonus> iteratorScoreBonus = scoreBonus.iterator();

		while (iteratorScoreBonus.hasNext()) {
			ScoreBonus score = (ScoreBonus) iteratorScoreBonus.next();
			if (score.getY() >= 1000 || !score.isVisible()) {
				iteratorScoreBonus.remove();
			} else {
				score.move();
				score.setBounds();
			}
		}

	}

	/**
	 * @return
	 */
	public boolean isMoveSpaceShip() {
		return moveSpaceShip;
	}

	/**
	 * @param moveSpaceShip
	 */
	public void setMoveSpaceShip(boolean moveSpaceShip) {
		this.moveSpaceShip = moveSpaceShip;
	}

	/**
	 * @return
	 */
	public boolean isFlagEnemies() {
		return flagEnemies;
	}

	/**
	 * @param flagEnemies
	 */
	public void setFlagEnemies(boolean flagEnemies) {
		this.flagEnemies = flagEnemies;
	}

	/**
	 * @return
	 */
	public boolean isFlagObstacles() {
		return flagObstacles;
	}

	/**
	 * @param flagObstacles
	 */
	public void setFlagObstacles(boolean flagObstacles) {
		this.flagObstacles = flagObstacles;
	}

	/**
	 * @return
	 */
	public boolean isFlagSpace() {
		return flagSpace;
	}

	/**
	 * @param flagSpace
	 */
	public void setFlagSpace(boolean flagSpace) {
		this.flagSpace = flagSpace;
	}

	/**
	 * @return
	 */
	public boolean isFlagBonus() {
		return flagBonus;
	}

	/**
	 * @param flagBonus
	 */
	public void setFlagBonus(boolean flagBonus) {
		this.flagBonus = flagBonus;
	}

	/**
	 * @return
	 */
	public boolean isFlagBonusTrue() {
		return flagBonusTrue;
	}

	/**
	 * @param flagBonusTrue
	 */
	public void setFlagBonusTrue(boolean flagBonusTrue) {
		this.flagBonusTrue = flagBonusTrue;
	}

	public class TAdapter extends KeyAdapter {
		/**
		 *
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			spaceShip.keyReleased(e);
		}

		/**
		 *
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (isMoveSpaceShip() && (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_DOWN
					|| key == KeyEvent.VK_UP)) {
				labelText.setText("Avoid meteorites and asteroids");
				countForStep = 0;
				labelText.setBounds(140, 70, 600, 400);
				labelText.setFont(new Font("Serif", Font.BOLD, 30));
				setFlagObstacles(true);
				setFlagEnemies(false);
				setMoveSpaceShip(false);
			} else if ((flagScore || flagLife) && key == KeyEvent.VK_ESCAPE) {
				flagScore = false;
				flagLife = false;
				moveSpaceShip = true;
			} else if (isFlagSpace() || !(key == KeyEvent.VK_SPACE)) {
				spaceShip.keyPressed(e);
			}

		}
	}

}

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
import game.patterns.factoryMethod.ObstacleFactory;
import game.patterns.factoryMethodBonus.BonusFactory;

@SuppressWarnings("serial")
public class PanelExecution extends JPanel implements ActionListener {
	private MainFrame mainframe = MainFrame.getIstance();
	private String fileNameSpaceShip, fileNameLife, fileNameEnemy;
	private int level = 1;
	private SpaceShip spaceShip;
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
	private List<Meteorite> meteorites;
	private List<Bomb> strayBombs;
	private List<LifeBonus> lifeBonus;
	private Deque<Life> lives;
	private List<ScoreBonus> scoreBonus;
	private List<EnemySpaceShip> enemies;
	private BufferedImage scrollingBackground;
	private int yOffsetScrolling = 0;
	private int yDeltaScrolling = 1;
	private int countToScoreBonus = 0;
	private int countToLifeBonus = 0;
	private int countToAddAsteroid = 0;
	private int countToAddMeteorite = 0;
	private int countToAddEnemies = 0;
	private int countToAddBonusLabel = 0;
	private int countTimeScoreBonus = 0;
	private final int DELAY = 20;
	private Timer timer;
	private JLabel levelLabel;
	private JLabel labelLiveScore;
	private JLabel labelScoreUpdate;
	private JDialog dialogPause;
	private boolean flagPause = false;
	private String scoreUpdate = "";
	private boolean activeBonusScore = false;
	private static int asteroidsDestoyed = 0;
	private static int enemiesDestoyed = 0;

	public PanelExecution() {
		
		this.addKeyListener(new TAdapter());
		this.setFocusable(false);
		this.setLayout(null);
		mainframe.getScore().setScoreValue(0);
		this.levelLabel = new JLabel("");
		this.labelLiveScore = new JLabel("Live Score: " + Integer.toString(mainframe.getScore().getScoreValue()));
		this.labelScoreUpdate = new JLabel("");
		this.add(this.labelLiveScore);
		this.add(this.labelScoreUpdate);
		this.add(this.levelLabel);
		
		this.labelLiveScore.setBounds(10, 10, 400, 50);
		this.labelLiveScore.setForeground(Color.GREEN);
		this.labelLiveScore.setFont(new Font("Serif", Font.BOLD, 22));
		
		this.labelScoreUpdate.setBounds(200, 10, 400, 50);
		this.labelScoreUpdate.setForeground(Color.GREEN);
		this.labelScoreUpdate.setFont(new Font("Serif", Font.BOLD, 22));
		this.labelScoreUpdate.setVisible(false);
		
		this.levelLabel.setBounds(10, 35, 400, 50);
		this.levelLabel.setForeground(Color.WHITE);
		this.levelLabel.setFont(new Font("Serif", Font.BOLD, 22));
		this.levelLabel.setText("Level: " + this.level);
		this.levelLabel.setVisible(true);
		
		this.fileNameSpaceShip = "spaceship.png";
		this.fileNameEnemy = "firstEnemy.png";
		this.fileNameLife = "life.png";
		
		this.spaceShip = new SpaceShip(350,550, fileNameSpaceShip);
		this.scoreBonus = new ArrayList<ScoreBonus>();
		this.lifeBonus = new ArrayList<LifeBonus>();
		this.missiles = this.spaceShip.getMissiles();
		this.asteroids = new ArrayList<Asteroid>();
		this.meteorites = new ArrayList<Meteorite>();
		this.lives = new ArrayDeque<Life>();
		this.initLives(lives);
		this.enemies = new ArrayList<EnemySpaceShip>();
		this.strayBombs = new ArrayList<Bomb>();

		try {
			this.scrollingBackground = ImageIO.read(getClass().getResource("space.jpg"));
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

		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), this);

		List<Missile> missiles = spaceShip.getMissiles();		
		for (LifeBonus life: this.lifeBonus) {
			g2d.drawImage(life.getImage(), life.getX(), life.getY(), this);
		}		
		for (ScoreBonus score: this.scoreBonus) {
			g2d.drawImage(score.getImage(), score.getX(), score.getY(), this);
		}
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
		for (Bomb bomb : strayBombs) {
			g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
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

		if (countToAddBonusLabel < 100) {
			countToAddBonusLabel++;
		}
		else {
			this.labelScoreUpdate.setVisible(false);
		}
		
		this.updateSpaceShip();
		this.updateMissiles();
		this.updateObstacles();
		this.updateBombs();
		this.updatestrayBombs();
		this.updateEnemies();
		this.updateBonus();
		this.updateLives();
		this.checkCollisions();
		
		if (mainframe.getScore().getScoreValue() > 500 * Math.pow((double) level, 2.0)) {
			level++;
			this.levelLabel.setText("Level: " + level);
		}
		
		this.yOffsetScrolling += this.yDeltaScrolling;
		
		if(this.activeBonusScore == true) {
		this.countTimeScoreBonus ++;
		
			if(countTimeScoreBonus==1000) {
				this.activeBonusScore = false;
				this.countTimeScoreBonus = 0;	
				this.labelScoreUpdate.setForeground(Color.green);
			}
		}
	
		mainframe.getScore().updateScoreValue(1);
		this.labelLiveScore.setText("Live Score: " + Integer.toString(mainframe.getScore().getScoreValue()));
		this.labelScoreUpdate.setText(this.scoreUpdate);
		this.repaint();
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

		if (countToAddAsteroid >= 250 / level) {
			asteroids.add((Asteroid) new ObstacleFactory().getObstacle("asteroid"));
			countToAddAsteroid = 0;
		}
		countToAddAsteroid++;

		if (countToAddMeteorite >= 250 / level) {
			meteorites.add((Meteorite) new ObstacleFactory().getObstacle("meteorite"));
			countToAddMeteorite = 0;
		}
		countToAddMeteorite++;

		Iterator<Asteroid> iteratorAsteroids = asteroids.iterator();

		while (iteratorAsteroids.hasNext()) {
			Asteroid asteroid = (Asteroid) iteratorAsteroids.next();
			if (asteroid.getY() >= 800 || !asteroid.isVisible()) {
				iteratorAsteroids.remove();
			} else {
				asteroid.move();
				asteroid.setBounds();
			}
		}

		Iterator<Meteorite> iteratorMeteorites = meteorites.iterator();

		while (iteratorMeteorites.hasNext()) {
			Meteorite meteorite = (Meteorite) iteratorMeteorites.next();
			if (meteorite.getY() >= 800 || !meteorite.isVisible()) {
				iteratorMeteorites.remove();
			} else {
				meteorite.move();
				meteorite.setBounds();
			}
		}
	}
	
	
	public void updateBonus() {

		if (countToLifeBonus >= 600 * level) {
			lifeBonus.add((LifeBonus) new BonusFactory().getBonus("life"));
			countToLifeBonus = 0;
		}
		countToLifeBonus++;

		Iterator<LifeBonus> iteratorLifeBonus = lifeBonus.iterator();

		while (iteratorLifeBonus.hasNext()) {
			LifeBonus life = (LifeBonus) iteratorLifeBonus.next();
			if (life.getY() >= 800 || !life.isVisible()) {
				iteratorLifeBonus.remove();
			} else {
				life.move();
				life.setBounds();
			}
		}
		
		if (countToScoreBonus >= 400 * level) {
			scoreBonus.add((ScoreBonus) new BonusFactory().getBonus("score"));  //FACTORY METHOD TO CREATE ASTEROIDS
			countToScoreBonus = 0;
		}
		countToScoreBonus++;

		Iterator<ScoreBonus> iteratorScoreBonus = scoreBonus.iterator();

		while (iteratorScoreBonus.hasNext()) {
			ScoreBonus score = (ScoreBonus) iteratorScoreBonus.next();
			if (score.getY() >= 800 || !score.isVisible()) {
				iteratorScoreBonus.remove();
			} else {
				score.move();
				score.setBounds();
			}
		}

	}
	
	public void initLives(Deque<Life> lives) {
		Life life;
		int xCoordLife = 10;
		int nLives = 3;
		for (int i = 0; i < nLives; i++) {
			final int shift = 30;
			life = new Life(xCoordLife, 80, fileNameLife);
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
		
		int panelWidth = 800; 
		int panelHeight = 800; 
		Random random = new Random();
		int randX1;
		
		if (countToAddEnemies >= 800 / level) {
			randX1 = random.nextInt(panelWidth);
			enemies.add(new EnemySpaceShip(randX1, -20, fileNameEnemy));
			enemies.get(enemies.size()-1).fire();
			countToAddEnemies = 0;
		}
		countToAddEnemies++;
		
		Iterator<EnemySpaceShip> et = enemies.iterator();
		
    	while(et.hasNext()) {
    		EnemySpaceShip enemy = (EnemySpaceShip)et.next();
    		if (enemy.getY() >= panelHeight || !enemy.isVisible()) {
    			strayBombs = enemy.getBombs();;
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
				Bomb bomb = bombs.get(j);			
				if(bomb.isVisible()) {
					bomb.move();
					bomb.setBounds();
		        	if(bomb.getY()>850){		        		
		        		bomb.setVisible(false);
		        	}
				}else {
					bombs.remove(bomb);
				}
			}
		}
	}
	
	public void updatestrayBombs() {
		for(int i=0; i<strayBombs.size();i++) {
			Bomb bomb = strayBombs.get(i);
			if(bomb.isVisible()) {
				bomb.move();
				bomb.setBounds();
				if(bomb.getY()>850) {
					bomb.setVisible(false);
				}
			}else {
				strayBombs.remove(bomb);
			}
		}
	}

	public void checkCollisions() {

		Rectangle2D spaceShipBounds = spaceShip.getBounds();
		Rectangle2D scoreBounds;
		Rectangle2D bonusBounds;
		Rectangle2D asteroidBounds;
		Rectangle2D meteoriteBounds;
		Rectangle2D missileBounds;
		Rectangle2D enemyBounds;
		Rectangle2D bombBounds;
		Rectangle2D strayBombsBounds;
		int maxLives = 5;	
		for (LifeBonus life : this.lifeBonus) {
			bonusBounds = life.getBounds();
			
			if (bonusBounds.intersects(spaceShipBounds)) {
				life.removeBoundsObstacles();
				int actual_lives = this.spaceShip.getLives();
				
				if(actual_lives < maxLives) {
					spaceShip.setLives(actual_lives+1);
					int x_shift = lives.getLast().getX();
					lives.add(new Life(x_shift+30,80,fileNameLife));
					lives.getLast().setVisible(true);
				}
				life.removeBoundsObstacles();
				life.setVisible(false);
			}

		}
		
		for (ScoreBonus score : this.scoreBonus) {
			scoreBounds = score.getBounds();

			if (scoreBounds.intersects(spaceShipBounds)) {
				score.removeBoundsBonus();
				score.setVisible(false);
				this.activeBonusScore = true;
				this.countTimeScoreBonus = 0;
			}
		}

		for (Meteorite meteorite : meteorites) {
			meteoriteBounds = meteorite.getBounds();
			if (meteoriteBounds.intersects(spaceShipBounds)) {
				meteorite.removeBoundsEnemies();
				spaceShip.setLives(spaceShip.getLives()-1);
				lives.getLast().setVisible(false);
				if (spaceShip.getLives() == 0) {
					timer.stop();
					MainFrame.getIstance().updateModality("game_over");
				} else {
					meteorite.setVisible(false);
				}
			}

		}

		for (Asteroid asteroid : asteroids) {
			asteroidBounds = asteroid.getBounds();

			if (spaceShipBounds.intersects(asteroidBounds)) {
				asteroid.removeBoundsEnemies();
				spaceShip.setLives(spaceShip.getLives()-1);
				lives.getLast().setVisible(false);
				
				if (spaceShip.getLives() == 0) {
					timer.stop();
					MainFrame.getIstance().updateModality("game_over");
				}else {
					asteroid.setVisible(false);
				}
			}

			for (Missile missile : missiles) {
				missileBounds = missile.getBounds();

				if (missileBounds.intersects(asteroidBounds)) {
					PanelExecution.setAsteroidsDestoyed(PanelExecution.getAsteroidsDestoyed()+1);
					missile.removeBoundsEnemies();
					missile.setVisible(false);
					asteroid.setVisible(false);
					if(activeBonusScore == false) {
						mainframe.getScore().updateScoreValue(100);
						this.scoreUpdate = "+100";
					}else {
						mainframe.getScore().updateScoreValue(200);	
						this.scoreUpdate = "+200";
						this.labelScoreUpdate.setForeground(Color.yellow);
					}
					this.labelScoreUpdate.setVisible(true);
					this.countToAddBonusLabel = 0;
				}
			}
			
			for(EnemySpaceShip enemy : enemies) {				
				enemyBounds = enemy.getBounds();

				for(Missile missile : missiles) {
					missileBounds = missile.getBounds();
					if(missileBounds.intersects(enemyBounds)) {
						PanelExecution.setEnemiesDestoyed(PanelExecution.getEnemiesDestoyed()+1);;
						missile.removeBoundsEnemies();
						missile.setVisible(false);
						enemy.setVisible(false);
						if(activeBonusScore == false) {
							mainframe.getScore().updateScoreValue(500);
							this.scoreUpdate = "+500";
						}else {
							mainframe.getScore().updateScoreValue(1000);
							this.scoreUpdate = "+1000";	
							this.labelScoreUpdate.setForeground(Color.yellow);
						}
						this.labelScoreUpdate.setVisible(true);
						this.countToAddBonusLabel = 0;
					}
				}
				

				if(enemyBounds.intersects(spaceShipBounds)) {
					enemy.removeBoundsEnemies();
					
					spaceShip.setLives(spaceShip.getLives()-1);
					lives.getLast().setVisible(false);
					
					if (spaceShip.getLives() == 0) {
						timer.stop();
						MainFrame.getIstance().updateModality("game_over");
					} else {
						enemy.setVisible(false);
					}
				}
				
				for(Bomb bomb : enemy.getBombs()) {
					bombBounds = bomb.getBounds();
					if(bombBounds.intersects(spaceShipBounds)) {
						bomb.removeBoundsEnemies();
						spaceShip.setLives(spaceShip.getLives()-1);
						lives.getLast().setVisible(false);
						
						if (spaceShip.getLives() == 0) {
							timer.stop();
							MainFrame.getIstance().updateModality("game_over");
						} else {
							bomb.setVisible(false);
						}
					}
				}
				
			}

				for(Bomb bomb : strayBombs){
					strayBombsBounds = bomb.getBounds();
					if(strayBombsBounds.intersects(spaceShipBounds)) {
						bomb.removeBoundsEnemies();
						spaceShip.setLives(spaceShip.getLives()-1);
						lives.getLast().setVisible(false);
						if (spaceShip.getLives() == 0) {
							timer.stop();
							MainFrame.getIstance().updateModality("game_over");
						} else {
							bomb.setVisible(false);
						}
					}
				}		
			}
	}

	public class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (flagPause == false && timer.isRunning()){
				spaceShip.keyReleased(e);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_PAUSE) {
				if (flagPause == false) {
					flagPause = true;
					timer.stop();
					
					if (PanelExecution.this.spaceShip.isDown()){
						PanelExecution.this.spaceShip.setDown(false);
					}
					else if (PanelExecution.this.spaceShip.isUp()){
						PanelExecution.this.spaceShip.setUp(false);
					}
					else if (PanelExecution.this.spaceShip.isRight()){
						PanelExecution.this.spaceShip.setRight(false);
					}
					else if (PanelExecution.this.spaceShip.isLeft()){
						PanelExecution.this.spaceShip.setLeft(false);
					}
					
					PanelPause deDialogPanel = new PanelPause(PanelExecution.this);
					dialogPause = new JDialog(PanelExecution.this.mainframe.getFrame(), true);
					dialogPause.getContentPane().add(deDialogPanel); 
					dialogPause.setUndecorated(true); 
					dialogPause.pack(); 
					dialogPause.setAlwaysOnTop(true);
					dialogPause.setLocationRelativeTo(PanelExecution.this);
					dialogPause.setVisible(true);
				}
			}
			
			if (flagPause == false && timer.isRunning()){
				spaceShip.keyPressed(e);
			}
		}
	}
	
	public JDialog getDialogPause() {
		return dialogPause;
	}
	
	public Timer getTimer() {
		return timer;
	}

	public static int getAsteroidsDestoyed() {
		return asteroidsDestoyed;
	}

	public static void setAsteroidsDestoyed(int asteroidsDestoyed) {
		PanelExecution.asteroidsDestoyed = asteroidsDestoyed;
	}

	public static int getEnemiesDestoyed() {
		return enemiesDestoyed;
	}

	public static void setEnemiesDestoyed(int enemiesDestoyed) {
		PanelExecution.enemiesDestoyed = enemiesDestoyed;
	}	

}

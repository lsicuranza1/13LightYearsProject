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
public class PanelEsecuzione extends JPanel implements ActionListener {
	private MainFrame mainframe = MainFrame.getIstance();
	private int level;
	private SpaceShip spaceShip;
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
	private List<Meteorite> meteorites;
	private List<Bomb> strayBombs;
	private List<LifeBonus> lifeBonus;
	private Deque<Life> lives;
	private List<ScoreBonus> scoreBonus;
	private BufferedImage scrollingBackground;
	private int yOffset = 0; //variabile per lo scrollingBackground
	private int yDelta = 1;  //variabile per lo scrollingBackground
	private static int countToScoreBonus = 0;
	private static int countToLifeBonus = 0;
	private int countToAddObstacles = GameConstants.COUNT_TO_ADD_OBSTACLES;
	private int countToAddAsteroid;
	private int countToAddMeteorite;
	private static int countToAddEnemies = 0;
	private final int DELAY = 20;
	private Timer timer;
	private JLabel labelLiveScore;
	private JLabel labelScoreUpdate;
	private JDialog dialog;
	private List<EnemySpaceShip> enemies;
	private boolean flagPause = false;
	private String scoreUpdate = "";
	private int countTimeLabelBonus = 0; //serve per conteggiare il tempo in cui la label del bonus rimane sullo schermo
	private boolean activeBonusScore = false;
	private int countTimeScoreBonus = 0;
	private static int asteroidsDestoyed = 0;
	private static int enemiesDestoyed = 0;

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
		this.labelScoreUpdate.setForeground(Color.GREEN);
		this.labelScoreUpdate.setFont(new Font("Serif", Font.BOLD, 22));
		
		this.level = 1;
		this.spaceShip = new SpaceShip(350,550, GameConstants.fileNameSpaceShip);
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
			this.scrollingBackground = ImageIO.read(getClass().getResource("../resources/images/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.timer = new Timer(DELAY, this);
		this.timer.start();
		
//		new Thread() {
//			public void run() {
//				if (mainframe.getScore().getScoreValue() > GameConstants.SCORE_LEVEL_WON * level) {
//					level++;
//					countToAddObstacles = (int) (countToAddObstacles / GameConstants.DELTA);
//				}
//			}
//		};

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
		
		if(!strayBombs.isEmpty()) {
			for (Bomb bomb : strayBombs) {
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
				PanelPause deDialogPanel = new PanelPause(this);
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
			
			if (countTimeLabelBonus < 100) {
				countTimeLabelBonus++;
			}
			else {
				this.labelScoreUpdate.setVisible(false);
			}
			
			this.updateSpaceShip();
			this.updateMissiles();
			this.updateObstacles(this.countToAddObstacles);
			this.updateBombs();
			this.updateBombeVaganti();
			this.updateEnemies();
			this.updateBonus();
			this.updateLives();
			this.checkCollisions();
			//this.checkForLevelPassed();
			this.yOffset += this.yDelta;
			
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

	public void updateObstacles(int countToAddObstacles) {

		// maggiore � il valore minore � la frequenza di uscita degli asteroidi
		if (countToAddAsteroid >= countToAddObstacles) {
			asteroids.add((Asteroid) new ObstacleFactory().getObstacle("asteroid"));  //FACTORY METHOD TO CREATE ASTEROIDS
			countToAddAsteroid = 0;
		}
		countToAddAsteroid++;

		if (countToAddMeteorite >= countToAddObstacles) {
			meteorites.add((Meteorite) new ObstacleFactory().getObstacle("meteorite"));  //FACTORY METHOD TO CREATE METEORITES
			countToAddMeteorite = 0;
		}
		countToAddMeteorite++;

		Iterator<Asteroid> it_asteroids = asteroids.iterator();

		while (it_asteroids.hasNext()) {
			Asteroid asteroid = (Asteroid) it_asteroids.next();
			if (asteroid.getY() >= GameConstants.GAME_HEIGHT || !asteroid.isVisible()) {
				it_asteroids.remove();
			} else {
				asteroid.move();
				asteroid.setBounds();
			}
		}

		Iterator<Meteorite> it_meteorites = meteorites.iterator();

		while (it_meteorites.hasNext()) {
			Meteorite meteorite = (Meteorite) it_meteorites.next();
			if (meteorite.getY() >= GameConstants.GAME_WIDTH || !meteorite.isVisible()) {
				it_meteorites.remove();
			} else {
				meteorite.move();
				meteorite.setBounds();
			}
		}
	}
	
	
	public void updateBonus() {

		if (countToLifeBonus >= 300) {
			lifeBonus.add((LifeBonus) new BonusFactory().getBonus("life"));  //FACTORY METHOD TO CREATE ASTEROIDS
			countToLifeBonus = 0;
		}
		countToLifeBonus++;

		Iterator<LifeBonus> it_lifeBonus = lifeBonus.iterator();

		while (it_lifeBonus.hasNext()) {
			LifeBonus life = (LifeBonus) it_lifeBonus.next();
			if (life.getY() >= 800 || !life.isVisible()) {
				it_lifeBonus.remove();
			} else {
				life.move();
				life.setBounds();
			}
		}
		
		if (countToScoreBonus >= 300) {
			scoreBonus.add((ScoreBonus) new BonusFactory().getBonus("score"));  //FACTORY METHOD TO CREATE ASTEROIDS
			countToScoreBonus = 0;
		}
		countToScoreBonus++;

		Iterator<ScoreBonus> it_scoreBonus = scoreBonus.iterator();

		while (it_scoreBonus.hasNext()) {
			ScoreBonus score = (ScoreBonus) it_scoreBonus.next();
			if (score.getY() >= 800 || !score.isVisible()) {
				it_scoreBonus.remove();
			} else {
				score.move();
				score.setBounds();
			}
		}

	}
	

	public void initLives(Deque<Life> lives) {
		Life life;
		int xCoordLife = 10;

		for (int i = 0; i < GameConstants.N_LIVES; i++) {
			final int shift = 30;
			life = new Life(xCoordLife, 60, GameConstants.fileNameLife);
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
		
		Random random = new Random();
		int randX1;
		
		if (countToAddEnemies >= 150) {
			randX1 = random.nextInt(GameConstants.GAME_WIDTH);
			enemies.add(new EnemySpaceShip(randX1, -20, GameConstants.fileNameEnemy));
			enemies.get(enemies.size()-1).fire();
			countToAddEnemies = 0;
		}
		countToAddEnemies++;
		
		Iterator<EnemySpaceShip> et = enemies.iterator();
		
    	while(et.hasNext()) {
    		EnemySpaceShip enemy = (EnemySpaceShip)et.next();
    		if (enemy.getY() >= GameConstants.GAME_HEIGHT || !enemy.isVisible()) {
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
				Bomb bomba = bombs.get(j);			
				if(bomba.isVisible()) {
					bomba.move();
					bomba.setBounds();
		        	if(bomba.getY()>850){		        		
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
		if(!strayBombs.isEmpty()) {
			for(int i=0; i<strayBombs.size();i++) {
				Bomb bomba = strayBombs.get(i);
				if(bomba.isVisible()) {
					bomba.move();
					bomba.setBounds();
					if(bomba.getY()>850) {
						bomba.setVisible(false);
					}
				}else {
					strayBombs.remove(bomba);
				}
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
		
		
		for (LifeBonus life : this.lifeBonus) {

			bonusBounds = life.getBounds();

			if (bonusBounds.intersects(spaceShipBounds)) {
				life.removeBoundsObstacles();
				int actual_lives = this.spaceShip.getLives();
				if(actual_lives < 6) {
				spaceShip.setLives(actual_lives+1);
				int x_shift = lives.getLast().getX();
				lives.add(new Life(x_shift+30,60,GameConstants.fileNameLife));
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
					MainFrame.getIstance().updateModalita("game_over");
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
					MainFrame.getIstance().updateModalita("game_over");
				} else {
					asteroid.setVisible(false);
				}
			}

			for (Missile missile : missiles) {
				missileBounds = missile.getBounds();

				if (missileBounds.intersects(asteroidBounds)) {
					PanelEsecuzione.setAsteroidsDestoyed(PanelEsecuzione.getAsteroidsDestoyed()+1);
					missile.removeBoundsEnemies();
					missile.setVisible(false);
					asteroid.setVisible(false);
					if(activeBonusScore == false) {
					mainframe.getScore().updateScoreValue(100);
					this.scoreUpdate = "+100";
					}
					else {
					mainframe.getScore().updateScoreValue(200);	
					this.scoreUpdate = "+200";
					this.labelScoreUpdate.setForeground(Color.yellow);
					}
					this.labelScoreUpdate.setVisible(true);
					this.countTimeLabelBonus = 0;
				}

			}
			
			for(EnemySpaceShip enemy : enemies) {
				
				enemyBounds = enemy.getBounds();

				for(Missile missile : missiles) {
					missileBounds = missile.getBounds();
					if(missileBounds.intersects(enemyBounds)) {
						PanelEsecuzione.setEnemiesDestoyed(PanelEsecuzione.getEnemiesDestoyed()+1);;
						missile.removeBoundsEnemies();
						missile.setVisible(false);
						enemy.setVisible(false);
						if(activeBonusScore == false) {
						mainframe.getScore().updateScoreValue(500);
						this.scoreUpdate = "+500";
						}
						else {
						mainframe.getScore().updateScoreValue(1000);
						this.scoreUpdate = "+1000";	
						this.labelScoreUpdate.setForeground(Color.yellow);
						}
						this.labelScoreUpdate.setVisible(true);
						this.countTimeLabelBonus = 0;
					}
				}
				

				if(enemyBounds.intersects(spaceShipBounds)) {
					enemy.removeBoundsEnemies();
					
					spaceShip.setLives(spaceShip.getLives()-1);
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
						bomb.removeBoundsEnemies();
						spaceShip.setLives(spaceShip.getLives()-1);
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
			
			if(!strayBombs.isEmpty()) {
				for(Bomb bomb : strayBombs){
					strayBombsBounds = bomb.getBounds();
					if(strayBombsBounds.intersects(spaceShipBounds)) {
						bomb.removeBoundsEnemies();
						spaceShip.setLives(spaceShip.getLives()-1);
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
	
	public void checkForLevelPassed() {
		if (mainframe.getScore().getScoreValue() > 500 * level) {
			level++;
			countToAddObstacles = (int) (countToAddObstacles / 1.05);
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

	public static int getAsteroidsDestoyed() {
		return asteroidsDestoyed;
	}

	public static void setAsteroidsDestoyed(int asteroidsDestoyed) {
		PanelEsecuzione.asteroidsDestoyed = asteroidsDestoyed;
	}

	public static int getEnemiesDestoyed() {
		return enemiesDestoyed;
	}

	public static void setEnemiesDestoyed(int enemiesDestoyed) {
		PanelEsecuzione.enemiesDestoyed = enemiesDestoyed;
	}
	
	

}

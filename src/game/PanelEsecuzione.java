package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelEsecuzione extends JPanel implements ActionListener{
	private String fileNameSpaceShip, fileNameAsteroid, fileNameMeteorite;//, enemyName,fileName2;
	private SpaceShip spaceShip;
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
    private List<Meteorite> meteorites;
    private BufferedImage scrollingBackground;
    private int yOffset = 0;
    private int yDelta = 1;
    private static int countToAddAsteroid = 0;
    private static int countToAddMeteorite = 0;
    private final int DELAY = 20;
    private Timer timer;
    
    private EnemiesSpaceShip enemies;
	
	
	public PanelEsecuzione() {
		
		addKeyListener(new TAdapter());
        setFocusable(false);
        
        this.fileNameSpaceShip = "../resources/images/navicella-bellissima.png";
        this.fileNameAsteroid = "../resources/images/asteroid-icon.png";
        this.fileNameMeteorite = "../resources/images/fiery-meteorite-icon.png";
        this.spaceShip = new SpaceShip(500,400,fileNameSpaceShip);
        this.missiles = this.spaceShip.getMissiles();
        this.asteroids = new ArrayList<Asteroid>();
        this.meteorites = new ArrayList<Meteorite>();
        
        try {
			this.scrollingBackground=ImageIO.read(getClass().getResource("../resources/images/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //enemyName = "../resources/images/firstEnemy.png";
        //enemies = new EnemiesSpaceShip(0,0,enemyName);
        
        timer = new Timer(DELAY, this);
        timer.start();                  //creates delay fot the repaint() method
        
        
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
        
        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
                spaceShip.getY(), this);
        
        
        List<Missile> missiles = spaceShip.getMissiles();

        for (Missile missile : missiles) {
            
            g2d.drawImage(missile.getImage(), missile.getX(),
                    missile.getY(), this);
        }
        
        
        for (Asteroid asteroid : asteroids) {
            g2d.drawImage(asteroid.getImage(),asteroid.getTransform(), this);
        }
        
        for (Meteorite meteorite : meteorites) {
        	g2d.drawImage(meteorite.getImage(), meteorite.getTransform(),this);
        }
        
      //g2d.drawImage(enemies.getImage(), enemies.getX(), enemies.getY(), this);//disegna nemico
        
        
//      List<Missile> colpo = enemies.getMissiles();
//      for(Missile missile : colpo) {
//      	g2d.drawImage(missile.getImage(), missile.getX(),
//      			missile.getY(), this);
//      }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
		this.updateSpaceShip();
		this.updateMissiles();
		this.updateObstacles();
		this.checkCollisions();
		yOffset += yDelta;
        this.repaint();
        //System.out.println("ActionPerformed");
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
        
//        List<Missile> colpo = enemies.getMissiles();
//        for(int i = 0; i < colpo.size(); i++) {
//        	Missile missile = colpo.get(i);
//        	
//        	if(missile.isVisible())
//        		missile.move_colpo();
//        	else
//        		colpo.remove(i);
//        }
        
        
    }
    
    public void updateSpaceShip() {
    	spaceShip.move();
    	spaceShip.setBounds();
    	//enemies.move(); // movimento nemico
    }
    
    
    public void updateObstacles() {
    	Random random = new Random();
        
        int y_asteroid = -1000;
        int y_meteorite = -1000;
        int D_W = 1000;
        int D_H = 600;
    	
    	
    	if (countToAddAsteroid >= 50) {   //maggiore è il valore minore è la frequenza di uscita degli asteroidi (utile per gestione dei livelli)
            int randX1 = random.nextInt(D_W); //larghezza window
            asteroids.add(new Asteroid(randX1, y_asteroid, fileNameAsteroid));
            countToAddAsteroid = 0;
        }
        countToAddAsteroid++;
        
        if (countToAddMeteorite >= 150) {   //maggiore è il valore minore è la frequenza di uscita degli asteroidi (utile per gestione dei livelli)
            int randX2 = random.nextInt(D_W);
            meteorites.add(new Meteorite(randX2, y_meteorite, fileNameMeteorite));
            countToAddMeteorite = 0;
        }
        countToAddMeteorite++;
        
        Iterator<Asteroid> it_asteroids = asteroids.iterator();

        while (it_asteroids.hasNext()) {
            Asteroid asteroid = (Asteroid)it_asteroids.next();
            if (asteroid.getY() >= D_H || !asteroid.isVisible()) {
                it_asteroids.remove();
            } else {
                 asteroid.move();
                 asteroid.setBounds();
            }
        }
        
        
        Iterator<Meteorite> it_meteorites = meteorites.iterator();
        
        while (it_meteorites.hasNext()) {
            Meteorite meteorite = (Meteorite)it_meteorites.next();
            if (meteorite.getY() >= D_H || !meteorite.isVisible()) {
                it_meteorites.remove();
            } else {
                 meteorite.move();
                 meteorite.setBounds();
            }
        }
    }
    
   
    
    public class TAdapter extends KeyAdapter{
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
        

        //Rectangle2D r2 = enemies.getBounds();
        
//        Rectangle2D r4 = enemy.getBounds();
//
//        System.out.println(r3.intersects(r4));
//        if (r3.intersects(r4)) {
//                
//            spaceShip.setVisible(false);
//            enemy.setVisible(false);
//        	//System.out.println("Collisione spaceship-asteroide");
//            
//        }
//
//        System.out.println(ms.size());
        
        for (Meteorite meteorite : meteorites) {
        	
        	meteoriteBounds = meteorite.getBounds();
        	
        	if(meteoriteBounds.intersects(spaceShipBounds)) {        		
        		MainFrame.getIstance().updateModalita("game_over");
        	}
        	
        }

        for (Asteroid asteroid : asteroids) {
        	
        	asteroidBounds = asteroid.getBounds();
        	
        	if (spaceShipBounds.intersects(asteroidBounds)) {            	
        		MainFrame.getIstance().updateModalita("game_over");            	
            }
            
            for (Missile missile : missiles) {
            	missileBounds = missile.getBounds();
            	
            
	            if (missileBounds.intersects(asteroidBounds)) {
	    
	                missile.setVisible(false);
	                
	                asteroid.setVisible(false);
	                System.out.println("Collisione missile-asteroide");
	            }
	            
	            
                
            }
        }
    }
}

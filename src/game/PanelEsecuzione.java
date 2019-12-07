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
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelEsecuzione extends JPanel implements ActionListener{
	private String fileName, enemyName,fileName2;
	public SpaceShip spaceShip,enemy;
    private final int DELAY = 20;
    private Timer timer;
    
    private EnemiesSpaceShip enemies;
	
	
	public PanelEsecuzione() {
		
		addKeyListener(new TAdapter());
        setFocusable(false);
        
        fileName = "../resources/images/spaceship.png";
        fileName2 = "../resources/images/asteroid-icon.png";
        spaceShip = new SpaceShip(500,400,fileName);
        enemy = new SpaceShip(400,50,fileName2);
        
        //checkCollisions();
        
        enemyName = "../resources/images/firstEnemy.png";
        //enemies = new EnemiesSpaceShip(0,0,enemyName);
        
        timer = new Timer(DELAY, this);
        timer.start();                  //creates delay fot the repaint() method
        
        
	}
	

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        Graphics2D g_en = (Graphics2D) g;
        
        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
                spaceShip.getY(), this);
        
        //g_en.drawImage(enemies.getImage(), enemies.getX(), enemies.getY(), this);//disegna nemico
        
        g2d.drawImage(enemy.getImage(), enemy.getX(),
                enemy.getY(), this);
        
//        List<Missile> colpo = enemies.getMissiles();
//        for(Missile missile : colpo) {
//        	g_en.drawImage(missile.getImage(), missile.getX(),
//        			missile.getY(), this);
//        }
        
        
        List<Missile> missiles = spaceShip.getMissiles();

        for (Missile missile : missiles) {
            
            g2d.drawImage(missile.getImage(), missile.getX(),
                    missile.getY(), this);
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
		this.updateSpaceShip();
		this.updateMissiles();
		this.checkCollisions();
        this.repaint();
        //System.out.println("ActionPerformed");
    }
    
    
    private void updateMissiles() {

        List<Missile> missiles = spaceShip.getMissiles();

        for (int i = 0; i < missiles.size(); i++) {

            Missile missile = missiles.get(i);

            if (missile.isVisible()) {
            	
                missile.move();
                missile.setRectangle();
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
    	spaceShip.setRectangle();
    	//enemies.move(); // movimento nemico
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

        Rectangle2D r3 = spaceShip.getBounds();
        

        //Rectangle2D r2 = enemies.getBounds();
        
        Rectangle2D r4 = enemy.getBounds();

//        System.out.println(r3.intersects(r4));
        if (r3.intersects(r4)) {
                
            spaceShip.setVisible(false);
            enemy.setVisible(false);
        	//System.out.println("Collisione spaceship-asteroide");
            
        }

        List<Missile> ms = spaceShip.getMissiles();
        System.out.println(ms.size());
        

        for (Missile m : ms) {
        	

            Rectangle2D r1 = m.getBounds();

            if (r1.intersects(r4)) {
            	

                    
                m.setVisible(false);
                
                enemy.setVisible(false);
                System.out.println("Collisione missile-asteroide");
                
            }
        }
    }
}

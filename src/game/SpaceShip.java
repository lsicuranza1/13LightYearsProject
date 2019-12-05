/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author lorenzosic
 */
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

public class SpaceShip extends SpaceshipStructure {

    private int dx;
    private int dy;
    private double x = getX();
    private double y = getY();
//    private double width = getWidth();
//    private double height = getHeight();
    private ImageIcon imgIcon;
    public int width = imgIcon.getIconWidth();
    public int height = imgIcon.getIconHeight();
    private List<Missile> missiles;
    public boolean isShooting = false;
    long startTime = System.currentTimeMillis();
    long elapsedTime = 0;

    public SpaceShip(int x, int y, String path) {
        super(x, y, path);
        
        initSpaceShip();
    }

    private void initSpaceShip() {

        missiles = new ArrayList<>();
        
    }

    public void move() {
    			x += dx;
    	        y += dy;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }
    
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        //int key = e.getKeyCode();    	
        int shoot = e.getKeyCode();
        
        if (isShooting == false) {
	        if (shoot == KeyEvent.VK_SPACE) {
	        	if (getX()<=0-width+10) {
	        		x=400-8;
	        		dx=-3;
	        	}
	        	if (getX()>400-8) {
	        		x=0-width+10;
	        		dx=3;
	        	}
	            fire();
	        }
        }

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
        	if (getX()<=0-width+10) {
        		x=400-8;
        		dx=-3;
        	}
        	else{
        		dx = -3;
        	}
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
        	if (getX()>400-8) {
        		x=0-width+10;
        		dx=3;
        	}
        	else{
        		dx = 3;
        	}
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
        	if(getY()<=0) {
        		y=0;
        		dy=0;
        	}
        	if (getX()<=0-width+10) {
        		x=400-8;
        		dx=-3;
        	}
        	if (getX()>400-8) {
        		x=0-width+10;
        		dx=3;
        	}
        	else{
        		dy = -3;
        	}
        }

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
        	if (getY()>=1000-2*height) {
        		y=1000-2*height;
        		dy=0;
        	}
        	if (getX()<=0-width+10) {
        		x=400-8;
        		dx=-3;
        	}
        	if (getX()>400-8) {
        		x=0-width+10;
        		dx=3;
        	}
        	else{
        		dy = 3;
        	}
        }
    }

    public void fire() {
    			missiles.add(new Missile(x + width/2 -9, y + height -90,"/13LightYearsProject/src/resources/images/missile.png"));
    	new Thread() {
    		@Override
    		public void run() {
        		try {
    	            isShooting = true;
        			missiles.add(new Missile(x + width/2 -9, y + height -90,"/13LightYearsProject/src/resources/images/missile.png"));
                    Thread.sleep(1000);
                    isShooting = false;
                } catch (InterruptedException ex) {
                    Logger.getLogger(SpaceShip.class.getName()).log(Level.SEVERE, null, ex);
                }
    		}
    	}.start();		
    }
    

	public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            dy = 0;
        }
    }


}

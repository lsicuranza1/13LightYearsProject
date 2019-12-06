/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
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

    private boolean isShooting = false;
    
    
    public SpaceShip(int x, int y,String path) {

    	super(x, y, path);

    }


    @Override
    public void move() {
    	this.setX(this.getX() + dx);
    	this.setY(this.getY() + dy);
    }
    
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        int x = this.getX();
        int y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();
        
        if (isShooting == false) {
	        if (key == KeyEvent.VK_SPACE) {
	        	if (x<=10-width) {
	        		this.setX(1000-8);
	        		dx=-3;
	        	}else if(y>=600-(height*7)/5) {
	        		this.setY(600-(height*7)/5);
	        		dy=0;
	        	}else if (x>=1000-8) {
	        		this.setX(10-width);
	        		dx=3;
	        	}else if(y<=0) {
	        		this.setY(0);
	        		dy=0;
	        	}
	            fire();
	        }
        }

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {

        	if (x<=10-width) {
        		this.setX(1000-8);
        		dx=-3;
        	}else if(y>=600-(height*7)/5) {
        		this.setY(600-(height*7)/5);
        		dy=0;
        	}if(y<0) {
        		this.setY(0);
        		dy=0;
        	}
        	else{
        		dx = -3;
        	}
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
        	if (x>=1000-8) {
        		this.setX(10-width);
        		dx=3;
        	}else if(y>=600-(height*7)/5) {
        		this.setY(600-(height*7)/5);
        		dy=0;
        	}if(y<0) {
        		this.setY(0);
        		dy=0;
        	}
        	else{
        		dx = 3;
        	}
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
        	if(y<=0) {
        		this.setY(0);
        		dy=0;
	        	if (x<=10-width) {
	        		this.setX(1000-8);
	        		dx=-3;
	        	}if (x>=1000-8) {
	        		this.setX(10-width);
	        		dx=3;
	        	}
        	}
        	else{
        		dy = -3;
        	}
        }

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
        	if (y>=600-(height*7)/5) {
        		this.setY(600-(height*7)/5);
        		dy=0;
	        	if (x<=10-width) {
	        		this.setX(1000-8);
	        		dx=-3;
	        	}else if (x>=1000-8) {
	        		this.setX(10-width);
	        		dx=3;
	        	}
        	}
        	else{
        		dy = 3;
        	}
        }
    }

    public void fire() {
    	int x = this.getX();
        int y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();
        List<Missile> missiles = this.getMissiles();
    			missiles.add(new Missile(x + width/2 -9, y + height -90,"../resources/images/missile.png"));
    	new Thread() {
    		@Override
    		public void run() {
        		try {
    	            isShooting = true;
                    Thread.sleep(500);
                    isShooting = false;
                } catch (InterruptedException ex) {
                    Logger.getLogger(SpaceShip.class.getName()).log(Level.SEVERE, null, ex);
                }
    		}
    	}.start();		
    }
//    public void fire() {
//    	Missile missile = new Missile(this.getX() + this.getWidth()/2 -10, this.getY() + this.getHeight() -90,"../resources/images/missile.png");
//    	this.getMissiles().add(missile);
//    	isShooting = true;
//    	
//    }
    


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

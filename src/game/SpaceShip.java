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

public class SpaceShip extends Sprite {

    private int dx;
    private int dy;
    private List<Missile> missiles;
    public boolean isShooting = false;
    long startTime = System.currentTimeMillis();
    long elapsedTime = 0;

    public SpaceShip(int x, int y) {
        super(x, y);
        
        initSpaceShip();
    }

    private void initSpaceShip() {

        missiles = new ArrayList<>();
        System.out.println("space");
        loadImage("src/resources/images/spaceship.png"); 
        getImageDimensions();
        System.out.println("DImensioni" + this.width + this.height );
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

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }    }

    public void fire() {
    	 missiles.add(new Missile(x + width/2 -10, y + height -90));		
    }
    

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    
    }
}

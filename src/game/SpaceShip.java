package game;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SpaceShip extends SpaceshipStructure {

	private int SPACESHIP_SPEED = 8;
	private int shoot_counter = 25;          //shooting delay =~ 500 milliseconds 
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	private boolean isShooting = false;
	

	public SpaceShip(int x, int y, String path) {

		super(x, y, path);

	}

	@Override
	public void move() {
		
		this.shoot_counter++;
		
		if (this.isShooting()) {
			fire();
		}
		
		if (this.isLeft()) {
			this.setX(this.getX() - this.SPACESHIP_SPEED);
			
			if (this.getX() <= 10 - this.getWidth()) {
				this.setX(1000 - 8);
			}
		}
		
		if (this.isRight()) {
			this.setX(this.getX() + this.SPACESHIP_SPEED);	
			if (this.getX() >= 1000 - 8) {
				this.setX(10 - this.getWidth());
			}
		}
		
		if (this.isUp()) {
			this.setY(this.getY() - this.SPACESHIP_SPEED);
			if (this.getY() <= 0) {
				this.setY(0);
			}
		}
		
		if (this.isDown()) {
			this.setY(this.getY() + this.SPACESHIP_SPEED);
			if (this.getY() >= 600 - (this.getHeight() * 7) / 5) {
				this.setY(600 - (this.getHeight() * 7) / 5);
			}
		}
		
	}
	
	public void fire() {
		List<Missile> missiles = this.getMissiles();
		
		if (this.shoot_counter >= 25) {
			missiles.add(new Missile(this.getX() + this.getWidth() / 2 - 9, this.getY() + this.getHeight() - 90, "../resources/images/missile.png"));
			this.shoot_counter = 0;
		}
		
	}
	

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isShooting() {
		return isShooting;
	}

	public void setShooting(boolean isShooting) {
		this.isShooting = isShooting;
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			this.setShooting(true);
		}

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			this.setLeft(true);
		}

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			this.setRight(true);
		}

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			this.setUp(true);
		}

		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			this.setDown(true);
		}
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			this.setShooting(false);
		}

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {			
			this.setLeft(false);
		}

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			this.setRight(false);
		}

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			this.setUp(false);
		}

		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			this.setDown(false);
		}
	}

}
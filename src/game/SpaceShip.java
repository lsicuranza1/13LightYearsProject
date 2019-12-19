package game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class SpaceShip extends SpaceshipStructure {

	private int SPACESHIP_SPEED = 8;
	private int shoot_counter = 25;          //shooting delay =~ 500 milliseconds 
	private List<Missile> missiles;
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	private int lives = 3; //COSTANTE
	private boolean isShooting = false;
	

	public SpaceShip(int x, int y, String path) {

		super(x, y, path);
		this.missiles = new ArrayList<Missile>();

	}

	
	
	public int getLives() {
		return lives;
	}
	
	
	public List<Missile> getMissiles() {
		return missiles;
	}



	public void loseLife() {
		if (this.getLives() > 0) {
			this.lives -= 1;
		}
	}



	@Override
	public void move() {
		
		this.shoot_counter++;
		
		if (isShooting == true) {
			fire();
		}
		
		if (left == true) {
			this.setX(this.getX() - SPACESHIP_SPEED);
			
			if (this.getX() <= 10 - this.getWidth()) {
				this.setX(1000 - 8);
			}
		}
		
		if (right == true) {
			this.setX(this.getX() + SPACESHIP_SPEED);	
			if (this.getX() >= 1000 - 8) {
				this.setX(10 - this.getWidth());
			}
		}
		
		if (up == true) {
			this.setY(this.getY() - SPACESHIP_SPEED);
			if (this.getY() <= 0) {
				this.setY(0);
			}
		}
		
		if (down == true) {
			this.setY(this.getY() + SPACESHIP_SPEED);
			if (this.getY() >= 600 - (this.getHeight() * 7) / 5) {
				this.setY(600 - (this.getHeight() * 7) / 5);
			}
		}
		
	}
	

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			isShooting = true;
		}

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			left = true;
		}

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			right = true;
		}

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			up = true;
		}

		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			down = true;
		}
	}

	public void fire() {
		List<Missile> missiles = this.getMissiles();
		
		if (this.shoot_counter >= 25) {
			missiles.add(new Missile(this.getX() + this.getWidth() / 2 - 9, this.getY() + this.getHeight() - 90, "../resources/images/missile.png"));
			this.shoot_counter = 0;
		}
		
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			isShooting = false;
		}

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {			
			left = false;
		}

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			right = false;
		}

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			up = false;
		}

		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			down = false;
		}
	}

}
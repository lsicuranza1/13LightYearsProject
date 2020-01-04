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
	private boolean isShooting = false;
	private int lives = 3; //COSTANTE
	private int keyMode = Settings.mod;

	public SpaceShip(int x, int y, String path) {

		super(x, y, path);
		this.missiles = new ArrayList<Missile>();

	}
	
	public int getLives() {
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	
	public List<Missile> getMissiles() {
		return missiles;
	}


	public void move() {
		
		this.shoot_counter++;
		
		if (this.isShooting()) {
			fire();
		}
		
		if (this.isLeft()) {
			this.setX(this.getX() - SPACESHIP_SPEED);
			
			if (this.getX() <= 10 - this.getWidth()) {
				this.setX(600 - 8);
			}
		}
		
		if (this.isRight()) {
			this.setX(this.getX() + SPACESHIP_SPEED);	
			if (this.getX() >= 600 - 8) {
				this.setX(10 - this.getWidth());
			}
		}
		
		if (this.isUp()) {
			this.setY(this.getY() - SPACESHIP_SPEED);
			if (this.getY() <= 0) {
				this.setY(0);
			}
		}
		
		if (this.isDown()) {
			this.setY(this.getY() + SPACESHIP_SPEED);
			if (this.getY() >= 1000 - (this.getHeight() * 7) / 5) {
				this.setY(1000 - (this.getHeight() * 7) / 5);
			}
		}
		
	}
	

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		
		if (key == KeyEvent.VK_SPACE) {
				this.setShooting(true);
			}
		if (keyMode == 0) {
			
			
			if (key == KeyEvent.VK_LEFT ) {
				this.setLeft(true);
			}

			if (key == KeyEvent.VK_RIGHT ) {
				this.setRight(true);
			}

			if (key == KeyEvent.VK_UP ) {
				this.setUp(true);
			}

			if (key == KeyEvent.VK_DOWN ) {
				this.setDown(true);
			}
		}else if(keyMode == 1) {
			
						
			if ( key == KeyEvent.VK_A) {
				this.setLeft(true);
			}

			if ( key == KeyEvent.VK_D) {
				this.setRight(true);
			}

			if ( key == KeyEvent.VK_W) {
				this.setUp(true);
			}

			if ( key == KeyEvent.VK_S) {
				this.setDown(true);
			}
		}
	}

	@Override
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
				this.setShooting(false);
			}

		if (keyMode == 0) {
			
			
			if (key == KeyEvent.VK_LEFT ) {
				this.setLeft(false);
			}

			if (key == KeyEvent.VK_RIGHT ) {
				this.setRight(false);
			}

			if (key == KeyEvent.VK_UP ) {
				this.setUp(false);
			}

			if (key == KeyEvent.VK_DOWN ) {
				this.setDown(false);
			}
		}else if(keyMode == 1) {
			
			if ( key == KeyEvent.VK_A) {
				this.setLeft(false);
			}

			if ( key == KeyEvent.VK_D) {
				this.setRight(false);
			}

			if ( key == KeyEvent.VK_W) {
				this.setUp(false);
			}

			if ( key == KeyEvent.VK_S) {
				this.setDown(false);
			}
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

}
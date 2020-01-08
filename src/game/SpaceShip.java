package game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends SpaceshipStructure {

	private int SPACESHIP_SPEED = 8;
	private int shootCounter = 25;
	private List<Missile> missiles;
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	private boolean isShooting = false;
	private int lives = 3;
	private int keyMode = Settings.mod;

	/** The costructor of SpaceShip
	 * @param x X-Coordinate of the spaceship
	 * @param y Y-Coordinate of the spaceship
	 * @param path Path of the image
	 */
	public SpaceShip(int x, int y, String path) {
		super(x, y, path);
		this.missiles = new ArrayList<Missile>();
	}
	
	/**
	 * Method that returns the parameter lives
	 * @return The lives
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * Method that sets the parameter lives
	 * @param lives The lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	/**
	 * Method that returns the parameter missiles
	 * @return A List of missiles
	 */
	public List<Missile> getMissiles() {
		return missiles;
	}

	/**
	 * Method that manages the movement of the spaceship
	 */
	public void move() {
		
		this.shootCounter++;
		
		if (this.isShooting()) {
			fire();
		}
		
		if (this.isLeft()) {
			this.setX(this.getX() - SPACESHIP_SPEED);
			
			if (this.getX() <= 10 - this.getWidth()) {
				this.setX(800 - 8);
			}
		}
		
		if (this.isRight()) {
			this.setX(this.getX() + SPACESHIP_SPEED);	
			if (this.getX() >= 800 - 8) {
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
			if (this.getY() >= 800 - (this.getHeight() * 7) / 5) {
				this.setY(800 - (this.getHeight() * 7) / 5);
			}
		}
		
	}
	

	/**
	 * Method that manages when a key is pressed 
	 * @param e A KeyEvent
	 */ 
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
				this.setShooting(true);
		}
		
		if (keyMode == 0) {
					
			if (key == KeyEvent.VK_LEFT ) 
				this.setLeft(true);

			if (key == KeyEvent.VK_RIGHT )
				this.setRight(true);

			if (key == KeyEvent.VK_UP )
				this.setUp(true);

			if (key == KeyEvent.VK_DOWN )
				this.setDown(true);
			
		}else if(keyMode == 1) {
								
			if ( key == KeyEvent.VK_A)
				this.setLeft(true);

			if ( key == KeyEvent.VK_D)
				this.setRight(true);

			if ( key == KeyEvent.VK_W)
				this.setUp(true);
			
			if ( key == KeyEvent.VK_S)
				this.setDown(true);
		}
	}

	/**
	 * Method that manages the shooting of the spaceship
	 * @see SpaceshipStructure
	 */
	@Override
	public void fire() {
		List<Missile> missiles = this.getMissiles();
		
		if (this.shootCounter >= 25) {
			missiles.add(new Missile(this.getX() + this.getWidth() / 2 - 9, this.getY() + this.getHeight() - 90, "../resources/images/missile.png"));
			this.shootCounter = 0;
		}
		
	}

	/**
	 * Method that handles when a key is released 
	 * @param e KeyEvent
	 */
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
				this.setShooting(false);
		}

		if (keyMode == 0) {
					
			if (key == KeyEvent.VK_LEFT )
				this.setLeft(false);

			if (key == KeyEvent.VK_RIGHT )
				this.setRight(false);

			if (key == KeyEvent.VK_UP )
				this.setUp(false);

			if (key == KeyEvent.VK_DOWN )
				this.setDown(false);
		}else if(keyMode == 1) {
			
			if ( key == KeyEvent.VK_A)
				this.setLeft(false);

			if ( key == KeyEvent.VK_D)
				this.setRight(false);

			if ( key == KeyEvent.VK_W)
				this.setUp(false);

			if ( key == KeyEvent.VK_S)
				this.setDown(false);
		}
	}
	
	/**
	 * Method that returns the parameter left
	 * @return The Left boolean value 
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * Method that sets the parameter left 
	 * @param left The Left value
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}

	/**
	 * Method that returns the parameter right
	 * @return The Right boolean value
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * Method that sets the parameter right 
	 * @param right The Rigth value
	 */
	public void setRight(boolean right) {
		this.right = right;
	}

	/**
	 * Method that returns the parameter up
	 * @return The Up boolean value
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * Method that sets the parameter up 
	 * @param up The Up value
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * Method that returns the parameter down 
	 * @return The Down boolean value
	 */
	public boolean isDown() {
		return down;
	}

	/**
	 * Method that sets the parameter down 
	 * @param down The Down value
	 */
	public void setDown(boolean down) {
		this.down = down;
	}

	/**
	 * Method that returns the parameter isShooting 
	 * @return The Shooting boolean value
	 */
	public boolean isShooting() {
		return isShooting;
	}

	/**
	 * Method that sets the parameter isShooting 
	 * @param isShooting The Shooting value
	 */
	public void setShooting(boolean isShooting) {
		this.isShooting = isShooting;
	}

}
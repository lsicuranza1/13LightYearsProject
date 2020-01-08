package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySpaceShip extends SpaceshipStructure {
	
	Random random = new Random();
    private List<Bomb> bombs;
	private int countPosition = 0;	
	private int enemyDelay = 0;
	private int randX = random.nextInt(550);
	private int randY = random.nextInt(300);
	private int shootCounter = 70;
		
	/** The costructor of EnemySpaceShip.
	 * @param x X-Coordinate of the enemy_spaceship
	 * @param y Y-Coordinate of the enemy_spaceship
	 * @param path Path of the image
	 */
	public EnemySpaceShip(int x, int y, String path) {
		super(x, y, path);
		this.bombs = new ArrayList<Bomb>();
	}

	/**
	 * Method that manages the movement of the enemySpaceship
	 */
	public void move() {
		
		if(this.getX()>randX) {
			if(this.countPosition==2)
				this.setX(this.getX());
			else
				this.setX(this.getX()-5);	
		}
		
		if(this.getX()<randX) {
			if(this.countPosition==2) 
				this.setX(this.getX());
			else	
				this.setX(this.getX()+5);
		}
		
		if(this.getY()<=randY) {
			if(this.countPosition==2) 
				this.setY(this.getY()+5);
			else	
				this.setY(this.getY()+5);
		}
		
		if(this.getY()>=randY) {
			if(this.countPosition==2) 
				this.setY(this.getY()+5);
			else	
				this.setY(this.getY()-5);
		}

		this.enemyDelay++;
		
		if(this.enemyDelay==150 && this.countPosition <2) {
				randX = random.nextInt(550);
				randY = random.nextInt(300);
				this.countPosition++;
				this.enemyDelay=0;		
		}
		
	}

	/**
	 * Method that manages the shooting of the enemies.
	 * @see SpaceshipStructure
	 */
	@Override
	public void fire() {
		List<Bomb> bomb = this.getBombs();
		if(this.shootCounter>=70) {
			bomb.add(new Bomb(this.getX() + this.getWidth()/2-5,this.getY() + this.getHeight()-9,"../resources/images/missile_enemy.png"));
			this.shootCounter = 0;
		}		
		this.shootCounter++;
	}
	
	/**
	 * Method that returns the parameter bombs.
	 * @return A List of bomb
	 */
	public List<Bomb> getBombs() {
		return bombs;
	}
	
	/**
	 * Method that returns the number of position occupied by the EnemySpaceship during his movement.
	 * @return A number of position
	 */
	public int getCountPosition() {
		return countPosition;
	}

	/**
	 * Method that sets the number of position occupied by the EnemySpaceship during his movement.
	 * @param countPosition Number of position occupied
	 */
	public void setCountPosition(int countPosition) {
		this.countPosition = countPosition;
	}

	/**
	 * Method that returns the parameter randX. It's created with the Random library.
	 * @return The random int randX 
	 */
	public int getRandX() {
		return randX;
	}

	/**
	 * Method that sets the parameter randX. It's created with the Random library.
	 * @param randX The parameter randX
	 */
	public void setRandX(int randX) {
		this.randX = randX;
	}

	/**
	 * Method that returns the parameter randY. It's created with the Random library.
	 * @return The random int randY
	 */
	public int getRandY() {
		return randY;
	}

	/**
	 * Method that sets the parameter randY 
	 * @param randY The parameter randY
	 */
	public void setRandY(int randY) {
		this.randY = randY;
	}
	
}

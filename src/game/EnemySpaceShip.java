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
		
	public EnemySpaceShip(int x, int y, String path) {
		super(x, y, path);
		this.bombs = new ArrayList<Bomb>();
	}

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

	@Override
	public void fire() {
		List<Bomb> bomb = this.getBombs();
		if(this.shootCounter>=70) {
			bomb.add(new Bomb(this.getX() + this.getWidth()/2-5,this.getY() + this.getHeight()-9,"../resources/images/missile_enemy.png"));
			this.shootCounter = 0;
		}		
		this.shootCounter++;
	}
	
	public List<Bomb> getBombs() {
		return bombs;
	}
	
	public int getCountPosition() {
		return countPosition;
	}

	public void setCountPosition(int countPosition) {
		this.countPosition = countPosition;
	}

	public int getRandX() {
		return randX;
	}

	public void setRandX(int randX) {
		this.randX = randX;
	}

	public int getRandY() {
		return randY;
	}

	public void setRandY(int randY) {
		this.randY = randY;
	}
	
}

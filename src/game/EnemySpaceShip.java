package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EnemySpaceShip extends SpaceshipStructure {
	
    private List<Bomb> bombs;

	Random random = new Random();
	private int count = 0; // count the position to reached before exit	(2)
	
	private int enemyDelay = 0;  // delay to let enemy move again
	private int newX_1 = random.nextInt(550);
	private int newY_1 = random.nextInt(300);
	private int shoot_counter = 70;
	
	
	public EnemySpaceShip(int x, int y, String path) {
		super(x, y, path);
		this.bombs = new ArrayList<Bomb>();
	}


	public void move() {
	
		
		if(this.getX()>newX_1) {
			if(this.count==2)
				this.setX(this.getX());
			else
				this.setX(this.getX()-5);	
		}
		
		if(this.getX()<newX_1) {
			if(this.count==2) 
				this.setX(this.getX());
			else	
				this.setX(this.getX()+5);
		}
		
		if(this.getY()<=newY_1) {
			if(this.count==2) 
				this.setY(this.getY()+5);
			else	
				this.setY(this.getY()+5);
		}
		
		if(this.getY()>=newY_1) {
			if(this.count==2) 
				this.setY(this.getY()+5);
			else	
				this.setY(this.getY()-5);
		}

		this.enemyDelay++;
		
		if(this.enemyDelay==150 && this.count <2) {
				newX_1 = random.nextInt(550);
				newY_1 = random.nextInt(300);
				this.count++;
				this.enemyDelay=0;
			
		}
		


	}
	
	public void move1() {
		this.setY(this.getY()+1);
	}
	

	@Override
	public void fire() {
		List<Bomb> bomb = this.getBombs();
		if(this.shoot_counter>=70) {
			bomb.add(new Bomb(this.getX() + this.getWidth()/2-5,this.getY() + this.getHeight()-9,"../resources/images/missile_enemy.png"));
			this.shoot_counter = 0;
		}
		
		this.shoot_counter++;
	}
	
	
	public List<Bomb> getBombs() {
		return bombs;
	}
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getNewX_1() {
		return newX_1;
	}


	public void setNewX_1(int newX_1) {
		this.newX_1 = newX_1;
	}


	public int getNewY_1() {
		return newY_1;
	}


	public void setNewY_1(int newY_1) {
		this.newY_1 = newY_1;
	}


	
}

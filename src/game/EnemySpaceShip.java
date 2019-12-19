package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnemySpaceShip extends EnemySpaceshipStructure {
	
//	private Bomb bomb;

	Random random = new Random();
	private int count = 0; // count the position to reached before exit	(2)
	
	private int enemyDelay = 0;  // delay to let enemy move again
	private int newX = random.nextInt(950);
	private int newY = random.nextInt(200);
	private int shoot_counter = 25;
	
	
	public EnemySpaceShip(int x, int y, String path) {
		super(x, y, path);
	}

	public void move() {
	
		
		if(this.getX()>this.newX) {
			if(this.count==2)
				this.setX(this.getX());
			else
				this.setX(this.getX()-5);	
		}
		
		if(this.getX()<this.newX) {
			if(this.count==2) 
				this.setX(this.getX());
			else	
				this.setX(this.getX()+5);
		}
		
		if(this.getY()<=this.newY) {
			if(this.count==2) 
				this.setY(this.getY()+5);
			else	
				this.setY(this.getY()+5);
		}
		
		if(this.getY()>=this.newY) {
			if(this.count==2) 
				this.setY(this.getY()+5);
			else	
				this.setY(this.getY()-5);
		}

		this.enemyDelay++;
		
		if(this.enemyDelay==150 && this.count <2) {
				this.setnewX(random.nextInt(950));
				this.setnewY(random.nextInt(200));
				this.setCount(this.getCount()+1);
				this.setEnemyDelay(0);
			
		}
		
	}
	
	public void fire() {
		List<Bomb> bomb = this.getBombs();
		
		if (this.shoot_counter >= 25) {
			bomb.add(new Bomb(this.getX() + this.getWidth()/2-5, this.getY() + this.getHeight()-9, "../resources/images/missile_enemy.png"));
			this.shoot_counter = 0;
		}
		
	}

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getEnemyDelay() {
		return enemyDelay;
	}


	public void setEnemyDelay(int enemyDelay) {
		this.enemyDelay = enemyDelay;
	}


	public int getnewX() {
		return newX;
	}


	public void setnewX(int newX) {
		this.newX = newX;
	}


	public int getnewY() {
		return newY;
	}


	public void setnewY(int newY) {
		this.newY = newY;
	}





	
}

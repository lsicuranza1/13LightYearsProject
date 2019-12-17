package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnemiesSpaceShip extends EnemySpaceshipStructure {
	
//	private Bomb bomb;

	Random random = new Random();
	private int count = 0; // count the position to reached before exit	(2)
	
	private int enemyDelay = 0;  // delay to let enemy move again
	private int newX_1 = random.nextInt(950);
	private int newY_1 = random.nextInt(200);
	
	
	public EnemiesSpaceShip(int x, int y, String path) {
		super(x, y, path);
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
				newX_1 = random.nextInt(950);
				newY_1 = random.nextInt(200);
				this.count++;
				this.enemyDelay=0;
			
		}
		


	}
	

	public void fire() {
		int x = this.getX();
		int y = this.getY();
		int width = this.getWidth();
		int height = this.getHeight();
		List<Bomb> bomb = this.getBombs();
		new Thread() {
			@Override
			public void run() {
				try {
					bomb.add(new Bomb(x + width/2-5, y + height-9, "../resources/images/missile_enemy.png"));
					//isShooting = true;
					Thread.sleep(500);
					//isShooting = false;
				} catch (InterruptedException ex) {
					Logger.getLogger(SpaceShip.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.start();
	}
	
	


	
}

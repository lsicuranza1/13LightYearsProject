package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnemiesSpaceShip extends EnemySpaceshipStructure {
	
//	private Bomb bomb;

	Random random = new Random();
	private boolean isShooting = false;
	private int newX_1 = random.nextInt(1000);
	private int newY_1 = random.nextInt(200);
	
	private int newX_2 = random.nextInt(1000);
	private int newY_2 = random.nextInt(200);
	
	private List<Integer> listaX = new ArrayList<>();
	private List<Integer> listaY = new ArrayList<>();
	
	
		
	
	public EnemiesSpaceShip(int x, int y, String path) {
		super(x, y, path);
		this.listaY = this.createRandomListY();
		this.listaX = this.createRandomListX();

		
		
		
	}

	public List<Integer> createRandomListX() {
		List<Integer> listaX = new ArrayList<>();
		for(int i = 0 ; i< 4 ; i++) {
			listaX.add(random.nextInt(1000));
		}
		return listaX;
	}
	
	public List<Integer> createRandomListY() {
		List<Integer> listaY = new ArrayList<>();
		for(int i = 0 ; i< 4 ; i++) {
			listaY.add(random.nextInt(200));
		}
		return listaY;
	}
	
	
	public void move() {
	
		if(this.getX()>newX_1) {
			this.setX(this.getX()-5);
		}
		
		if(this.getX()<newX_1) {
			this.setX(this.getX()+5);
		}
		
		if(this.getY()<newY_1) {
			this.setY(this.getY()+5);
		}
		
		if(this.getY()>newY_1) {
			this.setY(this.getY()-5);
		}
		
		new Thread() {
			@Override
			public void run() {
				try {
						Thread.sleep(3000);
						newX_1 = newX_2;
						newY_1 = newY_2;

				} catch (InterruptedException ex) {
					Logger.getLogger(SpaceShip.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.start();
		
		
		
		
		
	

//			this.setY(this.getY()+2);
//				if(this.getY() >= 650) {
//					this.setY(0);			
//				}

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

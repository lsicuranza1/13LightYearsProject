package game;

import java.util.Random;

public class EnemiesSpaceShip extends SpaceshipStructure {

	private boolean goDown = true;
	int i = 100;
	Random rand = new Random();
	
	public EnemiesSpaceShip(int x, int y, String path) {
		super(x, y, "../resources/images/firstEnemy.png");		
	}

	
	//movimento del nemico
	public void move () {
		
		setY(getY()+4);
//		fire();

		
	
		if(getY() >= 650) {
			goDown=true;
			setY(0);
			
		}
		
	}

	//gestione dello sparo
	public void fire() {
		Missile missile = new Missile(this.getX(), this.getY() + this.getHeight()-15,
				"../resources/images/colpo_enemy.png");
    	this.getMissiles().add(missile);
    	
	}


	
}

package game;


public class EnemiesSpaceShip extends SpaceshipStructure {
	
	private Bomb bomb;
	
	public EnemiesSpaceShip(int x, int y, String path) {
		super(x, y, path);
		bomb = new Bomb(x, y, path);
	}

	
	//movimento del nemico
	public void move () {
		
		setY(getY()+2);

		if(getY() >= 650) {
			setY(0);			
		}
	}
	
	public Bomb getBomb() {
		return bomb;
	}
	

	//gestione dello sparo
	public void fire() {
		Missile missile = new Missile(this.getX(), this.getY() + this.getHeight()-15,
				"../resources/images/colpo_enemy.png");
    	this.getMissiles().add(missile);
    	
	}
	
	public class Bomb extends Sprite{

		public Bomb(int x, int y, String imageFileName) {			
			super(x, y, "../resources/images/colpo_enemy.png");
			
		}
		
		@Override
		public void move() {
			setY(getY()+5);
			
		}
		
	}


	
}

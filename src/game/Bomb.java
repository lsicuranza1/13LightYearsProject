package game;

public class Bomb extends Sprite{

	public Bomb(int x, int y, String path) {			
		super(x, y, path);
		
	}

	public void move() {
		this.setY(getY()+7);
	}
	
}
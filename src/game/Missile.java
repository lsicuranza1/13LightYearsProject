package game;

public class Missile extends Sprite {

	private final int BOARD_WIDTH = 1000; //COSTANTE
	private final int MISSILE_SPEED = 15; //COSTANTE

	public Missile(int x, int y, String path) {
		super(x, y, path);

	}

	public void move() {

		this.setY(this.getY() - MISSILE_SPEED);
		if (this.getY() > BOARD_WIDTH) {
			this.setVisible(false);
		}
	}

}
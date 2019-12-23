package game;

public class Missile extends Sprite {

	private final int BOARD_WIDTH = 1000;
	private final int MISSILE_SPEED = 15;

	public Missile(int x, int y, String path) {
		super(x, y, path);

	}

	@Override
	public void move() {

		this.setY(this.getY() - MISSILE_SPEED);
		if (this.getY() > BOARD_WIDTH) {
			this.setVisible(false);
		}
	}
}
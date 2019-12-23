package game;

import java.awt.geom.AffineTransform;

public class Asteroid extends Sprite implements ObstacleInterface {

	private int angle;
	private AffineTransform transform;

	public Asteroid(int x, int y, String path) {
		super(x, y, path);
		this.angle = 0;
		this.transform = new AffineTransform(); // capire se metterla nelle clasi degli altri oggetti
	}

	@Override
	public void move() {

		int x = this.getX();
		int temp_y = this.getY();
		this.setY(temp_y + 5);
		int y = this.getY();
		this.setAngle(this.getAngle() + 5);

		this.transform.setToTranslation(x, y);
		this.transform.concatenate(AffineTransform.getRotateInstance(Math.toRadians(this.getAngle()),
				this.getWidth() / 2, this.getHeight() / 2));
	}

	@Override
	public AffineTransform getTransform() {
		return this.transform;
	}

	public int getAngle() {
		return this.angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

}

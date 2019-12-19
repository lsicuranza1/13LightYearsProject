package game;

import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class Asteroid extends Sprite {
	JPanel panel;
	private int angle;
	private AffineTransform transform;

	public Asteroid(int x, int y, String path) {
		super(x, y, path);
		this.angle = 0;
		this.transform = new AffineTransform();
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
				this.getWidth() / 4, this.getHeight() / 4));
		this.transform.scale(0.5, 0.5);
	}

	public AffineTransform getTransform() {
		return transform;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

}

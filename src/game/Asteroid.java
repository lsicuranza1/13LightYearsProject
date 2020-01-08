package game;

import java.awt.geom.AffineTransform;

public class Asteroid extends Sprite implements ObstacleInterface {

	private int angle;
	private AffineTransform transform;

	/**
	 * @param x
	 * @param y
	 * @param path
	 */
	public Asteroid(int x, int y, String path) {
		super(x, y, path);
		this.angle = 0;
		this.transform = new AffineTransform();
	}

	/**
	 *
	 */
	@Override
	public void move() {

		int x = this.getX();
		int temp_y = this.getY();
		this.setY(temp_y + 5);
		int y = this.getY();
		this.setAngle(this.getAngle() + 5);
		
		AffineTransform transform = new AffineTransform(); 
		transform.setToTranslation(x, y);
		transform.concatenate(AffineTransform.getRotateInstance(Math.toRadians(this.getAngle()),
				this.getWidth() / 2, this.getHeight() / 2));	
		this.setTransform(transform);
	}

	/**
	 *
	 */
	@Override
	public AffineTransform getTransform() {
		return this.transform;
	}
	
	/**
	 *
	 */
	@Override
	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}

	/**
	 * @return
	 */
	public int getAngle() {
		return this.angle;
	}

	/**
	 * @param angle
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

}

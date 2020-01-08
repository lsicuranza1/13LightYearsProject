package game;

import java.awt.geom.AffineTransform;

public class Asteroid extends Sprite implements ObstacleInterface {

	private int angle;
	private AffineTransform transform;

	/**The costructor of Asteroid.
	 * @param x X-Coordinate of the asteroid
	 * @param y Y-Coordinate of the asteroid
	 * @param path Path of the image
	 */
	public Asteroid(int x, int y, String path) {
		super(x, y, path);
		this.angle = 0;
		this.transform = new AffineTransform();
	}

	/**
	 * Method that manages the movement and the rotation of the asteroid.
	 * @see ObstacleInterface 
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
	 * Method that returns the parameter transform.
	 * @see ObstacleInterface
	 */
	@Override
	public AffineTransform getTransform() {
		return this.transform;
	}
	
	/**
	 * Method that sets the parameter transform.
	 * @see ObstacleInterface
	 */
	@Override
	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}

	/**
	 * Method that returns the parameter angle for the rotation.
	 * @return angle The angle of rotation
	 */
	public int getAngle() {
		return this.angle;
	}

	/**
	 * Method that sets the parameter angle for the rotation.
	 * @param angle The angle of rotation
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

}

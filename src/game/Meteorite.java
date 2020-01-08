package game;

import java.awt.geom.AffineTransform;

public class Meteorite extends Sprite implements ObstacleInterface {

	private AffineTransform transform;

	/**The costructor of Meteorite
	 * @param x X-Coordinate of the meteorite
	 * @param y Y-Coordinate of the meteorite
	 * @param path Path of the image
	 */
	public Meteorite(int x, int y, String path) {
		super(x, y, path);
		this.transform = new AffineTransform();
	}

	/**
	 * Method that manages the movement of the Meteorite
	 * @see ObstacleInterface
	 */
	@Override
	public void move() {

		int x = this.getX();
		int temp_y = this.getY();
		this.setY(temp_y + 10);
		int y = this.getY();
		
		AffineTransform transform = new AffineTransform();
		transform.setToTranslation(x,y);
		this.setTransform(transform);
	}

	/**
	 * Method that returns the parameter transform
	 * @see ObstacleInterface
	 * 
	 */
	@Override
	public AffineTransform getTransform() {
		return transform;
	}
	
	/**
	 * Method that sets the parameter transform
	 * @see ObstacleInterface
	 */
	@Override
	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}
}

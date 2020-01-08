package game;

import java.awt.geom.AffineTransform;

public interface ObstacleInterface {
	
	/**
	 * It manages the movement of the obstacle.
	 */
	public void move();
	
	/**
	 * Method that returns the parameter transform.
	 * @return The parameter transform
	 */
	public AffineTransform getTransform();
	
	/**
	 * Method that sets the parameter transform.
	 * @param transform The parameter transform
	 */
	public void setTransform(AffineTransform transform);
	
}

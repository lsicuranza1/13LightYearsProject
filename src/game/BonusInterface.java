package game;

import java.awt.geom.AffineTransform;

public interface BonusInterface {
	
	/**
	 * It manages the movement of the bonus.
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

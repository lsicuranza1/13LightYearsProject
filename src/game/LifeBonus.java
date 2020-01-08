package game;

import java.awt.geom.AffineTransform;

public class LifeBonus extends Sprite implements BonusInterface{
	
	private AffineTransform transform;

	/** The costructor of LifeBonus
	 * @param x X-Coordinate of the Life 
	 * @param y Y-Coordinate of the Life
	 * @param imageFileName Path of the image
	 */
	public LifeBonus(int x, int y, String imageFileName) {
		super(x, y, imageFileName);
		this.transform = new AffineTransform();
	}

	/**
	 *Method that manages the movement of the LifeBonus.
	 *@see BonusInterface
	 */
	@Override 
	public void move() {
		
		int x = this.getX();
		int temp_y = this.getY();
		this.setY(temp_y + 5);
		int y = this.getY();

		this.transform.setToTranslation(x, y);
		
	}

	/**
	 * Method that returns the parameter transform.
	 * @see BonusInterface
	 */
	@Override
	public AffineTransform getTransform() {
		return this.transform;
	}
	
	/**
	 * Method that sets the parameter transform.
	 * @see BonusInterface
	 */
	@Override
	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}
 
}

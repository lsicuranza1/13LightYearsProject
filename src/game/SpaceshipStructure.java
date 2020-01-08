package game;

public abstract class SpaceshipStructure extends Sprite {

	/**The costructor of SpaceshipStructure
	 * @param x X-Coordinate 
	 * @param y Y-Coordinate 
	 * @param fileName Path of the image
	 */
	public SpaceshipStructure(int x, int y, String fileName) {
		super(x, y, fileName);
	}

	/**
	 *  The method that allows to the spaceship to fire some missiles.
	 *  
	 */
	protected abstract void fire();

}
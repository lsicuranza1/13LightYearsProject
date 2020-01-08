package game;

public abstract class SpaceshipStructure extends Sprite {

	/**
	 * @param x
	 * @param y
	 * @param fileName
	 */
	public SpaceshipStructure(int x, int y, String fileName) {
		super(x, y, fileName);
	}

	/**
	 * 
	 */
	protected abstract void fire();

}
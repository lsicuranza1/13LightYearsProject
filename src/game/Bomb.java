package game;

import javax.sound.sampled.Clip;

public class Bomb extends Sprite{
	
    public static Sound enemyShootSound;
    public static Clip enemyShootClip;

	/** The constructor of Bomb. 
	 * @param x X-Coordinate of the bomb
	 * @param y Y-Coordinate of the bomb
	 * @param path Path of the image
	 */
	public Bomb(int x, int y, String path) {			
		super(x, y, path);
		
		enemyShootClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyShoot.wav"));
		enemyShootSound = new Sound(enemyShootClip);
		enemyShootSound.playSound();	 
	}

	/**
	 * Method that manages the movement of the Bomb.
	 * 
	 */
	public void move() {
		this.setY(getY()+7);
	}
	
}
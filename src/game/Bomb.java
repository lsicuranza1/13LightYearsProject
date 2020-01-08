package game;

import javax.sound.sampled.Clip;

public class Bomb extends Sprite{
	
    public static Sound enemyShootSound;
    public static Clip enemyShootClip;

	/**
	 * @param x
	 * @param y
	 * @param path
	 */
	public Bomb(int x, int y, String path) {			
		super(x, y, path);
		
		enemyShootClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyShoot.wav"));
		enemyShootSound = new Sound(enemyShootClip);
		enemyShootSound.playSound();	 
	}

	/**
	 * 
	 */
	public void move() {
		this.setY(getY()+7);
	}
	
}
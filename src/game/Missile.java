package game;
import javax.sound.sampled.Clip;
import game.Utilities;
import game.Sound;

public class Missile extends Sprite {

	private final int BOARD_WIDTH = 600; //COSTANTE
	private final int MISSILE_SPEED = 15; //COSTANTE
	
	public static Sound shipShootSound;
    public static Clip shipShootClip;

	public Missile(int x, int y, String path) {
		super(x, y, path);
		
		if(Settings.soundEffects == true) {
			shipShootClip = Utilities.LoadSound(getClass().getResource("../resources/sound/shipShoot2.wav"));
			shipShootSound = new Sound(shipShootClip);
			shipShootSound.playSound();
		}
		
		else;


	}

	public void move() {

		this.setY(this.getY() - MISSILE_SPEED);
		if (this.getY() > BOARD_WIDTH) {
			this.setVisible(false);
		}
	}

}
package game;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.imageio.ImageIO;

public class Sprite {

	private int x;
	private int y;
	private Rectangle2D rectangle;
	private BufferedImage image;
	private boolean visible = true;
	public static Sound enemyExplosionSound; 
    public static Clip enemyExplosionClip;

	/**
	 * @param x
	 * @param y
	 * @param imageFileName
	 */
	public Sprite(int x, int y, String imageFileName) {
		this.x = x;
		this.y = y;
		this.loadImage(imageFileName);
		this.rectangle = new Rectangle(x, y, this.getWidth(), this.getHeight());
	}

	/**
	 * @param imageFileName
	 */
	private void loadImage(String imageFileName) {
		
		try {
			this.image = ImageIO.read(getClass().getResource(imageFileName));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Image not loaded");
		}
	}

	/**
	 * @return
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @return
	 */
	public int getWidth() {
		return this.image.getWidth(null);
	}

	/**
	 * @return
	 */
	public int getHeight() {
		return this.image.getHeight(null);
	}

	/**
	 * @return
	 */
	public Rectangle2D getBounds() {
		return rectangle;
	}

	/**
	 * 
	 */
	public void setBounds() {
		this.rectangle.setFrame(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	/**
	 * 
	 */
	public void removeBoundsObstacles() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyExplosion2.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}
	
	/**
	 * 
	 */
	public void removeBoundsEnemies() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyExplosion.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}
	
	/**
	 * 
	 */
	public void removeBoundsBonus() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/bonus.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}

}
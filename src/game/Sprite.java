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
	 * The costructor of Sprite
	 * @param x X-Coordinate 
	 * @param y Y-Coordinate 
	 * @param imageFileName Path of the image
	 */
	public Sprite(int x, int y, String imageFileName) {
		this.x = x;
		this.y = y;
		this.loadImage(imageFileName);
		this.rectangle = new Rectangle(x, y, this.getWidth(), this.getHeight());
	}

	/**
	 * This method allows us the load of the image
	 * @param imageFileName A string that represents the filename
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
	 * Method that returns the parameter Visible
	 * @return The Visible boolean value 
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Method that sets the parameter Visible 
	 * @param visible The Visible value
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * Method that returns the parameter X
	 * @return The X value 
	 */
	public int getX() {
		return x;
	}

	/**
	 * Method that returns the parameter Y
	 * @return The Y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * Method that sets the parameter X 
	 * @param x The x value
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Method that sets the parameter Y
	 * @param y The y value
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Method that return the Image value
	 * @return The image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * Method that returns the image width
	 * @return The width
	 */
	public int getWidth() {
		return this.image.getWidth(null);
	}

	/**
	 * Method that returns the image height
	 * @return The height
	 */
	public int getHeight() {
		return this.image.getHeight(null);
	}

	/**
	 * Method that returns the Bounds of an image
	 * @return A Rectangle2D 
	 */
	public Rectangle2D getBounds() {
		return rectangle;
	}

	/**
	 *  Method that sets the bounds of an image
	 */
	public void setBounds() {
		this.rectangle.setFrame(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	/**
	 * It removes the Obstacles bounds.
	 */
	public void removeBoundsObstacles() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyExplosion2.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}
	
	/**
	 * It removes the Enemy bounds.
	 */
	public void removeBoundsEnemies() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyExplosion.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}
	
	/**
	 * It removes the Bonus bounds.
	 */
	public void removeBoundsBonus() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/bonus.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}

}
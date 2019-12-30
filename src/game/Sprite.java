package game;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;

public class Sprite {

	private int x;
	private int y;
	private Rectangle2D rectangle;
	private BufferedImage image;
	private boolean visible = true;
	
	public static Sound enemyExplosionSound;
    public static Clip enemyExplosionClip;

	public Sprite(int x, int y, String imageFileName) {
		this.x = x;
		this.y = y;
		this.loadImage(imageFileName);
		this.rectangle = new Rectangle(x, y, this.getWidth(), this.getHeight());

	}

	private void loadImage(String imageFileName) {
		try {
			image = ImageIO.read(getClass().getResource(imageFileName));
		} catch (IOException e) { //gestire l'eccezione nel contesto in cui viene istanziato l'oggetto
			e.printStackTrace();
			System.out.println("Image not loaded");
		}

	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getWidth() {
		return this.image.getWidth(null);
	}

	public int getHeight() {
		return this.image.getHeight(null);
	}

	public Rectangle2D getBounds() {
		return rectangle;
	}

	public void setBounds() {
		this.rectangle.setFrame(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	public void removeBoundsObstacles() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyExplosion2.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}
	
	public void removeBoundsEnemies() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyExplosion.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}
	
	public void removeBoundsBonus() {
		this.rectangle.setFrame(0, 0, 0, 0);
		enemyExplosionClip = Utilities.LoadSound(getClass().getResource("../resources/sound/enemyExplosion.wav"));
		enemyExplosionSound = new Sound(enemyExplosionClip);
		enemyExplosionSound.playSound();
	}
	
	

}
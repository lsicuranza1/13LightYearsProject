package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Asteroid extends AbstractSprite {
    Rectangle2D rectangle;
    Image asteroidImage;
    JPanel panel;
    int x, y;
    int angle;
    private AffineTransform transform;
    private AffineTransform transform2;
    private AffineTransform M;
    
    public Asteroid(JPanel panel, Image image, int x, int y) {
        this.panel = panel;
        this.asteroidImage = image;
        this.x = x;
        this.y = y;
		angle = 0;
    	this.transform = new AffineTransform();
		rotationSpeed = Math.random();
        rectangle = new Rectangle2D.Double(
                x, y, image.getWidth(panel), image.getHeight(panel));
    }

    public void drawAsteroid(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
      	g2d.drawImage(asteroidImage, transform, panel);
    }

    public void move() {
    	this.transform.setToTranslation(x,y+=3);
        this.transform.concatenate(transform2.getRotateInstance(Math.toRadians(angle=angle+1), x/9, y/9));
    }
}

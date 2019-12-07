package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Asteroid extends Sprite {
	Rectangle2D rectangle;
    JPanel panel;
    int x, y;
    int angle;
    private AffineTransform transform;
    private AffineTransform transform2;
    
    public Asteroid(int x, int y, String path) {
    	super(x, y, path);
		angle = 0;
    	this.transform = new AffineTransform();
        rectangle = new Rectangle2D.Double(x, y, super.getImage().getWidth(), super.getImage().getHeight());
    }

    public void drawAsteroid(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
      	g2d.drawImage(super.getImage(), transform, panel);
    }

    @Override
    public void move() {
    	this.transform.setToTranslation(x,y+=3);
        this.transform.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle=angle+1), x/9, y/9));
    }

	public AffineTransform getTransform2() {
		return transform2;
	}

	public void setTransform2(AffineTransform transform2) {
		this.transform2 = transform2;
	}
}

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
    	this.x=x;
    	this.y=y;
		angle = 0;
    	this.transform = new AffineTransform();
        rectangle = new Rectangle2D.Double(x, y, super.getImage().getWidth(), super.getImage().getHeight());
    }

    public void drawAsteroid(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
      	g2d.drawImage(super.getImage(),transform, panel);
    }

    @Override
    public void move() {

      	 this.transform.setToTranslation(x,y+=10);
      	 this.transform.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle=angle+5),super.getImage().getWidth(panel)/2,super.getImage().getHeight(panel)/2));
    }

	public AffineTransform getTransform2() {
		return transform2;
	}
	
	public AffineTransform getTransform() {
		return transform;
	}

	public void setTransform2(AffineTransform transform2) {
		this.transform2 = transform2;
	}
}

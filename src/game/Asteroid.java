package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Asteroid extends Sprite {
	Rectangle2D rectangle;
    JPanel panel;
    int angle;
    private AffineTransform transform;
    
    public Asteroid(int x, int y, String path) {
    	super(x, y, path);
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
         
    	 int x = this.getX();
    	 int temp_y = this.getY();
    	 this.setY(temp_y+10);
    	 int y = this.getY();
    	
      	 this.transform.setToTranslation(x,y);
      	 this.transform.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle=angle+5),super.getWidth()/2,super.getHeight()/2));
    }

	
	public AffineTransform getTransform() {
		return transform;
	}


}

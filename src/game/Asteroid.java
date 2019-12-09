package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Asteroid extends Sprite {
    JPanel panel;
    private int angle;
    private AffineTransform transform;
    
    public Asteroid(int x, int y, String path) {
    	super(x, y, path);
		this.angle = 0;
    	this.transform = new AffineTransform();
    }

    public void drawAsteroid(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
      	g2d.drawImage(super.getImage(),transform, panel);
    }

    @Override
    public void move() {
         
    	 int x = this.getX();
    	 int temp_y = this.getY();
    	 this.setY(temp_y+6);
    	 int y = this.getY();
    	 //this.setAngle(this.getAngle() + 5);
    	
      	 this.transform.setToTranslation(x,y);
      	 this.transform.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle=angle+1),super.getWidth()/5,super.getHeight()/5));
    }

	
	public AffineTransform getTransform() {
		return transform;
	}
	
	public int getAngle() {
		return angle;
	}
	
	public void setAngle(int angle) {
		this.angle = angle;
	}


}

package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class Asteroid extends Sprite{
    JPanel panel;
    int x, y;
    int angle;
    private AffineTransform transform;

	 public Asteroid(JPanel panel, int x, int y) {
		 super(x,y,"../resources/images/asteroid-icon.png");
         this.panel = panel;
         this.angle = 0;
	 }
	 
	 @Override
	 public void move() {
		 if(angle==361) {
    		 angle = 0;
    	 }
        Image asteroidImage = super.getImage();
        this.transform.setToTranslation(x,y+=3);           
        this.transform.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle=angle+5),asteroidImage.getWidth(panel)/2,asteroidImage.getHeight(panel)/2));
	 }
	 
	 public void drawAsteroid(Graphics g) {
         // g.drawImage(asteroidImage, x, y, panel);
      	    Graphics2D g2d = (Graphics2D) g;
        	g2d.drawImage(super.getImage(), transform, panel);
      }
	 
	 
}

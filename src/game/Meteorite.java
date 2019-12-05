package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class Meteorite extends Sprite{
	JPanel panel;
    int x, y;
    int angle;
    private AffineTransform transform;

	 public Meteorite(JPanel panel, int x, int y) {
		 super(x,y,"../resources/images/fiery-meteorite-icon.png");
         this.panel = panel;
         this.angle = 0;
	 }
	 
	 @Override
	 public void move() {
		 
        this.transform.setToTranslation(x,y+=3);           
        
	 }
	 
	 public void drawAsteroid(Graphics g) {
      	    Graphics2D g2d = (Graphics2D) g;
        	g2d.drawImage(super.getImage(), transform, panel);
      }
}

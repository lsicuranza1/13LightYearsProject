package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Meteorite extends Sprite {

    private AffineTransform transform;


    public Meteorite(int x, int y, String path) {
    	super(x, y, path);
    	this.transform = new AffineTransform();
    }
    
//    public void drawMeteorite(Graphics g) {
//   	 Graphics2D g2d = (Graphics2D) g;
//   	 g2d.drawImage(super.getImage(),transform, panel);
//   }

   public void move() {
	   
	 int x = this.getX();
	 int temp_y = this.getY();
	 this.setY(temp_y+10);
	 int y = this.getY();
   	 this.transform.setToTranslation(x,y);
   	 
   }
   
   public AffineTransform getTransform() {
		return transform;
	}
}

package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public abstract class Sprite {

	private double x;
	private double y;
	private Rectangle2D rectangle;
    private ImageIcon imgIcon;

    public Sprite(double x, double y, String imageFileName) {
        this.x = x;
        this.y = y;
        this.imgIcon = new ImageIcon(imageFileName);
        this.rectangle = new Rectangle2D.Double(x, y, imgIcon.getIconWidth(), imgIcon.getIconHeight());
    }
   
    public ImageIcon getImageIcon() {
        return imgIcon;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public abstract void move(double x, double y);

}

package game;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;



public abstract class Sprite {

    private double x;
    private double y;
    protected Rectangle2D rectangle;
    private ImageIcon imgIcon;

    

    public Sprite(double x, double y,  String imageFileName) {

        this.x = x;
        this.y = y;
        this.imgIcon = new ImageIcon(imageFileName);
        this.rectangle = new Rectangle2D.Double(x, y, imgIcon.getIconWidth(), imgIcon.getIconHeight());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void setX(double x) {
    	this.x = x;
    }

    public void setY(double y) {
    	this.y = y;
    }
    public ImageIcon getImageIcon() {
        return imgIcon;
    }
    
//	public int getWidth() {
//		return width;
//	}
//
//	public void setWidth(int width) {
//		this.width = width;
//	}
//
//	public int getHeight() {
//		return height;
//	}
//
//	public void setHeight(int height) {
//		this.height = height;
//	}
    
    public abstract void move();
    
}
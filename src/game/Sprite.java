package game;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



public abstract class Sprite {

    private int x;
    private int y;
    private Rectangle2D rectangle;
    private BufferedImage image;
    

    public Sprite(int x, int y,  String imageFileName) {
        this.x = x;
        this.y = y;
        this.loadImage(imageFileName);
        this.setRectangle(new Rectangle2D.Double(x, y, this.getWidth(), this.getHeight()));
    }
    
    
    //------Template method---
    private void loadImage(String imageFileName) {
//        ImageIcon ii = new ImageIcon(imageName);
//        image =  ii.getImage();
        try {
			image = ImageIO.read(getClass().getResource(imageFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int x) {
    	this.x = x;
    }

    public void setY(int y) {
    	this.y = y;
    }
    public BufferedImage getImage() {
        return image;
    }
    
	public int getWidth() {
		return this.image.getWidth(null);
	}
	
	public int getHeight() {
	    return this.image.getHeight(null);
	}

    public abstract void move();


	public Rectangle2D getRectangle() {
		return rectangle;
	}


	public void setRectangle(Rectangle2D rectangle) {
		this.rectangle = rectangle;
	}
    
}
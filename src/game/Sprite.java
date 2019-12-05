package game;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public abstract class Sprite {

    private int x;
    private int y;
    private Rectangle2D rectangle;
    private BufferedImage image;
    

    public Sprite(int x, int y,  String imageFileName) {
        this.x = x;
        this.y = y;
        this.loadImage(imageFileName);
        this.rectangle = new Rectangle2D.Double(x, y, this.getWidth(), this.getHeight());
    }
    
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
    
    public Image getImmage() {
    	 Image asteroidImage = null;
    	 try {
             asteroidImage = ImageIO.read(getClass().getResource("../resources/images/asteroid-icon.png"));
         } catch (IOException ex) {
             Logger.getLogger(ObstaclesBackground.class.getName()).log(Level.SEVERE, null, ex);
         }
    	 return asteroidImage;
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
    
}
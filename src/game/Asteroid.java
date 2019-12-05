package game;

public class Asteroid extends Sprite {
	
	
    public Asteroid(double x, double y, String imageFileName) {
    	super(x, y, imageFileName);
    }

    @Override
    public void move() {
    	y += 3;
    }
}

package game;

public class Meteorite extends Sprite {
	
    public Meteorite(double x, double y, String imageFileName) {
    	super(x, y, imageFileName);
    }

    @Override
    public void move(double x, double y) {
    	y += 10;
    }
}

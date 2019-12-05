package game;

import javax.swing.ImageIcon;

/**
 *
 * @author lorenzosic
 */
public class Missile extends Sprite {

    private final int BOARD_WIDTH = 1000;
    private final int MISSILE_SPEED = 2;
    private double x = getX();
    private double y = getY();
    private boolean visible;                   //DA CANCELLARE

    public Missile(double d, double e, String path) {
        super(d, e, path);
        
        initMissile();
    }
    

	private void initMissile() {
        
        //getImageDimensions();
    }

    public void move() {
        
        y -= MISSILE_SPEED;
        
        if (y > BOARD_WIDTH) {
            visible = false;
        }
    }
}

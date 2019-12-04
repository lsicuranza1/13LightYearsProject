package game;

/**
 *
 * @author lorenzosic
 */
public class Missile extends Sprite {

    private final int BOARD_WIDTH = 1000;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("src/resources/missile.png");  
        getImageDimensions();
    }

    public void move() {
        
        y -= MISSILE_SPEED;
        
        if (y > BOARD_WIDTH) {
            visible = false;
        }
    }
}

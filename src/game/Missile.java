package game;

/**
 *
 * @author lorenzosic
 */
public class Missile extends Sprite {

    private final int BOARD_WIDTH = 1000;
    private final int MISSILE_SPEED = 2;
//    private double x = getX();
//    private double y = getY();
    private boolean visible;                   //DA CANCELLARE

    public Missile(int x, int y, String path){
        super(x, y, path);
        this.visible = true; 
//        initMissile();
    }
    

//	private void initMissile() {
//        
//        //getImageDimensions();
//    }
    
    public boolean isVisible() {
        return visible;
    }

    public void move() {
        
        this.setY(this.getY() - MISSILE_SPEED);
        //System.out.println(this.getY() - MISSILE_SPEED);
        if (this.getY() > BOARD_WIDTH) {
            visible = false;
        }
    }
}

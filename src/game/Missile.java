package game;

import javax.swing.ImageIcon;

/**
 *
 * @author lorenzosic
 */
public class Missile extends AbstractSprite {

    private final int BOARD_WIDTH = 1000;
    private final int MISSILE_SPEED = 5;
//    private double x = getX();
//    private double y = getY();

    public Missile(int x, int y, String path){
        super(x, y, path); 
//        initMissile();
    }
    

//	private void initMissile() {
//        
//        //getImageDimensions();
//    }
    
    

    public void move() {
        
        this.setY(this.getY() - MISSILE_SPEED);
        if (this.getY() > BOARD_WIDTH) {
            this.setVisible(false);
        }
    }
    
    public void move_colpo() {
    	
    	this.setY(this.getY() + 2);
    	
    	if(this.getY() > BOARD_WIDTH) {
    		this.setVisible(false);
    	}
    }
}
package game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public abstract class SpaceshipStructure extends Sprite{
	
	private List<Missile> missiles;
    //private boolean visible;

	
	public SpaceshipStructure(int x, int y, String fileName) {
		super(x, y, fileName);
		//visible = true;
		missiles = new ArrayList<Missile>();

	}

	public List<Missile> getMissiles() {
	        return missiles;
	 }
	 

//	public boolean isVisible() {
//	      return visible;
//	}
//
//	public void setVisible(Boolean visible) {
//	      this.visible = visible;
//	}

	public abstract void fire();

//	public abstract void move();


}

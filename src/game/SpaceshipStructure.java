package game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class SpaceshipStructure extends Sprite{
	
	private List<Missile> missiles;
	
    private boolean visible;
    private ImageIcon imgIcon;
	
	public SpaceshipStructure(double x, double y, String string) {
		super(x, y, null);
		visible = true;
		missiles = new ArrayList<Missile>();

	}

	public List<Missile> getMissiles() {
	        return missiles;
	 }
	 

	public boolean isVisible() {
	      return visible;
	}

	public void setVisible(Boolean visible) {
	      this.visible = visible;
	}


	public  void fire() {
		
	}

	@Override
	public void move() {
		
		
	}


}

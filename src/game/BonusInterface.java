package game;

import java.awt.geom.AffineTransform;

public interface BonusInterface {
	
	public void move();
	public AffineTransform getTransform();
	public void setTransform(AffineTransform transform);

}

package game;

import java.awt.geom.AffineTransform;

public interface ObstacleInterface {
	
	public void move();
	public AffineTransform getTransform();
	public void setTransform(AffineTransform transform);
	
}

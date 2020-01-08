package game;

import java.awt.geom.AffineTransform;

public class Meteorite extends Sprite implements ObstacleInterface {

	private AffineTransform transform;

	public Meteorite(int x, int y, String path) {
		super(x, y, path);
		this.transform = new AffineTransform();
	}

	@Override
	public void move() {

		int x = this.getX();
		int temp_y = this.getY();
		this.setY(temp_y + 10);
		int y = this.getY();
		
		AffineTransform transform = new AffineTransform();
		transform.setToTranslation(x,y);
		this.setTransform(transform);
	}

	@Override
	public AffineTransform getTransform() {
		return transform;
	}
	
	@Override
	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}
}

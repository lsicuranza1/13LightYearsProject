package game;

import java.awt.geom.AffineTransform;

public class ScoreBonus extends Sprite implements BonusInterface{
	
	private AffineTransform transform;

	public ScoreBonus(int x, int y, String imageFileName) {
		super(x, y, imageFileName);
		this.transform = new AffineTransform();
	}

	@Override
	public void move() {
		
		int x = this.getX();
		int temp_y = this.getY();
		this.setY(temp_y + 5);
		int y = this.getY();

		this.transform.setToTranslation(x, y);
		
	}

	@Override
	public AffineTransform getTransform() {
		return this.transform;
	}
	
	@Override
	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}


}
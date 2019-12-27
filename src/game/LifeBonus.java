package game;

import java.awt.geom.AffineTransform;

public class LifeBonus extends Sprite implements BonusInterface{
	
	private String imageFileName =  "example";
	private AffineTransform transform;
	private int angle;

	public LifeBonus(int x, int y, String imageFileName) {
		super(x, y, imageFileName);
		this.transform = new AffineTransform();
		this.angle = 0;
	}

	@Override
	public void move() {
		
		int x = this.getX();
		int temp_y = this.getY();
		this.setY(temp_y + 5);
		int y = this.getY();
		this.setAngle(this.getAngle() + 5);

		this.transform.setToTranslation(x, y);
		this.transform.concatenate(AffineTransform.getRotateInstance(Math.toRadians(this.getAngle()),
				this.getWidth() / 2, this.getHeight() / 2));
		
	}

	@Override
	public AffineTransform getTransform() {
		return null;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

}

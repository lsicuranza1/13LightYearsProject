package game;

import java.awt.geom.AffineTransform;

public class Meteorite extends Sprite {

	private AffineTransform transform;

	public Meteorite(int x, int y, String path) {
		super(x, y, path);
		this.transform = new AffineTransform(); //scegliere se metterlo anche nelle altre classi per la traslazione
	}

	public void move() {

		int x = this.getX();
		int temp_y = this.getY();
		this.setY(temp_y + 10);
		int y = this.getY();
		this.transform.setToTranslation(x, y);

	}

	public AffineTransform getTransform() {
		return transform;
	}
}

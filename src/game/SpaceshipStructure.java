package game;

import java.util.ArrayList;
import java.util.List;

public abstract class SpaceshipStructure extends Sprite {

	private List<Missile> missiles;

	public SpaceshipStructure(int x, int y, String fileName) {
		super(x, y, fileName);

		missiles = new ArrayList<Missile>();

	}

	public List<Missile> getMissiles() {
		return missiles;
	}

	public abstract void fire();

}
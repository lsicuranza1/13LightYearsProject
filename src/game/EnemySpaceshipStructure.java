package game;

import java.util.ArrayList;
import java.util.List;

public abstract class EnemySpaceshipStructure extends Sprite {

	private List<Bomb> bombs;

	public EnemySpaceshipStructure(int x, int y, String fileName) {
		super(x, y, fileName);

		bombs = new ArrayList<Bomb>();

	}

	public List<Bomb> getBombs() {
		return bombs;
	}

	public abstract void fire();

}

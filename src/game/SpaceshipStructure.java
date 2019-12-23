package game;


public abstract class SpaceshipStructure extends Sprite {

//	private List<Missile> missiles;

	public SpaceshipStructure(int x, int y, String fileName) {
		super(x, y, fileName);

//		missiles = new ArrayList<Missile>();

	}

//	public List<Missile> getMissiles() {
//		return missiles;
//	}

	protected abstract void fire();

}
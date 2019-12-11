package game;

public class EnemiesSpaceShip extends SpaceshipStructure {

	private boolean goDown = true;
	int i = 100;

	public EnemiesSpaceShip(int x, int y, String path) {
		super(x, y, path);
	}

	public void move() {

		if (goDown) {
			setX(getX() + 5);
			if (getX() == i) {
				fire();
				i += 200;
			}
			if (getX() == 950) {
				goDown = false;
				setY(getY() + 50);
				i = getX() - 150;
			}
		} else {
			setX(getX() - 5);
			if (getX() == i - 150) {
				fire();
				i -= 200;
			}
			if (getX() == 0) {
				setY(getY() + 50);
				goDown = true;
				i = getX() + 200;
			}
		}

		if (getY() == 650) {
			goDown = true;
			setY(0);
			setX(0);
			i = 100;
		}

	}

	public void fire() {
		Missile missile = new Missile(this.getX(), this.getY() + this.getHeight() - 15,
				"../resources/images/colpo.png");
		this.getMissiles().add(missile);

	}

}

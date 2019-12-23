package game.patterns.factoryMethod;

import java.util.Random;

import game.Meteorite;
import game.Sprite;

public class MeteoriteFactory extends SpriteFactory {
	
	static int D_W = 1000; //COSTANTE
	static Random random = new Random();
	static int randX1;
	static int y_meteorite = -500;
	static String fileNameMeteorite = "../resources/images/meteorite.png";
	
	public MeteoriteFactory() {
		super();
		this.randX1 = randX1;
		this.y_meteorite = -500;
		this.fileNameMeteorite = fileNameMeteorite;
	}
	
	public static Sprite getSprite() {
		randX1 = random.nextInt(D_W);
		return new Meteorite(randX1, y_meteorite, fileNameMeteorite);
	}
}

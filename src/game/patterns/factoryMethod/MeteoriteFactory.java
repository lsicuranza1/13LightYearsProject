package game.patterns.factoryMethod;

import java.util.Random;
import game.Meteorite;
import game.Sprite;

public class MeteoriteFactory extends ObstacleFactory {
	
	static int width = 800; 
	static Random random = new Random();
	static int randX;
	static int yMeteorite = -50;
	static String fileNameMeteorite = "../resources/images/meteorite.png";
	
	/**
	 * The costructor of the MeteoriteFactory class.
	 */
	public MeteoriteFactory() {
		super();
	}
	
	/**
	 * It create a new Meteorite object
	 * @return A new Meteorite 
	 */
	public static Sprite getObstacle() {
		randX = random.nextInt(width);
		return new Meteorite(randX, yMeteorite, fileNameMeteorite);
	}
}

package game.patterns.factoryMethod;

import java.util.Random;
import game.Asteroid;
import game.Sprite;

public class AsteroidFactory extends ObstacleFactory {
	
	static int width = 800;
	static Random random = new Random();
	static int randX;
	static int yAsteroid = -50;
	static String fileNameAsteroid = "../resources/images/asteroid-icon.png";
	
	/**
	 * The costructor of the AsteroidFactory
	 */
	public AsteroidFactory() {
		super();
	}
	
	/**
	 * It create a new Asteroid object
	 * @return A new Asteroid
	 */
	public static Sprite getObstacle() {
		randX = random.nextInt(width);
		return new Asteroid(randX, yAsteroid, fileNameAsteroid);
	}

}

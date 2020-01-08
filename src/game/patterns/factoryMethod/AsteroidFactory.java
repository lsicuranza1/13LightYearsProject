package game.patterns.factoryMethod;

import java.util.Random;

import game.Asteroid;
import game.Sprite;

public class AsteroidFactory extends ObstacleFactory {
	
	static int D_W = 800;
	static Random random = new Random();
	static int randX1;
	static int y_asteroid = -50;
	static String fileNameAsteroid = "../resources/images/asteroid-icon.png";
	
	public AsteroidFactory() {
		super();
	}
	
	public static Sprite getObstacle() {
		randX1 = random.nextInt(D_W);
		return new Asteroid(randX1, y_asteroid, fileNameAsteroid);
	}

}

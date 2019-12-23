package game.patterns.factoryMethod;

import java.util.Random;

import game.Asteroid;
import game.Sprite;

public class AsteroidFactory extends SpriteFactory {
	
	static int D_W = 1000; //COSTANTE
	static Random random = new Random();
	static int randX1;
	static int y_asteroid = -500;
	static String fileNameAsteroid = "../resources/images/asteroid-icon.png";
	
	public AsteroidFactory() {
		super();
	}
	
	public static Sprite getSprite() {
		randX1 = random.nextInt(D_W);
		return new Asteroid(randX1, y_asteroid, fileNameAsteroid);
	}

}

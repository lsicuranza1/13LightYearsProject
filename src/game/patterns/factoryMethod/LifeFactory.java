package game.patterns.factoryMethod;

import java.util.Random;

import game.Life;
import game.Sprite;

public class LifeFactory extends SpriteFactory {
	
	static String fileNameLife = "../resources/images/life.png";
	
	public LifeFactory() {
		super();
		this.fileNameLife = fileNameLife;
	}
	
	public static Sprite getSprite(int xCoordLife) {
		return new Life(xCoordLife, 60, fileNameLife);
	}
}

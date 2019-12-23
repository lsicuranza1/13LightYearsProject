package game.patterns.factoryMethod;

import java.util.Random;

import game.SpaceShip;
import game.Sprite;

public class SpaceShipFactory extends SpriteFactory {

	static String fileNameSpaceShip = "../resources/images/spaceship.png";
	
	public SpaceShipFactory() {
		super();
		this.fileNameSpaceShip = fileNameSpaceShip;
	}
	
	public static Sprite getSprite() {
		return new SpaceShip(500, 400, fileNameSpaceShip);
	}

}

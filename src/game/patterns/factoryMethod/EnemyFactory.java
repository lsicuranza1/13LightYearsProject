package game.patterns.factoryMethod;

import java.util.Random;

import game.EnemySpaceShip;
import game.Sprite;

public class EnemyFactory extends SpriteFactory {
	
	int D_W = 1000; //COSTANTE
	int D_H = 600; //COSTANTE
	Random random = new Random();
	static int randX1;
	static String fileNameEnemy = "../resources/images/firstEnemy.png";
	
	public EnemyFactory() {
		super();
		this.randX1 = random.nextInt(D_W);
		this.fileNameEnemy = fileNameEnemy;
	}
	
	public static Sprite getSprite() {
		return new EnemySpaceShip(randX1, -20, fileNameEnemy);
	}
}

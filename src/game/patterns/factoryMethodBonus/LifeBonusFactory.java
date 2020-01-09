package game.patterns.factoryMethodBonus;

import java.util.Random;
import game.LifeBonus;

public class LifeBonusFactory extends BonusFactory{

	static int width = 800;
	static Random random = new Random();
	static int randX;
	static int yBonus = -50;
	static String fileNameLifeBonus = "../resources/images/life.png";

	/**
	 * It create a new LifeBonus object
	 * @return A new LifeBonus 
	 */
	public static Object getLifeBonus() {
		randX = random.nextInt(width);
		return new LifeBonus(randX,yBonus,fileNameLifeBonus);
		
	}

}

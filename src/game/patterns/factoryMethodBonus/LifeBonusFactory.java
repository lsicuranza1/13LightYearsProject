package game.patterns.factoryMethodBonus;

import java.util.Random;
import game.LifeBonus;

public class LifeBonusFactory extends BonusFactory{

	static int width = 700;
	static Random random = new Random();
	static int randX;
	static int yBonus = -50;
	static String fileNameLifeBonus = "life.png";

	public static Object getLifeBonus() {
		randX = random.nextInt(width);
		return new LifeBonus(randX,yBonus,fileNameLifeBonus);
		
	}

}

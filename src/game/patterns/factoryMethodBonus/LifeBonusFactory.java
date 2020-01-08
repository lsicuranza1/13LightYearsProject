package game.patterns.factoryMethodBonus;

import java.util.Random;
import game.LifeBonus;

public class LifeBonusFactory extends BonusFactory {
	

	static int D_W = 600;
	static Random random = new Random();
	static int randX1;
	static int y_bonus = -500;
	static String fileNameLifeBonus = "../resources/images/life.png";

	public static Object getLifeBonus() {
		randX1 = random.nextInt(D_W);
		return new LifeBonus(randX1,y_bonus,fileNameLifeBonus);
		
	}

}

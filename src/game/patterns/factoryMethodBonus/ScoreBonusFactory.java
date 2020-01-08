package game.patterns.factoryMethodBonus;

import java.util.Random;
import game.ScoreBonus;

public class ScoreBonusFactory extends BonusFactory {

	static int width = 700;
	static Random random = new Random();
	static int randX;
	static int yBonus = -50;
	static String fileNameLifeBonus = "../resources/images/x2-icon.png";

	/**
	 * @return
	 */
	public static Object getScoreBonus() {
		randX = random.nextInt(width);
		return new ScoreBonus(randX,yBonus,fileNameLifeBonus);
		
	}

}
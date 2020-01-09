package game.patterns.factoryMethodBonus;

import java.util.Random;
import game.ScoreBonus;

public class ScoreBonusFactory extends BonusFactory {

	static int width = 800;
	static Random random = new Random();
	static int randX;
	static int yBonus = -50;
	static String fileNameLifeBonus = "../resources/images/x2-icon.png";

	/**
	 * It create a new ScoreBonus object
	 * @return A new ScoreBonus 
	 */
	public static Object getScoreBonus() {
		randX = random.nextInt(width);
		return new ScoreBonus(randX,yBonus,fileNameLifeBonus);
		
	}

}
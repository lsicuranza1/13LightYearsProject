package game.patterns.factoryMethodBonus;

import java.util.Random;
import game.ScoreBonus;

public class ScoreBonusFactory {
	

	static int D_W = 600;
	static Random random = new Random();
	static int randX1;
	static int y_bonus = -300;
	static String fileNameLifeBonus = "../resources/images/x2-icon.png";

	public static Object getScoreBonus() {
		randX1 = random.nextInt(D_W);
		return new ScoreBonus(randX1,y_bonus,fileNameLifeBonus);
		
	}

}
package game.patterns.factoryMethodBonus;

public class BonusFactory {
	
public BonusFactory() {
		
	}

public Object getBonus(String objectType) {
	
	Object object = null;
	
	if(objectType.equals("life"))
		object = LifeBonusFactory.getLifeBonus();
	else if(objectType.equals("score"))
		object = ScoreBonusFactory.getScoreBonus();
	
	return object;
}


}
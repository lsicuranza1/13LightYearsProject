package game.patterns.factoryMethodBonus;

public class BonusFactory {
	
	/**
	 ** The constructor of BonusFactory class
	 */
	public BonusFactory() {
			
	}
	
	/**
	 * It returns a life or a score bonus
	 * @param objectType A string that identifies the type of object
	 * @return An object ( Life / Score )
	 */
	public Object getBonus(String objectType) {
		
		Object object = null;
		
		if(objectType.equals("life"))
			object = LifeBonusFactory.getLifeBonus();
		else if(objectType.equals("score"))
			object = ScoreBonusFactory.getScoreBonus();
		
		return object;
	}
}
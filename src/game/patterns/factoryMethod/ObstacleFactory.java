package game.patterns.factoryMethod;

public class ObstacleFactory {
	
	/**
	 * The constructor of ObstacleFactory class
	 */
	public ObstacleFactory() {
		
	}
	
	/**
	 * It returns an asteroid or a meteorite
	 * @param objectType A string that identifies the type of object
	 * @return An object ( Asteroid / Meteorite )
	 */
	public Object getObstacle(String objectType) {
		
		Object object = null;
		
		if(objectType.equals("asteroid"))
			object = AsteroidFactory.getObstacle();
		else if(objectType.equals("meteorite"))
			object = MeteoriteFactory.getObstacle();
		
		return object;
	}
}

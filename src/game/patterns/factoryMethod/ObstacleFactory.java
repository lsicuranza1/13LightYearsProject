package game.patterns.factoryMethod;

public class ObstacleFactory {
	
	public ObstacleFactory() {
		
	}
	
	public Object getObstacle(String objectType) {
		
		Object object = null;
		
		if(objectType.equals("asteroid"))
			object = AsteroidFactory.getObstacle();
		else if(objectType.equals("meteorite"))
			object = MeteoriteFactory.getObstacle();
		
		return object;
	}

}

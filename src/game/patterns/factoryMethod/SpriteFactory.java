package game.patterns.factoryMethod;

import game.Sprite;

public class SpriteFactory {
	
	public SpriteFactory() {
		
	}
	
	public Object getSprite(String objectType, int xCoordLife) {
		
		Object object = null;
		
		if(objectType.equals("asteroid"))
			object = AsteroidFactory.getSprite();
		else if(objectType.equals("meteorite"))
			object = MeteoriteFactory.getSprite();
		else if(objectType.contentEquals("enemy"))
			object = EnemyFactory.getSprite();
		else if(objectType.contentEquals("life"))
			object = LifeFactory.getSprite(xCoordLife);
		else if(objectType.contentEquals("spaceship"))
			object = SpaceShipFactory.getSprite();
		
		return object;
	}

}

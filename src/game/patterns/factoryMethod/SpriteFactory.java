package game.patterns.factoryMethod;

import game.Sprite;

public class SpriteFactory {
	
	public SpriteFactory() {
		
	}
	
	public Object getSprite(String objectType) {
		
		Object object = null;
		
		if(objectType.equals("asteroid"))
			object = AsteroidFactory.getSprite();
		else if(objectType.equals("meteorite"))
			object = MeteoriteFactory.getSprite();
		
		return object;
	}

}

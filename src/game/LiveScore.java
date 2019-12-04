package game;

public class LiveScore {

	private void allocatePoints(Entity destroyed) {
		if (destroyed == null) {
			// Not an interaction with an entity
			points += multiplier * POINTS_CLEAR_LEVEL;
			multiplier += 0.5;
		} else {
			// Tell the ship it hit something
			ship.bulletHit();
			
			// Allocate points based on what entity was destroyed
			if (destroyed instanceof Asteroid) {
				points += multiplier * POINTS_ASTEROID;
			} else if (destroyed instanceof Alien) {
				points += multiplier * POINTS_ALIEN;
			}
		}
	}
	
	
}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.SpaceShip;

public class SpaceShipTest {
	private SpaceShip spaceShip;

	@Before
	public void setUp() throws Exception {
		this.spaceShip = new SpaceShip(100, 300, "../resources/images/spaceship.png");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testGetLives() {	
		assertEquals(3, spaceShip.getLives()); //3 VALORE COSTANTE
	}
	
	@Test
	public void testLoseLife() {
		int i;
		for (i = 3; i > 0; i--) { //2 è COSTANTE VITE - 1
			spaceShip.loseLife();
			assertEquals(i - 1, spaceShip.getLives());
		}
		
		spaceShip.loseLife();
		assertNotEquals(-1, spaceShip.getLives());
	}
	
}

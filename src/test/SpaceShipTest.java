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
	public void testSetLives() {	
		spaceShip.setLives(5);
		assertEquals(5, spaceShip.getLives()); //3 VALORE COSTANTE
	}
	
	
	
	
}

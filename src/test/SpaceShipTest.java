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
	public void testGetLives() {	
		assertEquals(3, this.spaceShip.getLives());
	}
	
	@Test
	public void testSetLives() {	
		spaceShip.setLives(5);
		assertEquals(5, this.spaceShip.getLives());
	}
	
	@Test
	public void fireTest() {	
		spaceShip.setLives(5);
		assertEquals(5, this.spaceShip.getLives());
	}
		
}

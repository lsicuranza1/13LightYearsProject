package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.List;


import game.Missile;
import game.SpaceShip;

public class SpaceShipTest {
	
	private SpaceShip spaceShip;
	private int SPACESHIP_SPEED;

	@Before
	public void setUp() throws Exception {
		
		this.spaceShip = new SpaceShip(0,0, "spaceship.png");
		SPACESHIP_SPEED = 8;
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
	
	@Test
	public void testMove() {
		
		//left
		int lastX = this.spaceShip.getX();
		this.spaceShip.setLeft(true);
		this.spaceShip.move();
		int newX = lastX - this.SPACESHIP_SPEED;
		assertEquals(newX, this.spaceShip.getX());
		
		//right
		this.spaceShip.setLeft(false);
		lastX = this.spaceShip.getX();
		this.spaceShip.setRight(true);
		this.spaceShip.move();
		newX = lastX + this.SPACESHIP_SPEED;
		assertEquals(newX, this.spaceShip.getX());
		
		//up
		this.spaceShip.setRight(false);
		int lastY = this.spaceShip.getY();
		this.spaceShip.setUp(true);
		this.spaceShip.move();
		int newY = lastY - this.SPACESHIP_SPEED;
		assertEquals(newX, this.spaceShip.getY());
		
		//down
		this.spaceShip.setUp(false);
		lastY = this.spaceShip.getY();
		this.spaceShip.setDown(true);
		this.spaceShip.move();
		newY = lastY + this.SPACESHIP_SPEED;
		assertEquals(newY, this.spaceShip.getY());
		
				
	}
	
	@Test
	public void testFire() {
		
		List<Missile> missiles = this.spaceShip.getMissiles();
		
		int length = missiles.size();
		
		this.spaceShip.fire();
		
		missiles = this.spaceShip.getMissiles();
	    int length2 = missiles.size();
		assertEquals(length+1, length2);

	}
}

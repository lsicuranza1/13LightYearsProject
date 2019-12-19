package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import game.Missile;
import game.SpaceShip;

public class SpaceShipTest {

	private SpaceShip s;
	private int SPACESHIP_SPEED;
	
	@Before
	public void setUp() throws Exception {
		
	  s = new SpaceShip(0,0,"../resources/images/spaceship.png");
	  SPACESHIP_SPEED = 8;
		
		
	}

	@Test
	public void testMove() {
		
		//left
		int lastX = s.getX();
		s.setLeft(true);
		s.move();
		int newX = lastX - this.SPACESHIP_SPEED;
		assertEquals(newX, s.getX());
		
		//right
		s.setLeft(false);
		lastX = s.getX();
		s.setRight(true);
		s.move();
		newX = lastX + this.SPACESHIP_SPEED;
		assertEquals(newX, s.getX());
		
		//up
		s.setRight(false);
		int lastY = s.getY();
		s.setUp(true);
		s.move();
		int newY = lastY - this.SPACESHIP_SPEED;
		assertEquals(newX, s.getY());
		
		//down
		s.setUp(false);
		lastY = s.getY();
		s.setDown(true);
		s.move();
		newY = lastY + this.SPACESHIP_SPEED;
		assertEquals(newY, s.getY());
		
				
	}

	@Test
	public void testFire() {
		
		List<Missile> missiles = s.getMissiles();
		
		int length = missiles.size();
		
		s.fire();
		
		missiles = s.getMissiles();
	    int length2 = missiles.size();
		assertEquals(length+1, length2);
		
//		Missile m = new Missile(s.getX() + s.getWidth() / 2 - 9, s.getY() + s.getHeight() - 90, "../resources/images/missile.png");
//		Missile m2 = missiles.get(length2-1);	
//		
//		assertEquals(m, m2);
	}

}

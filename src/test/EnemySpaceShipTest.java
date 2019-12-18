package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.EnemySpaceShip;

public class EnemySpaceShipTest {
	private EnemySpaceShip e; 

	@Before
	public void setUp() throws Exception {
		e = new EnemySpaceShip(0,0, "../resources/images/spaceship.png");
	}

	@Test
	public void testMove() {
		
		//case 1
		
		e.setX(20);
		e.setnewX(10);
		e.setCount(2);
		int oldX = e.getX();
		e.move();
		assertEquals(oldX, e.getX());
		e.setCount(1);
		int oldX2 = e.getX();
		e.move();
		assertEquals(oldX2-5, e.getX());
		
		//case 2
		
		e.setX(10);
		e.setnewX(20);
		e.setCount(2);
		oldX = e.getX();
		e.move();
		assertEquals(oldX, e.getX());
		e.setCount(1);
		oldX2 = e.getX();
		e.move();
		assertEquals(oldX2+5, e.getX());
		
		//case 3
		
		e.setY(10);
		e.setnewY(20);
		e.setCount(2);
		int oldY = e.getY();
		e.move();
		assertEquals(oldY+5, e.getY());
		e.setY(10);
		e.setnewY(20);
		e.setCount(1);
		int oldY2 = e.getY();
		e.move();
		assertEquals(oldY2+5, e.getY());

		
		//case 4
		
		e.setY(20);
		e.setnewY(10);
		e.setCount(2);
		oldY = e.getY();
		e.move();
		assertEquals(oldY+5, e.getY());
		e.setY(20);
		e.setnewY(10);
		e.setCount(1);
		oldY2 = e.getY();
		e.move();
		assertEquals(oldY2-5, e.getY());
	}

	@Test
	public void testFire() {
		
		
	}

}

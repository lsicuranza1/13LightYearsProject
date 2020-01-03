/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.awt.geom.Rectangle2D;

import org.junit.Before;
import org.junit.Test;

import game.SpaceShip;

public class SpriteTest {
	
	private SpaceShip spaceship;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		spaceship = new SpaceShip(10,10,"../resources/images/spaceship.png");
		
	}
 
	/**
	 * Test method for {@link game.Sprite#Sprite(int, int, java.lang.String)}.
	 */
	@Test
	public void testSprite() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.Sprite#isVisible()}.
	 */
	@Test
	public void testIsVisible() {
		assertEquals(true,spaceship.isVisible());
	}

	/**
	 * Test method for {@link game.Sprite#setVisible(boolean)}.
	 */
	@Test
	public void testSetVisible() {
		spaceship.setVisible(false);
		assertEquals(false,spaceship.isVisible());
	}

	/**
	 * Test method for {@link game.Sprite#getX()}.
	 */
	@Test
	public void testGetX() {
		assertEquals(10,spaceship.getX());
	}

	/**
	 * Test method for {@link game.Sprite#getY()}.
	 */
	@Test
	public void testGetY() {
		assertEquals(10,spaceship.getY());
	}

	/**
	 * Test method for {@link game.Sprite#setX(int)}.
	 */
	@Test
	public void testSetX() {
		spaceship.setX(20);
		assertEquals(20,spaceship.getX());
	}

	/**
	 * Test method for {@link game.Sprite#setY(int)}.
	 */
	@Test
	public void testSetY() {
		spaceship.setY(20);
		assertEquals(20,spaceship.getY());
	}

	/**
	 * Test method for {@link game.Sprite#getImage()}.
	 */
	@Test
	public void testGetImage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.Sprite#getWidth()}.
	 */
	@Test
	public void testGetWidth() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.Sprite#getHeight()}.
	 */
	@Test
	public void testGetHeight() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.Sprite#getBounds()}.
	 */
	@Test
	public void testGetBounds() {
		assertTrue(spaceship.getBounds() instanceof Rectangle2D);
	}

	/**
	 * Test method for {@link game.Sprite#setRectangle()}.
	 */
	@Test
	public void testSetRectangle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.Sprite#move()}.
	 */
	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

}

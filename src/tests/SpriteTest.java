package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import game.SpaceShip;

public class SpriteTest {
	private SpaceShip s;
	@Before
	public void setUp() throws Exception {
		
		this.s = new SpaceShip(10,10,"../resources/images/navicella.png");
		
	}

	@Test(expected=IOException.class)
	public void testSprite() {
		SpaceShip spaceship = new SpaceShip(10,10,"../resources/images/nafefvicella.png");
	}

	@Test
	public void testIsVisible() {
		assertEquals(true, s.isVisible());
		assertNotEquals(null, s.isVisible());
	}

	@Test
	public void testSetVisible() {
		s.setVisible(false);
		assertEquals(false, s.isVisible());
	}

	@Test
	public void testGetX() {
		assertEquals(10, s.getX());
	}

	@Test
	public void testGetY() {
		assertEquals(10, s.getY());
	}

	@Test
	public void testSetX() {
		s.setX(30);
		assertEquals(30, s.getX());
	}

	@Test
	public void testSetY() {
		s.setY(50);
		assertEquals(50, s.getY());
	}

	@Test
	public void testGetImage() {
		assertNotNull(s.getImage());
		assertTrue(s.getImage() instanceof Image);
	}

	@Test
	public void testGetWidth() {
		Image img = new Image("../resources/images/navicella.png");
		assertEquals(imgIcon.getIconWidth(), s.getWidth());
	}

	@Test
	public void testGetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBounds() {
		fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

}

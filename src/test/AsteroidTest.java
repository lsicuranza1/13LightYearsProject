/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

import game.Asteroid;
import game.MainFrame;
import game.patterns.state.Modalita;


public class AsteroidTest {
	
	private Asteroid a;
	private int x;
	private int y;
	private int angle;
	private Modalita m;
	private MainFrame main ;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.x = 0;
		this.y = 0;
		this.angle = 0;
		this.a = new Asteroid(x,y,"../resources/images/asteroid-icon.png");
		m = new Modalita();
		main = MainFrame.getIstance();
		main.setFrame(new JFrame());
	}

	/**
	 * Test method for {@link game.Asteroid#move()}.
	 */
	@Test
	public void testMove() {
		
		AffineTransform transf = new AffineTransform();
		transf.setToTranslation(x,y+=3);
		transf.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle=angle+1), x/9, y/9));
		a.move();
		AffineTransform trasf2 = a.getTransform();
		assertEquals(transf,trasf2);
	}

	/**
	 * Test method for {@link game.Asteroid#Asteroid(int, int, java.lang.String)}.
	 */
	@Test
	public void testAsteroid() {
		
	}

	/**
	 * Test method for {@link game.Asteroid#drawAsteroid(java.awt.Graphics)}.
	 */
	@Test
	public void testDrawAsteroid() {
		Graphics g = null;
		Graphics2D g2d = (Graphics2D) g;
		JPanel panel = new JPanel();
		a.drawAsteroid(g2d);
	}

	/**
	 * Test method for {@link game.Asteroid#getTransform2()}.
	 */
	@Test
	public void testGetTransform2() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.Asteroid#setTransform2(java.awt.geom.AffineTransform)}.
	 */
	@Test
	public void testSetTransform2() {
		fail("Not yet implemented");
	}

}

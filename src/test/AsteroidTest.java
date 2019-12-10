/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.a = new Asteroid(x, y, "../resources/images/asteroid-icon.png");
		this.x = a.getX();
		this.y = a.getY();
		this.angle = a.getAngle();

	}

	/**
	 * Test method for {@link game.Asteroid#move()}.
	 */
	@Test
	public void testMove() {

		AffineTransform transf = new AffineTransform();
		
		transf.setToTranslation(x, y+5);
		transf.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle+5),a.getWidth() / 2, a.getHeight() / 2));
		a.move();
		assertEquals(transf, a.getTransform());
	}

	/**
	 * Test method for {@link game.Asteroid#Asteroid(int, int, java.lang.String)}.
	 */
	@Test
	public void testAsteroid() {
// I don' t think we need this
	}

	/**
	 * Test method for {@link game.Asteroid#getTransform2()}.
	 */
	@Test
	public void testGetTransform() {
		
		AffineTransform transf = new AffineTransform();
		transf.setToTranslation(x, y+5);
		transf.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle+5), a.getWidth() / 2, a.getHeight() / 2));
		
		a.move();
		assertEquals(transf,a.getTransform());
	}


	
	

}

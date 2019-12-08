/**
 * 
 */
package test;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;

import java.awt.geom.AffineTransform;

=======
import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

>>>>>>> I added the obstacles in the executionPanel
import org.junit.Before;
import org.junit.Test;

import game.Asteroid;
<<<<<<< HEAD

public class AsteroidTest {

=======
import game.MainFrame;
import game.patterns.state.Modalita;


public class AsteroidTest {
	
>>>>>>> I added the obstacles in the executionPanel
	private Asteroid a;
	private int x;
	private int y;
	private int angle;
<<<<<<< HEAD
=======
	private Modalita m;
	private MainFrame main ;
>>>>>>> I added the obstacles in the executionPanel

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
<<<<<<< HEAD
		this.a = new Asteroid(x, y, "../resources/images/asteroid-icon.png");
		this.x = a.getX();
		this.y = a.getY();
		this.angle = a.getAngle();

=======
		this.x = 0;
		this.y = 0;
		this.angle = 0;
		this.a = new Asteroid(x,y,"../resources/images/asteroid-icon.png");
		m = new Modalita();
		main = MainFrame.getIstance();
		main.setFrame(new JFrame());
>>>>>>> I added the obstacles in the executionPanel
	}

	/**
	 * Test method for {@link game.Asteroid#move()}.
	 */
	@Test
	public void testMove() {
<<<<<<< HEAD

		AffineTransform transf = new AffineTransform();
		
		transf.setToTranslation(x, y+5);
		transf.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle+5),a.getWidth() / 2, a.getHeight() / 2));
		a.move();
		assertEquals(transf, a.getTransform());
=======
		
		AffineTransform transf = new AffineTransform();
		transf.setToTranslation(x,y+=3);
		transf.concatenate(AffineTransform.getRotateInstance(Math.toRadians(angle=angle+1), x/9, y/9));
		a.move();
		AffineTransform trasf2 = a.getTransform();
		assertEquals(transf,trasf2);
>>>>>>> I added the obstacles in the executionPanel
	}

	/**
	 * Test method for {@link game.Asteroid#Asteroid(int, int, java.lang.String)}.
	 */
	@Test
	public void testAsteroid() {
<<<<<<< HEAD
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


	
	
=======
		
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
>>>>>>> I added the obstacles in the executionPanel

}

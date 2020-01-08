/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.awt.geom.AffineTransform;

import org.junit.Before;
import org.junit.Test;

import game.Asteroid;

public class AsteroidTest {

	private Asteroid asteroid;

	@Before
	public void setUp() throws Exception {
		
		this.asteroid = new Asteroid(0, 0, "../resources/images/asteroid-icon.png");

	}


	@Test
	public void testMove() {

		AffineTransform transf = new AffineTransform();
		
		transf.setToTranslation(this.asteroid.getX(),this.asteroid.getY()+5);
		transf.concatenate(AffineTransform.getRotateInstance(Math.toRadians(this.asteroid.getAngle()+5),this.asteroid.getWidth() / 2, this.asteroid.getHeight() / 2));
		
		this.asteroid.move();
		assertEquals(transf, this.asteroid.getTransform());
	}


	@Test
	public void testGetTransform() {
		
		AffineTransform transf = new AffineTransform();
		transf.setToTranslation(this.asteroid.getX(),this.asteroid.getY()+5);
		transf.concatenate(AffineTransform.getRotateInstance(Math.toRadians(this.asteroid.getAngle()+5), this.asteroid.getWidth() / 2, this.asteroid.getHeight() / 2));
		
		this.asteroid.move();
		assertEquals(transf,this.asteroid.getTransform());
	}
	
	@Test
	public void testSetTransform() {
		
		AffineTransform transf = new AffineTransform();
		transf.setToTranslation(this.asteroid.getX()+10, this.asteroid.getY()+50);
		transf.concatenate(AffineTransform.getRotateInstance(Math.toRadians(this.asteroid.getAngle()+5), this.asteroid.getWidth() / 2, this.asteroid.getHeight() / 2));
		
		this.asteroid.setTransform(transf);
		assertEquals(transf,this.asteroid.getTransform());
	}



}

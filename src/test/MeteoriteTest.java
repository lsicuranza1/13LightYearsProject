package test;

import static org.junit.Assert.*;

import java.awt.geom.AffineTransform;

import org.junit.Before;
import org.junit.Test;

import game.Meteorite;

public class MeteoriteTest {
	
	private Meteorite meteorite;

	@Before
	public void setUp() throws Exception {
		
		this.meteorite = new Meteorite(0,0, "../resources/images/meteorite.png");
	}

	@Test
	public void testMove() {
        
		AffineTransform transf = new AffineTransform();
		
		transf.setToTranslation(this.meteorite.getX(), this.meteorite.getY()+10);
		this.meteorite.move();
		assertEquals(transf, this.meteorite.getTransform());
		
	}

	@Test
	public void testMeteorite() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTransform() {
        AffineTransform transf = new AffineTransform();
	    transf.setToTranslation(this.meteorite.getX(), this.meteorite.getY()+10);
	    
	    this.meteorite.move();
	    assertEquals(transf,this.meteorite.getTransform());
	}
	
	@Test
	public void testSetTransform() {
        AffineTransform transf = new AffineTransform();
	    transf.setToTranslation(this.meteorite.getX(), this.meteorite.getY()+10);
	    
	    this.meteorite.setTransform(transf);
	    assertEquals(transf,this.meteorite.getTransform());
	}

}

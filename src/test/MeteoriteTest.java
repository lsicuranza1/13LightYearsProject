package test;

import static org.junit.Assert.*;

import java.awt.geom.AffineTransform;

import org.junit.Before;
import org.junit.Test;

import game.Meteorite;

public class MeteoriteTest {
	
	private Meteorite m;
	private int x;
	private int y;

	@Before
	public void setUp() throws Exception {
		
		m = new Meteorite(0,0, "../resources/images/meteorite.png");
		this.x = m.getX();
		this.y = m.getY();
	}

	@Test
	public void testMove() {
        
		AffineTransform transf = new AffineTransform();
		
		transf.setToTranslation(x, y+10);
		m.move();
		assertEquals(transf, m.getTransform());
	}

	@Test
	public void testMeteorite() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTransform() {
        AffineTransform transf = new AffineTransform();
	    transf.setToTranslation(x, y+10);
	    
	    m.move();
	    assertEquals(transf,m.getTransform());
	}

}

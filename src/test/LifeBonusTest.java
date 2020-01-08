package test;

import static org.junit.Assert.*;

import java.awt.geom.AffineTransform;

import org.junit.Before;
import org.junit.Test;

import game.LifeBonus;

public class LifeBonusTest {
	
	private LifeBonus bonus;


	@Before
	public void setUp() throws Exception {
		
		this.bonus = new LifeBonus(10,10,"life.png");
	}


	@Test
	public void testMove() {
        
		AffineTransform transf = new AffineTransform();
		
		transf.setToTranslation(bonus.getX(), bonus.getY()+5);
		bonus.move();
		assertEquals(transf, bonus.getTransform());
	}

	@Test
	public void testGetTransform() {
		AffineTransform transf = new AffineTransform();
		transf.setToTranslation(bonus.getX(), bonus.getY()+5);
		bonus.move();
		assertEquals(transf,bonus.getTransform());
	}
	
	@Test
	public void testSetTransform() {
		AffineTransform transf = new AffineTransform();
        transf.setToTranslation(50,50);
        
        bonus.setTransform(transf);
        assertEquals(transf,bonus.getTransform());
        
        
	}



}

package test;

import static org.junit.Assert.assertEquals;

import java.awt.geom.AffineTransform;

import org.junit.Before;
import org.junit.Test;

import game.ScoreBonus;

public class ScoreBonusTest {
	
	private ScoreBonus bonus;

	@Before
	public void setUp() throws Exception {
		
		this.bonus = new ScoreBonus(10,10,"../resources/images/x2-icon.png");
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

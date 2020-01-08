package test;

import static org.junit.Assert.assertEquals;

import java.awt.geom.AffineTransform;

import org.junit.Before;
import org.junit.Test;

import game.ScoreBonus;

public class ScoreBonusTest {
	
	private ScoreBonus bonus;
	private AffineTransform transf;

	@Before
	public void setUp() throws Exception {
		
		this.bonus = new ScoreBonus(10,10,"../resources/images/x2-icon.png");
		this.transf = new AffineTransform();
	}

	@Test
	public void testMove() {
		
        this.transf.setToTranslation(this.bonus.getX(), this.bonus.getY()+5);
		this.bonus.move();
		assertEquals(this.transf, this.bonus.getTransform());
		
	}

	@Test
	public void testGetTransform() {
		
		this.transf.setToTranslation(bonus.getX(), bonus.getY()+5);
		this.bonus.move();
		assertEquals(this.transf,this.bonus.getTransform());
	}
	
	@Test
	public void testSetTransform() {
		
        this.transf.setToTranslation(20,20); 
        this.bonus.setTransform(this.transf);
        assertEquals(this.transf,this.bonus.getTransform());
               
	}

}

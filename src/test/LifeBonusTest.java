package test;

import static org.junit.Assert.*;

import java.awt.geom.AffineTransform;

import org.junit.Before;
import org.junit.Test;

import game.LifeBonus;

public class LifeBonusTest {
	
	private LifeBonus bonus;
	private AffineTransform transform;


	@Before
	public void setUp() throws Exception {
		
		this.bonus = new LifeBonus(10,10,"../resources/images/life.png");
		this.transform = new AffineTransform();
	}


	@Test
	public void testMove() {
        
		this.transform.setToTranslation(this.bonus.getX(), this.bonus.getY()+5);
		this.bonus.move();
		assertEquals(this.transform, this.bonus.getTransform());
	}

	@Test
	public void testGetTransform() {
		
		this.transform.setToTranslation(this.bonus.getX(), this.bonus.getY()+5);
		this.bonus.move();
		assertEquals(this.transform,bonus.getTransform());
	}
	
	@Test
	public void testSetTransform() {
	
        this.transform.setToTranslation(50,50);
        
        this.bonus.setTransform(this.transform);
        assertEquals(this.transform,this.bonus.getTransform());
        
        
	}



}

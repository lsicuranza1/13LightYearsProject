package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Missile;

public class MissileTest {
	
	private Missile missile;
	private int missile_speed;
	private int board_heigth;

	@Before
	public void setUp() throws Exception {
		
		this.board_heigth = 800;
		this.missile_speed = 15;
		this.missile = new Missile(0,this.board_heigth,"../resources/images/missile.png");
		
	}

	@Test
	public void testMove() {
		
		int temp_y= this.missile.getY();
		missile.move();
		assertEquals(temp_y-this.missile_speed,this.missile.getY());
		assertEquals(true,this.missile.isVisible());
		
		missile.setY(0);
	    missile.move();
	    assertEquals(0-this.missile_speed,this.missile.getY());
	    assertEquals(false,this.missile.isVisible());
		
	}

}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Missile;

public class MissileTest {
	
	private Missile m;
	private int x;
	private int y;
	private int board_width;
	private int missile_speed;

	@Before
	public void setUp() throws Exception {
		
		this.x=0;
		this.y=0;
		this.board_width = 1000;
		this.missile_speed = 5;
		this.m = new Missile(x,y,"../resources/images/missile.png");
		
	}

	@Test
	public void testMove() {
		
		int temp_y= m.getY();
		m.move();
		assertEquals(temp_y-this.missile_speed,m.getY());
		assertEquals(true,m.isVisible());
		
		m.setY(this.board_width+1+this.missile_speed);
	    temp_y= m.getY();
	    m.move();
	    assertEquals(temp_y-this.missile_speed,m.getY());
	    assertEquals(false,m.isVisible());
		
	}

	@Test
	public void testMissile() {
		fail("Not yet implemented");
	}

//	@Test
//	public void testMove_colpo() {
//		
//		m.setY(this.board_width-2);
//		m.move_colpo();
//		assertEquals(true,m.isVisible());
//		
//		m.setY(this.board_width-1);
//		m.move_colpo();
//		assertEquals(false,m.isVisible());
//	}

}

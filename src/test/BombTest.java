package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import game.Bomb;

public class BombTest {
	
	private Bomb bomb;

	@Before
	public void setUp() throws Exception {
		
		this.bomb =  new Bomb(0, 0, "missile_enemy.png");
		
	}

	@Test
	public void testMove() {
		
		this.bomb.move();
		assertEquals(7, this.bomb.getY());
		
	}

}

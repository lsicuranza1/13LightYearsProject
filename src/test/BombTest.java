package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Bomb;

public class BombTest {
	private Bomb b =  new Bomb(0, 0, "../resources/images/missile_enemy.png");
	

	@Test
	public void testMove() {
		b.move();
		assertEquals(7, b.getY());
		
	}


}

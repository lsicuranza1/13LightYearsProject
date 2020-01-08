package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import game.Bomb;
import game.EnemySpaceShip;

public class EnemySpaceShipTest {
	private EnemySpaceShip enemy; 

	@Before
	public void setUp() throws Exception {
		this.enemy = new EnemySpaceShip(0,0, "../resources/images/spaceship.png");
	}

	@Test
	public void testMove() {
		
		//case 1
		
		this.enemy.setX(20);
		this.enemy.setNewX_1(10);
		this.enemy.setCount(2);
		int oldX = this.enemy.getX();
		this.enemy.move();
		assertEquals(oldX, this.enemy.getX());
		this.enemy.setCount(1);
		int oldX2 = this.enemy.getX();
		this.enemy.move();
		assertEquals(oldX2-5, this.enemy.getX());
		
		//case 2
		
		this.enemy.setX(10);
		this.enemy.setNewX_1(20);
		this.enemy.setCount(2);
		oldX = this.enemy.getX();
		this.enemy.move();
		assertEquals(oldX, this.enemy.getX());
		this.enemy.setCount(1);
		oldX2 = this.enemy.getX();
		this.enemy.move();
		assertEquals(oldX2+5, this.enemy.getX());
		
		//case 3
		
		this.enemy.setY(10);
		this.enemy.setNewY_1(20);
		this.enemy.setCount(2);
		int oldY = this.enemy.getY();
		this.enemy.move();
		assertEquals(oldY+5, this.enemy.getY());
		this.enemy.setY(10);
		this.enemy.setNewY_1(20);
		this.enemy.setCount(1);
		int oldY2 = this.enemy.getY();
		this.enemy.move();
		assertEquals(oldY2+5, this.enemy.getY());

		
		//case 4
		
		this.enemy.setY(20);
		this.enemy.setNewY_1(10);
		this.enemy.setCount(2);
		oldY = this.enemy.getY();
		this.enemy.move();
		assertEquals(oldY+5, this.enemy.getY());
		this.enemy.setY(20);
		this.enemy.setNewY_1(10);
		this.enemy.setCount(1);
		oldY2 = this.enemy.getY();
		this.enemy.move();
		assertEquals(oldY2-5, this.enemy.getY());
	}

	@Test
	public void testFire() {
		
		List<Bomb> bomb = this.enemy.getBombs();
		
		int length = bomb.size();
		
		this.enemy.fire();
		
		bomb = this.enemy.getBombs();
	    int length2 = bomb.size();
		assertEquals(length+1, length2);
		
		
	}

}

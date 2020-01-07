package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Score;

public class ScoreTest {
	
	private Score score;

	@Before
	public void setUp() throws Exception {
		
		this.score = new Score();
	}

	@Test
	public void testScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetScoreValue() {
		
		assertEquals(0,this.score.getScoreValue());
	}

	@Test
	public void testSetScoreValue() {
		this.score.setScoreValue(50);
		assertEquals(50,this.score.getScoreValue());
	}

	@Test
	public void testUpdateScoreValue() {
		this.score.setScoreValue(10);
		this.score.updateScoreValue(90);
		assertEquals(100,this.score.getScoreValue());
	}

}

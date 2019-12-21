package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Score;

public class ScoreTest {
	
	private Score s;

	@Before
	public void setUp() throws Exception {
		
		s = new Score();
	}

	@Test
	public void testScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetScoreValue() {
		s.setScoreValue(30);
		assertEquals(30,s.getScoreValue());
	}

	@Test
	public void testSetScoreValue() {
		s.setScoreValue(50);
		assertEquals(50,s.getScoreValue());
	}

	@Test
	public void testUpdateScoreValue() {
		s.setScoreValue(10);
		s.updateScoreValue(90);
		assertEquals(100,s.getScoreValue());
	}

}

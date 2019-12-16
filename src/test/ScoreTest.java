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
	
	@Test
	public void testdecrementScoreValue() {
		s.setScoreValue(10);
		s.decrementScoreValue(5);
		assertEquals(5,s.getScoreValue());
	}

}

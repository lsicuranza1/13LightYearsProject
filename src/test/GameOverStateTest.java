package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import game.ExecutionFrame;
import game.MainFrame;
import game.Score;
import game.patterns.state.*;

public class GameOverStateTest {
	
	private Modality modality;
	private MainFrame mainframe;
	private GameOverState gameover;

	@Before
	public void setUp() throws Exception {
		
		this.modality = new Modality();
		this.mainframe = MainFrame.getIstance();
		this.mainframe.setFrame(new ExecutionFrame());
		this.mainframe.setScore(new Score());
		this.gameover = new GameOverState();
	}

	@Test
	public void testStateManagement() {
		
		gameover.stateManagement(this.modality,"start");
		assertEquals("13 Light Years - Main Menu",mainframe.getFrame().getTitle());
		assertEquals(2,mainframe.getFrame().getContentPane().getComponentCount());
		assertTrue(this.modality.getModalityState() instanceof StartingState);
		
		gameover.stateManagement(this.modality,"running");
		assertEquals("Game",mainframe.getFrame().getTitle());
		assertEquals(1,mainframe.getFrame().getContentPane().getComponentCount());
		assertTrue(this.modality.getModalityState() instanceof ExecutionState);
	}

}

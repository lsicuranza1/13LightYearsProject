package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.swing.JFrame;
import org.junit.Before;
import org.junit.Test;
import game.MainFrame;
import game.Score;
import game.patterns.state.Modality;
import game.patterns.state.GameOverState;
import game.patterns.state.ExecutionState;
import game.patterns.state.StartingState;

public class ExecutionStateTest {
	
	private Modality modality;
	private MainFrame mainframe ;
	
	
	@Before
	public void setUp() throws Exception {
		modality = new Modality();
		mainframe = MainFrame.getIstance();
		mainframe.setFrame(new JFrame());
		mainframe.setScore(new Score());
	}

	@Test
	public void testStateManagement() {
		
		ExecutionState state = new ExecutionState();
		
		state.stateManagement(modality,"game_over");
		assertEquals("GameOver",mainframe.getFrame().getTitle());
		assertEquals(2,mainframe.getFrame().getContentPane().getComponentCount());
		assertTrue(modality.getModalityState() instanceof GameOverState);
		
		state.stateManagement(modality,"start");
		assertEquals("13 Light Years - Main Menu",mainframe.getFrame().getTitle());
		assertEquals(2,mainframe.getFrame().getContentPane().getComponentCount());
		assertTrue(modality.getModalityState() instanceof StartingState);
	}

}

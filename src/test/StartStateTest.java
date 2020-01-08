package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.swing.JFrame;
import org.junit.Before;
import org.junit.Test;
import game.MainFrame;
import game.Score;
import game.patterns.state.Modality;
import game.patterns.state.State;
import game.patterns.state.DemoState;
import game.patterns.state.ExecutionState;
import game.patterns.state.StartingState;

public class StartStateTest {

	private Modality modality;
	private MainFrame mainframe;

	@Before
	public void setUp() throws Exception {
		modality = new Modality();
		mainframe = MainFrame.getIstance();
		mainframe.setFrame(new JFrame());
		mainframe.setScore(new Score());
	}

	@Test
	public void testStateManagement() {
		
		State state = new StartingState();

		state.stateManagement(modality, "running");
		assertEquals("Game", mainframe.getFrame().getTitle());
		assertEquals(1, mainframe.getFrame().getContentPane().getComponentCount());
		assertTrue(modality.getModalityState() instanceof ExecutionState);
		
		state.stateManagement(modality, "demo");
		assertEquals("Demo", mainframe.getFrame().getTitle());
		assertEquals(1, mainframe.getFrame().getContentPane().getComponentCount());
		assertTrue(modality.getModalityState() instanceof DemoState);
	}

}

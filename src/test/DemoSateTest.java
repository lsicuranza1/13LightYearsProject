package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.swing.JFrame;
import org.junit.Before;
import org.junit.Test;
import game.MainFrame;
import game.Score;
import game.patterns.state.Modality;
import game.patterns.state.DemoState;
import game.patterns.state.ExecutionState;

public class DemoSateTest {
	
	private Modality modality;
	private MainFrame mainframe ;

	@Before
	public void setUp() throws Exception {
		
		this.modality = new Modality();
		this.mainframe = MainFrame.getIstance();
		this.mainframe.setFrame(new JFrame());
		this.mainframe.setScore(new Score());
	}

	@Test
	public void testStateManagement() {
		DemoState state = new DemoState();
		
		state.stateManagement(this.modality,"running");
		assertEquals("Game",this.mainframe.getFrame().getTitle());
		assertEquals(1,this.mainframe.getFrame().getContentPane().getComponentCount());
		assertTrue(this.modality.getModalityState() instanceof ExecutionState);
	}

}

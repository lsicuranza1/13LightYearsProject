package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import game.patterns.state.Modality;
import game.patterns.state.ExecutionState;
import game.patterns.state.StartingState;

public class ModalityTest {
	
	private Modality modality;
	
	@Before
	public void setUp() throws Exception {
		this.modality = new Modality();
		
	}

	@Test
	public void testGetStatoModalita() {
		assertTrue(this.modality.getModalityState() instanceof StartingState);
	}

	@Test
	public void testSetStatoModalita() {
		ExecutionState state = new ExecutionState();
		this.modality.setModalityState(state);
		assertEquals(state,this.modality.getModalityState());
	}

}

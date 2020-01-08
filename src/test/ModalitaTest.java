package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import game.patterns.state.Modalita;
import game.patterns.state.StatoInEsecuzione;
import game.patterns.state.StatoStart;

public class ModalitaTest {
	
	private Modalita modalit�;
	
	@Before
	public void setUp() throws Exception {
		this.modalit� = new Modalita();
		
		
	}

	@Test
	public void testGetStatoModalita() {
		assertTrue(this.modalit�.getStatoModalita() instanceof StatoStart);
	}

	@Test
	public void testSetStatoModalita() {
		StatoInEsecuzione state = new StatoInEsecuzione();
		this.modalit�.setStatoModalita(state);
		assertEquals(state,this.modalit�.getStatoModalita());
	}

}

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import game.patterns.state.Modalita;
import game.patterns.state.StatoInEsecuzione;
import game.patterns.state.StatoStart;

public class ModalitaTest {
	
	private Modalita modalità;
	
	@Before
	public void setUp() throws Exception {
		this.modalità = new Modalita();
		
		
	}

	@Test
	public void testGetStatoModalita() {
		assertTrue(this.modalità.getStatoModalita() instanceof StatoStart);
	}

	@Test
	public void testSetStatoModalita() {
		StatoInEsecuzione state = new StatoInEsecuzione();
		this.modalità.setStatoModalita(state);
		assertEquals(state,this.modalità.getStatoModalita());
	}

}

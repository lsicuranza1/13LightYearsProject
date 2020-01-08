package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import game.patterns.state.Modalita;
import game.patterns.state.StatoInEsecuzione;
import game.patterns.state.StatoStart;

public class ModalitaTest {
	
	private Modalita modalita;
	
	@Before
	public void setUp() throws Exception {
		this.modalita = new Modalita();
		
		
	}

	@Test
	public void testGetStatoModalita() {
		assertTrue(this.modalita.getStatoModalita() instanceof StatoStart);
	}

	@Test
	public void testSetStatoModalita() {
		StatoInEsecuzione state = new StatoInEsecuzione();
		this.modalita.setStatoModalita(state);
		assertEquals(state,this.modalita.getStatoModalita());
	}

}

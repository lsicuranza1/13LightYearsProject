package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import game.MainFrame;
import game.patterns.state.Modalita;
import game.patterns.state.StatoPausa;
import game.patterns.state.StatoStart;

public class ModalitaTest {
	
	private Modalita modalità;
	
	@Before
	public void setUp() throws Exception {
		this.modalità = new Modalita();
		MainFrame.getIstance();
		
	}

	@Test
	public void testGetStatoModalita() {
		assertTrue(this.modalità.getStatoModalita() instanceof StatoStart);
	}

	@Test
	public void testSetStatoModalita() {
		StatoPausa s = new StatoPausa();
		this.modalità.setStatoModalita(s);
		assertEquals(s,this.modalità.getStatoModalita());
	}

}

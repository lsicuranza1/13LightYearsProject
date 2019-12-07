package test;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import game.MainFrame;
import game.patterns.state.*;

public class ModalitaTest {
	
	private Modalita m;
	@Before
	public void setUp() throws Exception {
		m = new Modalita();
		MainFrame.getIstance();
		
	}

	@Test
	public void testGetStatoModalita() {
		assertTrue(m.getStatoModalita() instanceof StatoStart);
	}

	@Test
	public void testSetStatoModalita() {
		StatoStart s = new StatoStart();
		m.setStatoModalita(s);
		assertEquals(s,m.getStatoModalita());
	}

}

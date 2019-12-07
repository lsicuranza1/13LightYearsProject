package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import game.MainFrame;
import game.patterns.state.Modalita;
import game.patterns.state.StatoInEsecuzione;
import game.patterns.state.StatoPausa;
import game.patterns.state.StatoStart;

public class StatoPausaTest {

	private Modalita m;
	private MainFrame main;

	@Before
	public void setUp() throws Exception {

		m = new Modalita();
		main = MainFrame.getIstance();
		main.setFrame(new JFrame());
	}

	@Test
	public void testGestioneStato() {
		StatoPausa stato = new StatoPausa();

		stato.gestioneStato(m, "start");
		assertEquals("Start", main.getFrame().getTitle());
		assertEquals(1, main.getFrame().getContentPane().getComponentCount());
		assertTrue(m.getStatoModalita() instanceof StatoStart);

		stato.gestioneStato(m, "in_esecuzione");
		assertEquals("Gioco", main.getFrame().getTitle());
		assertEquals(1, main.getFrame().getContentPane().getComponentCount());
		assertTrue(m.getStatoModalita() instanceof StatoInEsecuzione);

	}

}

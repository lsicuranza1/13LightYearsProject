package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import game.MainFrame;
import game.Score;
import game.patterns.state.Modalita;
import game.patterns.state.StatoDemo;
import game.patterns.state.StatoInEsecuzione;

public class StatoDemoTest {
	
	private Modalita m;
	private MainFrame main ;

	@Before
	public void setUp() throws Exception {
		
		m = new Modalita();
		main = MainFrame.getIstance();
		main.setFrame(new JFrame());
		main.setScore(new Score());
	}

	@Test
	public void testGestioneStato() {
		StatoDemo stato = new StatoDemo();
		
		stato.gestioneStato(m,"play");
		assertEquals("Game",main.getFrame().getTitle());
		assertEquals(1,main.getFrame().getContentPane().getComponentCount());
		assertTrue(m.getStatoModalita() instanceof StatoInEsecuzione);
	}

}

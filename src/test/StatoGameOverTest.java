package test;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import game.MainFrame;
import game.Score;
import game.patterns.state.*;

public class StatoGameOverTest {
	
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
		StatoGameOver stato = new StatoGameOver();
		
		stato.gestioneStato(m,"start");
		assertEquals("Start",main.getFrame().getTitle());
		assertEquals(1,main.getFrame().getContentPane().getComponentCount());
		assertTrue(m.getStatoModalita() instanceof StatoStart);
		
		stato.gestioneStato(m,"in_esecuzione");
		assertEquals("Gioco",main.getFrame().getTitle());
		assertEquals(1,main.getFrame().getContentPane().getComponentCount());
		assertTrue(m.getStatoModalita() instanceof StatoInEsecuzione);
	}

}

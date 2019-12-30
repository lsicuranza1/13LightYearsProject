package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import game.MainFrame;
import game.Score;
import game.patterns.state.Modalita;
import game.patterns.state.StatoGameOver;
import game.patterns.state.StatoInEsecuzione;
import game.patterns.state.StatoPausa;
import game.patterns.state.StatoStart;

public class StatoInEsecuzioneTest {
	
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
		StatoInEsecuzione stato = new StatoInEsecuzione();
		
		stato.gestioneStato(m,"pausa");
		assertEquals("Pausa",main.getFrame().getTitle());
		assertEquals(0,main.getFrame().getContentPane().getComponentCount());
		assertTrue(m.getStatoModalita() instanceof StatoPausa);
		
		stato.gestioneStato(m,"game_over");
		assertEquals("GameOver",main.getFrame().getTitle());
		assertEquals(1,main.getFrame().getContentPane().getComponentCount());
		assertTrue(m.getStatoModalita() instanceof StatoGameOver);
		
		stato.gestioneStato(m,"start");
		assertEquals("Start",main.getFrame().getTitle());
		assertEquals(1,main.getFrame().getContentPane().getComponentCount());
		assertTrue(m.getStatoModalita() instanceof StatoStart);
	}

}

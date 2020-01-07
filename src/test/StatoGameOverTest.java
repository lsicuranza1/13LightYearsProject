package test;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import game.ExecutionFrame;
import game.MainFrame;
import game.Score;
import game.patterns.state.*;

public class StatoGameOverTest {
	
	private Modalita modalita;
	private MainFrame main;
	private StatoGameOver gameover;

	@Before
	public void setUp() throws Exception {
		
		this.modalita = new Modalita();
		this.main = MainFrame.getIstance();
		
		this.main.setFrame(new ExecutionFrame());
		this.main.setScore(new Score());
		this.gameover = new StatoGameOver();
	}

	@Test
	public void testGestioneStato() {
		StatoGameOver stato = new StatoGameOver();
		
		stato.gestioneStato(this.modalita,"start");
		assertEquals("13 Light Years - Menu' Principale",main.getFrame().getTitle());
		assertEquals(2,main.getFrame().getContentPane().getComponentCount());
		assertTrue(this.modalita.getStatoModalita() instanceof StatoStart);
		
		stato.gestioneStato(this.modalita,"in_esecuzione");
		assertEquals("Game",main.getFrame().getTitle());
		assertEquals(1,main.getFrame().getContentPane().getComponentCount());
		assertTrue(this.modalita.getStatoModalita() instanceof StatoInEsecuzione);
	}

}

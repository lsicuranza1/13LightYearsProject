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
	
	private Modalita modalita;
	private MainFrame mainframe ;

	@Before
	public void setUp() throws Exception {
		
		this.modalita = new Modalita();
		this.mainframe = MainFrame.getIstance();
		this.mainframe.setFrame(new JFrame());
		this.mainframe.setScore(new Score());
	}

	@Test
	public void testGestioneStato() {
		StatoDemo stato = new StatoDemo();
		
		stato.gestioneStato(this.modalita,"in_esecuzione");
		assertEquals("Game",this.mainframe.getFrame().getTitle());
		assertEquals(1,this.mainframe.getFrame().getContentPane().getComponentCount());
		assertTrue(this.modalita.getStatoModalita() instanceof StatoInEsecuzione);
	}

}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gestioneClassifica.ComparatorGiocatore;
import gestioneClassifica.Giocatore;

public class ComparatorGiocatoreTest {
	
	private ComparatorGiocatore comparator;
	@Before
	public void setUp() throws Exception{
		this.comparator = new ComparatorGiocatore();
	}
	
	
	@Test
	public void compareTest() {
		
		//Test equal
		Giocatore p1 = new Giocatore("Player1");
		Giocatore p2 = new Giocatore("Player1");
		assertEquals(this.comparator.compare(p1, p2),0);
		
		//Test greater
		p1.setPunteggio(10);
		assertEquals(this.comparator.compare(p1, p2),-1);
		
		//Test less
		p2.setPunteggio(20);
		assertEquals(this.comparator.compare(p1, p2),1);
		
	}

}

package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import gestioneClassifica.Classifica;
import gestioneClassifica.Giocatore;
import gestioneClassifica.GiocatoreNonClassificatoException;

public class ClassificaTest {

	private Classifica c;
	
	@Before
	public void setUp() throws Exception{
		this.c = new Classifica();
	}
	
	@Test
	public void testGetClassifica() {
		assertEquals(c.getClassifica(),new ArrayList<>());
	}
	
	@Test
	public void testIterator() {
		assertEquals(false,c.iterator().hasNext());
	}

	@Test
	public void testAggiungiGiocatore() throws GiocatoreNonClassificatoException {
		//Giocatore non presente
		Giocatore p1 = new Giocatore("Player1");
		Giocatore p2 = new Giocatore("Player1");	
		c.aggiungiGiocatore(p1);
		
		//Classifica piena	
		for(int i=0;i<11;i++) {
			Giocatore p = new Giocatore("Player"+i);
			p.setPunteggio(10*i);
			c.aggiungiGiocatore(p);
		}
		
		Giocatore p20 = new Giocatore("Player non classificato");
		p20.setPunteggio(0);
		
		try{
			c.aggiungiGiocatore(p20);
		}catch(GiocatoreNonClassificatoException ex) {
			 assertEquals(p20, ex.getG());
		}
	
	}
	
	@Test
	public void testSerialization() throws IOException, ClassNotFoundException {
		//File corretto
		c.salvaSuFileBinario("classifica.dat");
		
		//File errato
		c.salvaSuFileBinario("nome_errato.txt");
	}
	
	@Test
	public void testSerializati() throws IOException, ClassNotFoundException,FileNotFoundException {
		
		c.leggiDaFileBinario("classifica.dat");
		
		c.leggiDaFileBinario("nome_errato_1.txt");
		
	}
	
	
	 @Test
	 public void testResetClassifica() {
		 c.resetClassifica();
		 assertEquals(0,c.getClassifica().size());
	 }
}


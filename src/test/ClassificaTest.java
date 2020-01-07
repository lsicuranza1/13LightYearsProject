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

	private Classifica classifica;
	
	@Before
	public void setUp() throws Exception{
		this.classifica = new Classifica();
	}
	
	@Test
	public void testGetClassifica() throws GiocatoreNonClassificatoException {
		//If the scoreboard is empty
		assertEquals(classifica.getClassifica(),new ArrayList<>());
		
		//If the scoreboard is not empty

		Giocatore p1 = new Giocatore("Player1");
		ArrayList<Giocatore> list = new ArrayList<Giocatore>();
		list.add(p1);
		
		this.classifica.aggiungiGiocatore(p1);
		assertEquals(list,this.classifica.getClassifica());
		
	}
	
	@Test
	public void testIterator() throws GiocatoreNonClassificatoException{
		
		//If the scoreboard is empty
		
		this.classifica.resetClassifica();
		assertEquals(false,classifica.iterator().hasNext());
		
		//If the scoreboard is not empty

		Giocatore p1 = new Giocatore("Player1");
		this.classifica.aggiungiGiocatore(p1);
			
		assertEquals(true,this.classifica.iterator().hasNext());
	}

	@Test
	public void testAggiungiGiocatore() throws GiocatoreNonClassificatoException {
		//New player
		Giocatore p1 = new Giocatore("Player1");
		classifica.aggiungiGiocatore(p1);
		
		//Scoreboard full	
		for(int i=0;i<11;i++) {
			Giocatore p = new Giocatore("Player"+i);
			p.setPunteggio(10*i);
			classifica.aggiungiGiocatore(p);
		}
		
		Giocatore p20 = new Giocatore("Player non classificato");
		p20.setPunteggio(0);
		
		try{
			classifica.aggiungiGiocatore(p20);
		}catch(GiocatoreNonClassificatoException ex) {
			 assertEquals(p20, ex.getG());
		}
	
	}
	
	@Test
	public void testSalvaSuFileBinario() throws IOException, ClassNotFoundException, GiocatoreNonClassificatoException {
		this.classifica.resetClassifica();
		
		Classifica classifica_tmp = new Classifica();
		Giocatore p1 = new Giocatore("Player1");
		classifica_tmp.aggiungiGiocatore(p1);
		this.classifica.aggiungiGiocatore(p1);

		this.classifica.salvaSuFileBinario("classifica.dat");
		this.classifica.leggiDaFileBinario("classifica.dat");
		
		assertEquals(this.classifica.getClassifica(),classifica_tmp.getClassifica());
		
		//File corretto
		classifica.salvaSuFileBinario("classifica.dat");
		
		//File errato
		classifica.salvaSuFileBinario("nome_errato.txt");
	}
	
	@Test
	public void testSerializati() throws IOException, ClassNotFoundException,FileNotFoundException {
		
		classifica.leggiDaFileBinario("classifica.dat");
		
		classifica.leggiDaFileBinario("nome_errato_1.txt");
		
	}
	
	
	 @Test
	 public void testResetClassifica() {
		 
		 classifica.resetClassifica();
		 assertEquals(0,classifica.getClassifica().size());
	 }
}


package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import gestioneClassifica.Giocatore;

public class GiocatoreTest {
	
	private Giocatore g;
	
	@Before
	public void setUp() throws Exception{	
		this.g = new Giocatore("Player");
	}
	
	@Test
	public void testGetTagGiocatore() {
		assertEquals("Player",g.getTagGiocatore());
	}

	@Test
	public void testGetPunteggio() {
		assertEquals(0,g.getPunteggio());
	}
	
	@Test
	public void testSetTagGiocatore() {
		g.setTagGiocatore("Player_1");
		assertEquals("Player_1",g.getTagGiocatore());
	}
	
	@Test
	public void testSetPunteggio() {
		g.setPunteggio(20);
		assertEquals(20,g.getPunteggio());
	}
	
	@Test
	public void testGetData() {
		assertEquals(LocalDate.now(),g.getData());
	}
	
	@Test
	public void testSetData() {
		g.setData(LocalDate.of(2020, 1, 1));
		assertTrue(g.getData().isEqual(LocalDate.of(2020, 1, 1)));
	}
	
	@Test
	public void testGetVisibleData() {
		g.setData(LocalDate.of(2020, 1, 1));
		assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getData()),g.getVisibleData());
		
		g.setData(LocalDate.of(2020,1,30));
		assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getData()),g.getVisibleData());
		
		g.setData(LocalDate.of(2020, 12, 1));
		assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getData()),g.getVisibleData());
		
		g.setData(LocalDate.of(2020,12,30));
		assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getData()),g.getVisibleData());
	
		
	
	}

	@Test
	public void testEquals() {
		
		//Same tag players
		Giocatore tmp_player = new Giocatore("Player");
		assertEquals(true,g.equals(tmp_player));
		
		//Different tag players
		Giocatore tmp_player_1 = new Giocatore("Giocatore");
		assertEquals(false,g.equals(tmp_player_1));
		
		//Same score
		tmp_player.setPunteggio(0);
		assertEquals(true,g.equals(tmp_player));
		
		//Different score
		tmp_player.setPunteggio(20);
		assertEquals(false,g.equals(tmp_player));
		
		//Different classes
		String str = new String("Test");
		assertEquals(false,g.equals(str));
		
		//Object null
		Object obj =null;
		assertEquals(false,g.equals(obj));
		
		//Null player tag
		Giocatore player1 = new Giocatore(null);
		Giocatore player2 = new Giocatore("Player");
		assertEquals(false,player1.equals(player2));
		 		
	} 
	
	
	
	
	
	
	
	
	
	
}

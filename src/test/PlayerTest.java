package test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;
import rankingManagement.Player;

public class PlayerTest {
	
	private Player g;
	
	@Before
	public void setUp() throws Exception{	
		this.g = new Player("Player");
	}
	
	@Test
	public void testGetTagPlayer() {
		assertEquals("Player",g.getPlayerTag());
	}

	@Test
	public void testGetScore() {
		assertEquals(0,g.getScore());
	}
	
	@Test
	public void testSetTagPlayer() {
		g.setPlayerTag("Player_1");
		assertEquals("Player_1",g.getPlayerTag());
	}
	
	@Test
	public void testSetPunteggio() {
		g.setScore(20);
		assertEquals(20,g.getScore());
	}
	
	@Test
	public void testGetData() {
		assertEquals(LocalDate.now(),g.getDate());
	}
	
	@Test
	public void testSetData() {
		g.setDate(LocalDate.of(2020, 1, 1));
		assertTrue(g.getDate().isEqual(LocalDate.of(2020, 1, 1)));
	}
	
	@Test
	public void testGetVisibleData() {
		g.setDate(LocalDate.of(2020, 1, 1));
		assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getDate()),g.getVisibleData());
		
		g.setDate(LocalDate.of(2020,1,30));
		assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getDate()),g.getVisibleData());
		
		g.setDate(LocalDate.of(2020, 12, 1));
		assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getDate()),g.getVisibleData());
		
		g.setDate(LocalDate.of(2020,12,30));
		assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getDate()),g.getVisibleData());
	
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEquals() {
		
		//Same tag players
		Player tmp_player = new Player("Player");
		assertEquals(true,g.equals(tmp_player));
		
		//Different tag players
		Player tmp_player_1 = new Player("PlayerDifferent");
		assertEquals(false,g.equals(tmp_player_1));
		
		//Same score
		tmp_player.setScore(0);
		assertEquals(true,g.equals(tmp_player));
		
		//Different score
		tmp_player.setScore(20);
		assertEquals(false,g.equals(tmp_player));
		
		//Different classes
		String str = new String("Test");
		assertEquals(false,g.equals(str));
		
		//Object null
		Object obj =null;
		assertEquals(false,g.equals(obj));
		
		//Null player tag
		Player player1 = new Player(null);
		Player player2 = new Player("Player");
		assertEquals(false,player1.equals(player2));
		 		
	} 
	
	
	
	
	
	
	
	
	
	
}

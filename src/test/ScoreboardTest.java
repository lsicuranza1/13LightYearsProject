package test;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import rankingManagement.Player;
import rankingManagement.Scoreboard;
import rankingManagement.UnclassifiedPlayerException;

public class ScoreboardTest {

	private Scoreboard scoreboard;
	
	@Before
	public void setUp() throws Exception{
		this.scoreboard = new Scoreboard();
	}
	
	@Test
	public void testGetScoreboard() {
		assertEquals(scoreboard.getScoreboardList(),new ArrayList<>());
	}
	
	@Test
	public void testIterator() {
		assertEquals(false,scoreboard.iterator().hasNext());
	}

	@Test(expected = Exception.class)
	public void testAggiungiGiocatore() throws UnclassifiedPlayerException, IOException {
		
		//Player not present
		Player player1 = new Player("Player1");
		scoreboard.addPlayer(player1);
		
		//Full scoreboard	
		for(int i=0;i<11;i++) {
			Player player = new Player("Player"+i);
			player.setScore(10*i);
			scoreboard.addPlayer(player);
		}
		
		Player playerUnclassified = new Player("Player unclassified");
		playerUnclassified.setScore(0);
		
		scoreboard.addPlayer(playerUnclassified);
	
	}
	
	@Test
	public void testReadToBynaryFile() throws IOException, ClassNotFoundException,FileNotFoundException {
		
		//Corrected File
		scoreboard.load();

	}
	
	@Test
	public void testSaveOnBynaryFile() throws IOException {
		
		//Corrected File
		scoreboard.save();

	}
	
	 @Test
	 public void testResetScoreboard() throws IOException {
		 scoreboard.resetScoreboard();
		 assertEquals(0,scoreboard.getScoreboardList().size());
	 }
}


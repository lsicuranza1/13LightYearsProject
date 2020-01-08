package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import rankingManagement.Player;
import rankingManagement.PlayerComparator;

public class PlayerComparatorTest {
	
	private PlayerComparator comparator;
	
	@Before
	public void setUp() throws Exception{
		this.comparator = new PlayerComparator();
	}

	@Test
	public void compareTest() {
		
		//Test equal
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player1");
		assertEquals(this.comparator.compare(player1, player2),0);
		
		//Test greater
		player1.setScore(10);
		assertEquals(this.comparator.compare(player1, player2),-1);
		
		//Test less
		player2.setScore(20);
		assertEquals(this.comparator.compare(player1, player2),1);
		
	}

}

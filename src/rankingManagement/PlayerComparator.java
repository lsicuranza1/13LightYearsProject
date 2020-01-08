package rankingManagement;

import java.io.Serializable;
import java.util.Comparator;

@SuppressWarnings("serial")
public class PlayerComparator implements Comparator<Player>,Serializable{

    /**
     * It make a comparision between two players
     */
    @Override
    public int compare(Player g1, Player g2) {
        if(g1.equals(g2))
            return 0;
        if(g1.getScore()<g2.getScore())
            return 1;
        return -1;
    }   
}

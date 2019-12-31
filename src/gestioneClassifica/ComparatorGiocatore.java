
package gestioneClassifica;

import java.io.Serializable;
import java.util.Comparator;

@SuppressWarnings("serial")
public class ComparatorGiocatore implements Comparator<Giocatore>,Serializable{

    @Override
    public int compare(Giocatore g1, Giocatore g2) {
        if(g1.equals(g2))
            return 0;
        if(g1.getPunteggio()<g2.getPunteggio())
            return 1;
        return -1;
    } 
    
}

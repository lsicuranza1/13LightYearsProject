
package gestioneClassifica;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author gruppo35
 */

public class ComparatorGiocatore implements Comparator<Giocatore>,Serializable{

    @Override
    public int compare(Giocatore o1, Giocatore o2) {
        if(o1.equals(o2))
            return 0;
        if(o1.getPunteggio()<o2.getPunteggio())
            return 1;
        return -1;
    }
    
}

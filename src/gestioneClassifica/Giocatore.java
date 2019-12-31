package gestioneClassifica;

import java.io.Serializable;
import java.time.LocalDate;

public class Giocatore implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String tagGiocatore;
    private int punteggio; 
    private final LocalDate data;

    public Giocatore(String tagGiocatore) {
        this.tagGiocatore = tagGiocatore;
        this.punteggio = 0;
        this.data= LocalDate.now();
    }
    
    public String getTagGiocatore() {
        return tagGiocatore;
    }

    public int getPunteggio() {
        return punteggio;
    }
    
//    public String getVisibleData(){
//        return data.getDayOfMonth()+"-"+data.getMonthValue()+"-"+data.getYear();
//    }

    public LocalDate getData() {
        return this.data ;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 89 * hash + Objects.hashCode(this.tagGiocatore);
//        hash = 89 * hash + this.punteggio;
//        hash = 89 * hash + Objects.hashCode(this.data);
//        return hash;
//    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Giocatore other = (Giocatore) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (punteggio != other.punteggio)
			return false;
		if (tagGiocatore == null) {
			if (other.tagGiocatore != null)
				return false;
		} else if (!tagGiocatore.equals(other.tagGiocatore))
			return false;
		return true;
	}

//    public boolean equals(Giocatore g) {
//        if(!this.getTagGiocatore().equals(g.getTagGiocatore()))
//            return false;
//        if(this.getPunteggio()!=g.getPunteggio())
//            return false;
//        return this.getVisibleData().equals(g.getVisibleData());
//    }
    
    
    


//    @Override
//    public synchronized String toString() {
//        return  tagGiocatore+punteggio+this.getData();
//    }

    
}

package gestioneClassifica;

import java.io.Serializable;
import java.time.LocalDate;

public class Giocatore implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tagGiocatore;
    private int punteggio; 
    private LocalDate data; 

    public Giocatore(String tagGiocatore) {
        this.tagGiocatore = tagGiocatore;
        this.punteggio = 0;
        this.data= LocalDate.now();
    }
    
    public String getTagGiocatore() {
        return tagGiocatore;
    }
    
    public void setTagGiocatore(String tag) {
    	this.tagGiocatore = tag;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public LocalDate getData() {
        return this.data ;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
	
    
    public void setData(LocalDate data) {
		this.data = data;
	}

	public String getVisibleData(){
    	if(data.getMonthValue()<10 && data.getDayOfMonth()<10) {
    		return "0"+data.getDayOfMonth()+"-0"+data.getMonthValue()+"-"+data.getYear();
    	}if(data.getMonthValue()<10 && data.getDayOfMonth()>10) {
    		return data.getDayOfMonth()+"-0"+data.getMonthValue()+"-"+data.getYear();
    	}if(data.getMonthValue()>10 && data.getDayOfMonth()<10) {
    		return "0"+data.getDayOfMonth()+"-"+data.getMonthValue()+"-"+data.getYear();
    	}else
    		return data.getDayOfMonth()+"-"+data.getMonthValue()+"-"+data.getYear();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Giocatore other = (Giocatore) obj;
		if (punteggio != other.punteggio)
			return false;
		if (tagGiocatore == null) {
			if (other.tagGiocatore != null)
				return false;
		} else if (!tagGiocatore.equals(other.tagGiocatore))
			return false;
		return true;
	}

}

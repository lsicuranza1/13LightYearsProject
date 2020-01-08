package rankingManagement;

import java.io.Serializable;
import java.time.LocalDate;

public class Player implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private String playerTag;
    private int score; 
    private LocalDate date; 

    public Player(String playerTag) {
        this.playerTag = playerTag;
        this.score = 0;
        this.date= LocalDate.now();
    }
    
    public String getPlayerTag() {
        return playerTag;
    }
    
    public void setPlayerTag(String tag) {
    	this.playerTag = tag;
    }

    public int getScore() {
        return score;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setScore(int score) {
        this.score = score;
    }
	
    public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getVisibleData(){
		
    	if(date.getMonthValue()<10 && date.getDayOfMonth()<10) {
    		return "0"+date.getDayOfMonth()+"-0"+date.getMonthValue()+"-"+date.getYear();
    	}if(date.getMonthValue()<10 && date.getDayOfMonth()>10) {
    		return date.getDayOfMonth()+"-0"+date.getMonthValue()+"-"+date.getYear();
    	}if(date.getMonthValue()>10 && date.getDayOfMonth()<10) {
    		return "0"+date.getDayOfMonth()+"-"+date.getMonthValue()+"-"+date.getYear();
    	}else
    		return date.getDayOfMonth()+"-"+date.getMonthValue()+"-"+date.getYear();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (score != other.score)
			return false;
		if (playerTag == null) {
			if (other.playerTag != null)
				return false;
		} else if (!playerTag.equals(other.playerTag))
			return false;
		return true;
	}

}

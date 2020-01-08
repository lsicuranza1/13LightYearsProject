package rankingManagement;

import java.io.Serializable;
import java.time.LocalDate;

public class Player implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private String playerTag;
    private int score; 
    private LocalDate date; 

    /**
     * It is the construcor of the Player class
     * @param playerTag A string of the player's tag
     */
    public Player(String playerTag) {
        this.playerTag = playerTag;
        this.score = 0;
        this.date= LocalDate.now();
    }
    
    /**
     * It returns the tag of the player
     * @return A string of the player's tag
     */
    public String getPlayerTag() {
        return playerTag;
    }
    
    /**
     * It sets the player's tag
     * @param tag A string of the player's tag
     */
    public void setPlayerTag(String tag) {
    	this.playerTag = tag;
    }

    /**
     * It returns the score of the player
     * @return A score
     */
    public int getScore() {
        return score;
    }

    /**
     * It returns the date of when a player was adds in the scoreboard
     * @return A Localdate
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * It sets a score for the player
     * @param score A score
     */
    public void setScore(int score) {
        this.score = score;
    }
	
    /**
     * It sets the date of when a player was adds in the scoreboard
     * @param date A LocalDate
     */
    public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * It formats in the correct way the date
	 * @return A string of the date
	 */
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

	/**
	 *
	 */
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

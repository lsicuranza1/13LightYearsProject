package game;

public class Score {
	
	private int scoreValue;

	/**
	 * The costructors of the Score class.
	 */
	public Score() {
		this.scoreValue = 0;
	}
	/**
	 * It return the Score.
	 * @return The score
	 */
	public int getScoreValue() {
		return scoreValue;
	}

	/**
	 * It sets the score value.
	 * @param scoreValue The score
	 */
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
	
	/** It updates the score. 
	 * @param increment An increment
	 */
	public void updateScoreValue(int increment) {
		this.scoreValue += increment;
	}
	
}
package game;

public class Score {
	
	private int scoreValue;

	/**
	 * 
	 */
	public Score() {
		this.scoreValue = 0;
	}
	/**
	 * @return
	 */
	public int getScoreValue() {
		return scoreValue;
	}

	/**
	 * @param scoreValue
	 */
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
	
	/**
	 * @param increment
	 */
	public void updateScoreValue(int increment) {
		this.scoreValue += increment;
	}
	
}
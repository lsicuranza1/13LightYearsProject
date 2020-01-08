package game;

public class Score {
	
	private int scoreValue;

	public Score() {
		this.scoreValue = 0;
	}
	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
	
	public void updateScoreValue(int increment) {
		this.scoreValue += increment;
	}
	
}
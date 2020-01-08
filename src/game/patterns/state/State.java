package game.patterns.state;

public interface State {

	/**
	 * It manages the actual state of the game. 
	 * @param modality A modality
	 * @param state A string that identifies the modality
	 */
	public void stateManagement(Modality modality, String state);

}
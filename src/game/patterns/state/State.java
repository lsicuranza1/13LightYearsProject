package game.patterns.state;

public interface State {

	/**
	 * @param modality
	 * @param state
	 */
	public void stateManagement(Modality modality, String state);

}
package game.patterns.state;
 
public class Modality {
 
    private State modalityState;
 
    /**
     * The constructor of Modality class
     */
    public Modality(){
        this.modalityState = new StartingState();
    }

	/**
	 *  It returns the Modality
	 * @return A modality
	 */
	public State getModalityState() {
		return modalityState;
	}

	/**
	 * It sets a new Modality
	 * @param modalityState A Modality
	 */
	public void setModalityState(State modalityState) {
		this.modalityState = modalityState;
	}
 
}
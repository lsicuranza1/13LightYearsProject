package game.patterns.state;
 
public class Modality {
 
    private State modalityState;
 
    /**
     * 
     */
    public Modality(){
        this.modalityState = new StartingState();
    }

	/**
	 * @return
	 */
	public State getModalityState() {
		return modalityState;
	}

	/**
	 * @param modalityState
	 */
	public void setModalityState(State modalityState) {
		this.modalityState = modalityState;
	}
 
}
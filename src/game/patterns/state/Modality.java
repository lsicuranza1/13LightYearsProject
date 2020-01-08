package game.patterns.state;
 
public class Modality {
 
    private State modalityState;
 
    public Modality(){
        this.modalityState = new StartingState();
    }

	public State getModalityState() {
		return modalityState;
	}

	public void setModalityState(State modalityState) {
		this.modalityState = modalityState;
	}
 
}
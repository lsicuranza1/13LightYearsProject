package game.patterns.state;

import game.ExecutionFrame;
import game.MainFrame;

public class ExecutionState implements State {

	private MainFrame mainFrame;
	private ExecutionFrame exeFrame;

	/**
	 * The constructor of ExecutionState class
	 */
	public ExecutionState() {
		
		mainFrame = MainFrame.getIstance();
		this.exeFrame = new ExecutionFrame();
		mainFrame.setFrame(exeFrame);
		mainFrame.getFrame().setVisible(true);
	}

	/**
	 *  It manages the State. It checks if the state "Execution" changes to "Running" / "Start" / "GameOver"
	 */
	@Override
	public void stateManagement(Modality modality, String state) {
		
		if (state.equals("game_over")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modality.setModalityState(new GameOverState());
		} else if (state.equals("start")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modality.setModalityState(new StartingState());
		} else if (state.equals("running")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modality.setModalityState(new ExecutionState());
		}

	}

}

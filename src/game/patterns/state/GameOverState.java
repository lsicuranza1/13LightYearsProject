package game.patterns.state;

import game.MainFrame;
import game.GameOverFrame;

public class GameOverState implements State {

	private MainFrame mainFrame = MainFrame.getIstance();
	private GameOverFrame gameOverFrame;
	

	/**
	 * The constructor of GameOverState class
	 */
	public GameOverState() {

		mainFrame = MainFrame.getIstance();
		this.gameOverFrame = new GameOverFrame();
		mainFrame.setFrame(gameOverFrame);
		mainFrame.getFrame().setVisible(true);

	}

	/**
	 * It manages the State. It checks if the state "GameOver" changes to "Running" / "Start"
	 */
	@Override
	public void stateManagement(Modality modality, String state) {
		
		if (state.equals("start")) {
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
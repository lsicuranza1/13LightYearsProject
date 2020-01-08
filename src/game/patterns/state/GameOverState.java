package game.patterns.state;

import game.MainFrame;
import game.GameOverFrame;

public class GameOverState implements State {

	private MainFrame mainFrame = MainFrame.getIstance();
	private GameOverFrame gameOverFrame;
	

	/**
	 * 
	 */
	public GameOverState() {

		mainFrame = MainFrame.getIstance();
		this.gameOverFrame = new GameOverFrame();
		mainFrame.setFrame(gameOverFrame);
		mainFrame.getFrame().setVisible(true);

	}

	/**
	 *
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
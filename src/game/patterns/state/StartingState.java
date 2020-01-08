package game.patterns.state;

import game.MainFrame;
import game.MenuFrame;
import game.Score;

public class StartingState implements State {

	private MainFrame mainFrame;
	private MenuFrame menuFrame;

	public StartingState() {
		mainFrame = MainFrame.getIstance();
		this.menuFrame = new MenuFrame();
		mainFrame.setFrame(menuFrame);
		mainFrame.setScore(new Score());
		mainFrame.getFrame().setVisible(true);
	}

	@Override
	public void stateManagement(Modality modality, String state) {
		
		if (state.equals("running")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modality.setModalityState(new ExecutionState());
		} else if (state.equals("demo")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modality.setModalityState(new DemoState());
		}
	}
}

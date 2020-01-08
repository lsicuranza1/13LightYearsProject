package game.patterns.state;

import game.DemoFrame;
import game.MainFrame;

public class DemoState implements State {

	private MainFrame mainFrame = MainFrame.getIstance();
	private DemoFrame demoFrame;

	public DemoState() {
		
		mainFrame = MainFrame.getIstance();
		this.demoFrame = new DemoFrame();
		mainFrame.setFrame(demoFrame);
		mainFrame.getFrame().setVisible(true);
	}

	@Override
	public void stateManagement(Modality modality, String state) {
		
		if (state.equals("running")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modality.setModalityState(new ExecutionState());
		}
	}

}

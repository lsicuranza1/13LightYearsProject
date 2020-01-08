package game.patterns.state;

import game.DemoFrame;
import game.MainFrame;

public class DemoState implements State {

	private MainFrame mainFrame = MainFrame.getIstance();
	private DemoFrame demoFrame;

	/**
	 * The constructor of DemoState class
	 */
	public DemoState() {
		
		mainFrame = MainFrame.getIstance();
		this.demoFrame = new DemoFrame();
		mainFrame.setFrame(demoFrame);
		mainFrame.getFrame().setVisible(true);
	}

	/**
	 *  It manages the State. It checks if the state "Demo" changes to "Running"
	 */
	@Override
	public void stateManagement(Modality modality, String state) {
		
		if (state.equals("running")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modality.setModalityState(new ExecutionState());
		}
	}

}

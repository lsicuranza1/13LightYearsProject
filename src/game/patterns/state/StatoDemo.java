package game.patterns.state;

import game.DemoFrame;
import game.MainFrame;

public class StatoDemo implements Stato {

	private MainFrame mainFrame = MainFrame.getIstance();
	private DemoFrame demoFrame;

	public StatoDemo() {
		mainFrame = MainFrame.getIstance();
		this.demoFrame = new DemoFrame();
		mainFrame.setFrame(demoFrame);
		mainFrame.getFrame().setVisible(true);

	}

	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("in_esecuzione")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoInEsecuzione());
		}
	}

}

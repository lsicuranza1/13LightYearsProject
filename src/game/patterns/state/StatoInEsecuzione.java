package game.patterns.state;

import game.ExecutionFrame;
import game.MainFrame;

public class StatoInEsecuzione implements Stato {

	private MainFrame mainFrame;
	private ExecutionFrame exeFrame;

	public StatoInEsecuzione() {
		mainFrame = MainFrame.getIstance();
		this.exeFrame = new ExecutionFrame();
		mainFrame.setFrame(exeFrame);
		mainFrame.getFrame().setVisible(true);
	}

	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("game_over")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoGameOver());
		} else if (stato.equals("start")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoStart());
		} else if (stato.equals("in_esecuzione")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoInEsecuzione());
		}

	}

}

package game.patterns.state;

import game.MainFrame;
import game.PanelGameOver;

public class StatoGameOver implements Stato {

	MainFrame mainFrame = MainFrame.getIstance();

	public StatoGameOver() {

		new PanelGameOver();

	}

	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("start")) {
			mainFrame.getFrame().setTitle("Start");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoStart());
		} else if (stato.equals("in_esecuzione")) {
			mainFrame.getFrame().setTitle("Gioco");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoInEsecuzione());
		}
	}

}
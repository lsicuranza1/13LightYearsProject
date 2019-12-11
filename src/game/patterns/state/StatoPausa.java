package game.patterns.state;

import game.MainFrame;

public class StatoPausa implements Stato {

	MainFrame mainFrame = MainFrame.getIstance();

	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("in_esecuzione")) {
			mainFrame.getFrame().setTitle("Gioco");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoInEsecuzione());
		}
		else if (stato.equals("start")) {
			mainFrame.getFrame().setTitle("Start");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoStart());
		}

	}

}

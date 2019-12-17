package game.patterns.state;

import game.MainFrame;
import game.GameOverFrame;

public class StatoGameOver implements Stato {

	private MainFrame mainFrame = MainFrame.getIstance();
	private GameOverFrame gameOverFrame;
	

	public StatoGameOver() {

		mainFrame = MainFrame.getIstance();
		this.gameOverFrame = new GameOverFrame();
		mainFrame.setFrame(gameOverFrame);
		mainFrame.getFrame().setVisible(true);

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
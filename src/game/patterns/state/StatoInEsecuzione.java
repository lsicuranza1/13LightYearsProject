package game.patterns.state;

import java.awt.Color;

import game.MainFrame;
import game.PanelEsecuzione;

public class StatoInEsecuzione implements Stato {

	MainFrame mainFrame = MainFrame.getIstance();
	private PanelEsecuzione panel = new PanelEsecuzione();

	public StatoInEsecuzione() {
		panel.setBackground(Color.BLACK);
		panel.setSize(1000, 600);
		mainFrame.getFrame().setVisible(true);
		mainFrame.getFrame().add(panel);
		panel.setFocusable(true);
		panel.requestFocus();

	}

	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("pausa")) {
			mainFrame.getFrame().setTitle("Pausa");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoPausa());
		} else if (stato.equals("game_over")) {
			mainFrame.getFrame().setTitle("GameOver");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoGameOver());
		} else if (stato.equals("start")) {
			mainFrame.getFrame().setTitle("Start");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoStart());
		}
	}

}

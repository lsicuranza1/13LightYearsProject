package game.patterns.state;

import java.awt.Color;

import game.MainFrame;
import game.PanelDemo;

public class StatoDemo implements Stato {

	MainFrame mainFrame = MainFrame.getIstance();
	private PanelDemo panel = new PanelDemo();

	public StatoDemo() {
		panel.setBackground(Color.BLACK);
		panel.setSize(1000, 600);
		mainFrame.getFrame().setVisible(true);
		mainFrame.getFrame().add(panel);
		panel.setFocusable(true);
		panel.requestFocus();

	}

	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("play")) {
			mainFrame.getFrame().setTitle("Game");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoInEsecuzione());
		}
	}

}

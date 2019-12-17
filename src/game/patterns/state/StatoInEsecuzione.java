package game.patterns.state;

import java.awt.Color;

import game.ExecutionFrame;
import game.MainFrame;
import game.MenuFrame;
import game.PanelEsecuzione;

public class StatoInEsecuzione implements Stato {

	private MainFrame mainFrame;
	private ExecutionFrame exeFrame;

	public StatoInEsecuzione() {
		mainFrame = MainFrame.getIstance();
		this.exeFrame = new ExecutionFrame();
		mainFrame.setFrame(exeFrame);
		mainFrame.getFrame().setVisible(true);
		
	
//		this.panel = new PanelEsecuzione();
//		panel.setBackground(Color.BLACK);
//		panel.setSize(1000, 600);
//		mainFrame.getFrame().setVisible(true);
//		mainFrame.getFrame().add(panel);
//		panel.setFocusable(true);
//		panel.requestFocus();

	}

	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("pausa")) {
			mainFrame.getFrame().setTitle("Pausa");
			mainFrame.getFrame().getContentPane().removeAll();
			mainFrame.getFrame().repaint();
			modalita.setStatoModalita(new StatoPausa());
		} else if (stato.equals("game_over")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoGameOver());
		} else if (stato.equals("start")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoStart());
		}
	}

}

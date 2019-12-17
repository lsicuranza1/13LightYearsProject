package game.patterns.state;

import game.MainFrame;
import game.MenuFrame;
import game.Score;

public class StatoStart implements Stato { //non deve essere un Jframe
	
	private MainFrame mainFrame ;
	private MenuFrame menu;
	
	public StatoStart() {
		mainFrame = MainFrame.getIstance();
		this.menu = new MenuFrame();
		mainFrame.setFrame(menu);
		mainFrame.setScore(new Score());
		mainFrame.getFrame().setVisible(true);
	}

	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("in_esecuzione")) {
//			mainFrame.getFrame().setTitle("Gioco");
//			mainFrame.getFrame().getContentPane().removeAll();
//			mainFrame.getFrame().repaint();
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoInEsecuzione());

		}
	}

}

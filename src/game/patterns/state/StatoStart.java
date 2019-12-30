package game.patterns.state;
import game.Sound;
import game.Settings;
import game.Utilities;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import game.MainFrame;
import game.MenuFrame;
import game.Score;

public class StatoStart implements Stato {

	private MainFrame mainFrame;
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
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoInEsecuzione());

		} else if (stato.equals("demo")) {
			mainFrame.getFrame().setVisible(false);
			mainFrame.getFrame().dispose();
			modalita.setStatoModalita(new StatoDemo());
		}
	}

}

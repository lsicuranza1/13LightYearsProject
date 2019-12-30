package game;

import java.awt.EventQueue;

import javax.swing.JFrame;

import game.patterns.state.Modalita;
import game.patterns.state.Stato;

public class MainFrame {

	private JFrame frame;
	private Modalita modalita;
	private Score score;

	// Singleton
	private static MainFrame istance = null;

	public static MainFrame getIstance() {
		if (istance == null)
			istance = new MainFrame();
		return istance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = MainFrame.getIstance();
					mainFrame.setModalita(new Modalita());
					mainFrame.setScore(new Score());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void updateModalita(String string) {
		Stato stato = modalita.getStatoModalita();
		stato.gestioneStato(modalita, string);
	}

	public Modalita getModalita() {
		return modalita;
	}

	public void setModalita(Modalita modalita) {
		this.modalita = modalita;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}

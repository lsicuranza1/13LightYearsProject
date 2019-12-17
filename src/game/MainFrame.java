package game;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import game.patterns.state.Modalita;
import game.patterns.state.Stato;

public class MainFrame {

	private JFrame frame;
	private Modalita modalita;
	private Score score;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();

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
					MainFrame window = MainFrame.getIstance();
					//window.setFrame(new StatoStart());
					window.setModalita(new Modalita());
					window.setScore(new Score());
//					window.getFrame().setVisible(true);
//					window.getFrame().setTitle("13 Light Years - Menù Principale");
//					window.getFrame().setVisible(true);
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

package game;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;
import game.patterns.state.Modality;
import game.patterns.state.State;
import rankingManagement.Scoreboard;

public class MainFrame {

	private JFrame frame;
	private Modality modality;
	private Score score;
	private static Scoreboard scoreboard;

	// Singleton
	private static MainFrame istance = null;

	/**
	 * @return
	 */
	public static MainFrame getIstance() {
		if (istance == null)
			istance = new MainFrame();
		return istance;
	}

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		scoreboard = new Scoreboard();
		scoreboard.load("scoreboard.dat");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = MainFrame.getIstance();
					mainFrame.setModality(new Modality());
					mainFrame.setScore(new Score());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @param string
	 */
	public void updateModality(String string) {
		State state = modality.getModalityState();
		state.stateManagement(modality, string);
	}

	/**
	 * @return
	 */
	public Modality getModality() {
		return modality;
	}

	/**
	 * @param modality
	 */
	public void setModality(Modality modality) {
		this.modality = modality;
	}

	/**
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * @param score
	 */
	public void setScore(Score score) {
		this.score = score;
	}

	/**
	 * @return
	 */
	public static Scoreboard getScoreboard() {
		return scoreboard;
	}

	/**
	 * @param scoreboard
	 */
	public static void setScoreboard(Scoreboard scoreboard) {
		MainFrame.scoreboard = scoreboard;
	}
	
}

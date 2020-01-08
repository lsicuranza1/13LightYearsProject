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

	/** It returns the instance of the MainFrame.
	 * @return A MainFrame
	 */
	public static MainFrame getIstance() {
		if (istance == null)
			istance = new MainFrame();
		return istance;
	}

	/**
	 * @param args args
	 * @throws ClassNotFoundException Class not found
	 * @throws IOException Problem in the Input/Output
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		scoreboard = new Scoreboard();
		scoreboard.load();
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

	/** It updates the modality of the game.There are four possible modality:
	 * - Start
	 * - Running
	 * - Pause
	 * - Demo
	 * @param string The name of the modality
	 */
	public void updateModality(String string) {
		State state = modality.getModalityState();
		state.stateManagement(modality, string);
	}

	/** It returns the modality.
	 * @return The modality
	 */
	public Modality getModality() {
		return modality;
	}

	/** It sets the modality.
	 * @param modality A modality
	 */
	public void setModality(Modality modality) {
		this.modality = modality;
	}

	/** It returns the main JFrame.
	 * @return A JFrame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/** It sets the main JFrame.
	 * @param frame A JFrame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/** It returns the score.
	 * @return The score
	 */
	public Score getScore() {
		return score;
	}

	/** It sets the score.
	 * @param score The score
	 */
	public void setScore(Score score) {
		this.score = score;
	}

	/** It returns the scoreboard read from file.
	 * @return A scoreboard
	 */
	public static Scoreboard getScoreboard() {
		return scoreboard;
	}

	/** It updates the scoreboard fread from file.
	 * @param scoreboard The scoreboard
	 */
	public static void setScoreboard(Scoreboard scoreboard) {
		MainFrame.scoreboard = scoreboard;
	}
	
}

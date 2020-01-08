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

	public static MainFrame getIstance() {
		if (istance == null)
			istance = new MainFrame();
		return istance;
	}

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

	public void updateModality(String string) {
		State state = modality.getModalityState();
		state.stateManagement(modality, string);
	}

	public Modality getModality() {
		return modality;
	}

	public void setModality(Modality modality) {
		this.modality = modality;
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

	public static Scoreboard getScoreboard() {
		return scoreboard;
	}

	public static void setScoreboard(Scoreboard scoreboard) {
		MainFrame.scoreboard = scoreboard;
	}
	
}

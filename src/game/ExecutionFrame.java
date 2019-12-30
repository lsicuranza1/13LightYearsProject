package game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import game.patterns.state.StatoInEsecuzione;

@SuppressWarnings("serial")
public class ExecutionFrame extends JFrame {
	
	private PanelEsecuzione panel;
	private Dimension dim;
	public static Sound soundInGame;
    public static Clip clipInGame;
    public static Sound gameMusic;
	
	public ExecutionFrame() {
		initComponents();
		
		if (gameMusic == null) {
			clipInGame = Utilities.LoadSound(getClass().getResource("../resources/sound/ingame.wav"));
			soundInGame = new Sound(clipInGame);
			soundInGame.playSound();		
    }
	
	}
	
	private void initComponents() {
		this.panel = new PanelEsecuzione();
		this.dim = new Dimension(800,800);
		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Game");
		this.setLocation((int) dimDisplay.getWidth() / 2 - (int)dim.getWidth() / 2, (int) dimDisplay.getHeight() / 2 - (int)dim.getHeight() / 2);
		this.setResizable(false);
		this.setMinimumSize(dim.getSize());
		this.setPreferredSize(dim.getSize());
		this.setMaximumSize(dim.getSize());
		this.add(panel);
		panel.setFocusable(true);
		panel.requestFocus();
	}

}

package game;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ExecutionFrame extends JFrame {
	
	private PanelExecution executionPanel;
	private Dimension dimFrame;
	public static Sound soundInGame;
    public static Clip clipInGame;
   
	/**
	 *  The constructor of ExecutionFrame
	 */
	public ExecutionFrame() {
		
		initComponents();
		
		if (Settings.soundMusic == true) {
			clipInGame = Utilities.LoadSound(getClass().getResource("../resources/sound/ingame.wav"));
			soundInGame = new Sound(clipInGame);
			soundInGame.loopSound();
		}
		
	}
	
	/**
	 * This method create all the components of the Frame
	 */
	private void initComponents() {
		
		this.executionPanel = new PanelExecution();
		this.dimFrame = new Dimension(800,800);
		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Game");
		this.setLocation((int) dimDisplay.getWidth() / 2 - (int)dimFrame.getWidth() / 2, (int) dimDisplay.getHeight() / 2 - (int)dimFrame.getHeight() / 2);
		this.setResizable(false);
		this.setMinimumSize(dimFrame.getSize());
		this.setPreferredSize(dimFrame.getSize());
		this.setMaximumSize(dimFrame.getSize());
		this.add(executionPanel);
		executionPanel.setFocusable(true);
		executionPanel.requestFocus();
	}

}

package game;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DemoFrame extends JFrame {

	private PanelDemo panelDemo;
	private Dimension dimFrame;
	public static Sound soundInGame;
    public static Clip clipInGame;
    public static Sound gameMusic;
	 
	/**
	 *  The constructor of DemoFrame.
	 */
	public DemoFrame() {
		initComponents();
		
		if ( Settings.soundMusic == true) {
			clipInGame = Utilities.LoadSound(getClass().getResource("../resources/sound/ingame.wav"));
			soundInGame = new Sound(clipInGame);
			soundInGame.loopSound();
		}
	}
	
	/**
	 *  This method creates all the components of the Frame.
	 */
	private void initComponents() {
		this.panelDemo = new PanelDemo();
		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		dimFrame = new Dimension(800,800);
		
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Demo");
		this.setLocation((int) dimDisplay.getWidth() / 2 - (int)dimFrame.getWidth() / 2, (int) dimDisplay.getHeight() / 2 - (int)dimFrame.getHeight()/ 2);
		this.setResizable(false);
		this.setMinimumSize(dimFrame.getSize());
		this.setPreferredSize(dimFrame.getSize());
		this.setMaximumSize(dimFrame.getSize());
		this.add(panelDemo);
		panelDemo.setFocusable(true);
		panelDemo.requestFocus();
	}

}

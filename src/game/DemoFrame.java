package game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DemoFrame extends JFrame {

	private PanelDemo panel;
	private Dimension dim;
	
	public DemoFrame() {
		initComponents();
	}
	
	private void initComponents() {
		this.panel = new PanelDemo();
		dim = new Dimension(800,800);
		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Demo");
		this.setLocation((int) dimDisplay.getWidth() / 2 - (int) dim.getWidth()/ 2, (int) dimDisplay.getHeight() / 2 - (int)dim.getHeight()/ 2);
		this.setResizable(false);
		this.setMinimumSize(dim.getSize());
		this.setPreferredSize(dim.getSize());
		this.setMaximumSize(dim.getSize());
		this.add(panel);
		panel.setFocusable(true);
		panel.requestFocus();
	}

}
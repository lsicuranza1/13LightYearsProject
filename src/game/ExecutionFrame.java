package game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ExecutionFrame extends JFrame {
	
	private PanelEsecuzione panel;
	private Dimension dim;
	
	public ExecutionFrame() {
		initComponents();
	}
	
	private void initComponents() {
		this.panel = new PanelEsecuzione();
		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		
		int widthMenu = (int) ((dimDisplay.getWidth() * 50) / 100); //i numeri moltiplicati devono essere uguali sia per la width che per la height
		int heightMenu = (int) ((dimDisplay.getHeight() * 90) / 100);
		dim = new Dimension(widthMenu, heightMenu);
		
		this.setTitle("Game");
		this.setLocation((int) dimDisplay.getWidth() / 2 - widthMenu / 2, (int) dimDisplay.getHeight() / 2 - heightMenu / 2);
		this.setResizable(false);
		this.setMinimumSize(dim.getSize());
		this.setPreferredSize(dim.getSize());
		this.setMaximumSize(dim.getSize());
		this.add(panel);
		panel.setFocusable(true);
		panel.requestFocus();
	}

}

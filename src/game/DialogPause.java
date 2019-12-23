package game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class DialogPause extends JPanel {
	private MainFrame mainframe = MainFrame.getIstance();
	private static final Color BG = new Color(0, 0, 0, 200);
	private javax.swing.JButton resume;
	private javax.swing.JButton restart;
	private javax.swing.JButton mainMenu;
	private PanelEsecuzione panelEsecuzione;

	// dependency inception
	public DialogPause(PanelEsecuzione panelEsecuzione) {
		this.panelEsecuzione = panelEsecuzione;
		JLabel pausedLabel = new JLabel("PAUSED");
		pausedLabel.setForeground(Color.ORANGE);
		
		JPanel pausedPanel = new JPanel();
		pausedPanel.setOpaque(false);
		pausedPanel.add(pausedLabel);
		
		setBackground(BG);
		int eb = 15;
		setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));
		setLayout(new GridLayout(0, 1, 10, 10));
		add(pausedPanel);
		resume = new JButton("RESUME");
		restart = new JButton("RESTART");
		mainMenu = new JButton("MAIN MENU");
		resume.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resumeActionPerformed(evt);
			}
		});
		restart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				restartActionPerformed(evt);
			}
		});
		mainMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainMenuActionPerformed(evt);
			}
		});
		add(resume);
		add(restart);
		add(mainMenu);
	}

	protected void mainMenuActionPerformed(ActionEvent evt) {
		panelEsecuzione.getDialog().setAlwaysOnTop(false);
		mainframe.updateModalita("start");
	}

	protected void restartActionPerformed(ActionEvent evt) {
		panelEsecuzione.getDialog().setAlwaysOnTop(false);
		mainframe.updateModalita("in_esecuzione");
	}

	protected void resumeActionPerformed(ActionEvent evt) {
		panelEsecuzione.setFlagPause(false);

	}

}
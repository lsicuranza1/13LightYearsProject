package game;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import gestioneClassifica.Classifica;

@SuppressWarnings("serial")
public class MenuFrame extends JFrame {
	private MainFrame mainFrame = MainFrame.getIstance();
	private static final long serialVersionUID = 6529685098267757690L;
	private Dimension dim;
	public static Clip gameClip;
	public static boolean demo = false;
	public static boolean flagScoreboard = false;
	public static boolean flagSettings = false;
	private javax.swing.JButton playButton;
	private javax.swing.JButton scoreBoardButton;
	private javax.swing.JButton settingsButton;
	private javax.swing.JButton demoButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel sfondo;
	private Classifica c=mainFrame.getC();
	private ImageIcon ridimensionaImageIcon(URL url, int nuovaW, int nuovaH) {
		ImageIcon image = new ImageIcon(url);
		Image immagineScalata = image.getImage().getScaledInstance(nuovaW, nuovaH, Image.SCALE_DEFAULT);
		return new ImageIcon(immagineScalata);
	}

	public MenuFrame() {
//		c = new Classifica();
//		c.leggiDaFileBinario();
		initComponents();
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		playButton = new javax.swing.JButton();
		scoreBoardButton = new javax.swing.JButton();
		settingsButton = new javax.swing.JButton();
		demoButton = new javax.swing.JButton();
		sfondo = new javax.swing.JLabel();

		Image iconaFrame;
		iconaFrame = new ImageIcon(getClass().getResource("../resources/images/logo_game.png")).getImage();
		this.setIconImage(iconaFrame);

		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		
		int widthMenu = (int) ((dimDisplay.getWidth() * 60) / 100); //i numeri moltiplicati devono essere uguali sia per la width che per la height
		int heightMenu = (int) ((dimDisplay.getHeight() * 60) / 100);
		dim = new Dimension(widthMenu, heightMenu);
		this.setPreferredSize(dim.getSize());

		ImageIcon immagineSfondo = ridimensionaImageIcon(
				getClass().getResource("../resources/images/sfondo_menu.png"), widthMenu, heightMenu);
		
		sfondo.setIcon(immagineSfondo);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("13 Light Years - Menu' Principale");

		this.setLocation((int) dimDisplay.getWidth() / 2 - widthMenu / 2, (int) dimDisplay.getHeight() / 2 - heightMenu / 2);
		setName("");
		//setPreferredSize(new java.awt.Dimension(1000, 600));
		setResizable(false);

		jPanel1.setAlignmentX(0.0F);
		jPanel1.setMinimumSize(dim.getSize());
		jPanel1.setName("");
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(dim.getSize());
		jPanel1.setLayout(new java.awt.GridBagLayout());

		playButton.setBackground(new java.awt.Color(255, 255, 255));
		playButton.setFont(new java.awt.Font("Gabriola", 0, 40));
		playButton.setForeground(new java.awt.Color(255, 255, 255));
		playButton.setText("Play");
		playButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null));
		playButton.setContentAreaFilled(false);
		playButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		playButton.setMaximumSize(new java.awt.Dimension(107, 25));
		playButton.setMinimumSize(new java.awt.Dimension(107, 25));
		playButton.setPreferredSize(new java.awt.Dimension(107, 25));
		playButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				playButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(269, 70, 0, 695);
		jPanel1.add(playButton, gridBagConstraints);

		scoreBoardButton.setFont(new java.awt.Font("Gabriola", 0, 40));
		scoreBoardButton.setForeground(new java.awt.Color(255, 255, 255));
		scoreBoardButton.setText("Scoreboard");
		scoreBoardButton.setToolTipText("");
		scoreBoardButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		scoreBoardButton.setContentAreaFilled(false);
		scoreBoardButton.setMaximumSize(new java.awt.Dimension(107, 25));
		scoreBoardButton.setMinimumSize(new java.awt.Dimension(107, 25));
		scoreBoardButton.setPreferredSize(new java.awt.Dimension(107, 25));
		scoreBoardButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				scoreBoardButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(18, 70, 0, 695);
		jPanel1.add(scoreBoardButton, gridBagConstraints);

		settingsButton.setFont(new java.awt.Font("Gabriola", 0, 40));
		settingsButton.setForeground(new java.awt.Color(255, 255, 255));
		settingsButton.setText("Settings");
		settingsButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		settingsButton.setContentAreaFilled(false);
		settingsButton.setMaximumSize(new java.awt.Dimension(107, 25));
		settingsButton.setMinimumSize(new java.awt.Dimension(107, 25));
		settingsButton.setPreferredSize(new java.awt.Dimension(107, 25));
		settingsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				settingsButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(18, 70, 65, 695);
		jPanel1.add(settingsButton, gridBagConstraints);
		settingsButton.getAccessibleContext().setAccessibleDescription("");

		demoButton.setFont(new java.awt.Font("Gabriola", 0, 40));
		demoButton.setForeground(new java.awt.Color(255, 255, 255));
		demoButton.setText("Demo");
		demoButton.setToolTipText("");
		demoButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		demoButton.setContentAreaFilled(false);
		demoButton.setMaximumSize(new java.awt.Dimension(107, 25));
		demoButton.setMinimumSize(new java.awt.Dimension(107, 25));
		demoButton.setPreferredSize(new java.awt.Dimension(107, 25));
		demoButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				demoButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(18, 70, 0, 695);
		jPanel1.add(demoButton, gridBagConstraints);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, (int) dim.getWidth(),
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, (int) dim.getHeight(),
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));

		jPanel1.getAccessibleContext().setAccessibleName("");
		jPanel1.getAccessibleContext().setAccessibleDescription("");

		pack();

		jPanel1.setFocusable(true);
		jPanel1.requestFocus();
	}

	private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.updateModalita("in_esecuzione");
		PanelEsecuzione.setAsteroidsDestoyed(0);
		PanelEsecuzione.setEnemiesDestoyed(0);

	}

	private void demoButtonActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.updateModalita("demo");
	}
	
	private void scoreBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if(flagScoreboard == false) {
			FrameScoreboard frameBoard = new FrameScoreboard(this.c);
			frameBoard.setVisible(true);
			flagScoreboard = true;
		}	
	}
	
	private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if(flagSettings==false) {
			Settings set = new Settings(this, true, false);
			set.setVisible(true);
			flagSettings = true;
		}
		}
		
	
	

}

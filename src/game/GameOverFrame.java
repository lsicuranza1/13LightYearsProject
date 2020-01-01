package game;
import javax.sound.sampled.Clip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.URL;
import game.Utilities;
import game.Sound;
import game.ExecutionFrame;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GameOverFrame extends javax.swing.JFrame {
	private Dimension dim;
	private MainFrame mainFrame = MainFrame.getIstance();
	private javax.swing.JPanel panelGameOver;
	private javax.swing.JButton playAgainButton;
	private javax.swing.JButton mainMenuButton;
	private javax.swing.JLabel sfondo;
	private javax.swing.JButton score;
	public static Sound soundEndGame;
    public static Clip clipEndGame;

	public GameOverFrame() {

		initComponents();
		
		if (Settings.soundMusic == true){
		
		ExecutionFrame.soundInGame.stopSound();
		
		GameOverFrame.clipEndGame = Utilities.LoadSound(getClass().getResource("../resources/sound/endGame.wav"));
		GameOverFrame.soundEndGame = new Sound(clipEndGame);
		//GameOverFrame.soundEndGame.playSound();
		GameOverFrame.soundEndGame.loopSound();
		}
	}

	private void initComponents() {

		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		this.dim = new Dimension(1000,600);
		this.setPreferredSize(dim.getSize());
		ImageIcon immagineSfondo = ridimensionaImageIcon(getClass().getResource("../resources/images/gameover2.png"),
				(int) dim.getWidth(), (int) dim.getHeight());

		this.setLocation((int) dimDisplay.getWidth() / 2 - (int) dim.getWidth() / 2,
				(int) dimDisplay.getHeight() / 2 - (int) dim.getHeight() / 2);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("13 Light Years - Menù Principale");

		java.awt.GridBagConstraints gridBagConstraints;

		panelGameOver = new javax.swing.JPanel();
		playAgainButton = new javax.swing.JButton("Play Again");
		mainMenuButton = new javax.swing.JButton("Main Menu");
		sfondo = new javax.swing.JLabel();
		score = new javax.swing.JButton("Great, your score is : " + mainFrame.getScore().getScoreValue());
		sfondo.setIcon(immagineSfondo);

		setName("");

		panelGameOver.setAlignmentX(0.0F);
		panelGameOver.setMinimumSize(dim.getSize());
		panelGameOver.setName("");
		panelGameOver.setOpaque(false);
		panelGameOver.setPreferredSize(dim.getSize());
		panelGameOver.setLayout(new java.awt.GridBagLayout());

		score.setFont(new java.awt.Font("Inc Free", 1, 25));
		score.setForeground(Color.red);
		score.setFocusPainted(false);
		score.setOpaque(false);
		score.setContentAreaFilled(false);
		score.setBorderPainted(false);
		score.setVerticalAlignment(1);
		score.setOpaque(false);
		score.setMaximumSize(new java.awt.Dimension(250, 200));
		score.setMinimumSize(new java.awt.Dimension(250, 200));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(300, 720, 0, 720);
		panelGameOver.add(score, gridBagConstraints);

		playAgainButton.setFont(new java.awt.Font("Inc Free", 1, 35));
		playAgainButton.setForeground(Color.CYAN);
		playAgainButton.setFocusPainted(false);
		playAgainButton.setOpaque(false);
		playAgainButton.setContentAreaFilled(false);
		playAgainButton.setBorderPainted(false);
		playAgainButton.setVerticalAlignment(1);
		playAgainButton.setOpaque(false);
		playAgainButton.setMaximumSize(new java.awt.Dimension(107, 25));
		playAgainButton.setMinimumSize(new java.awt.Dimension(107, 25));
		playAgainButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				playAgainButtonActionPerformed(evt);
			}
		});

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(200, 800, 0, 800);
		panelGameOver.add(playAgainButton, gridBagConstraints);

		mainMenuButton.setFont(new java.awt.Font("Inc Free", 1, 24));
		mainMenuButton.setForeground(Color.orange);
		mainMenuButton.setFocusPainted(false);
		mainMenuButton.setOpaque(false);
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBorderPainted(false);
		mainMenuButton.setVerticalAlignment(1);
		mainMenuButton.setOpaque(false);
		mainMenuButton.setMaximumSize(new java.awt.Dimension(107, 25));
		mainMenuButton.setMinimumSize(new java.awt.Dimension(107, 25));
		mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainMenuButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(250, 800, 0, 800);
		panelGameOver.add(mainMenuButton, gridBagConstraints);

		panelGameOver.getAccessibleContext().setAccessibleName("");
		panelGameOver.getAccessibleContext().setAccessibleDescription("");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panelGameOver, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE,
												(int) dim.getWidth(), javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panelGameOver, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE,
												(int) dim.getHeight(), javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));

		pack();

		panelGameOver.setFocusable(true);
		panelGameOver.requestFocus();

	}

	protected void mainMenuButtonActionPerformed(ActionEvent evt) {

		if(Settings.soundMusic == true) {
			GameOverFrame.soundEndGame.stopSound();
			//MenuFrame.gameMusic.playSound();
		}
		
		
		
		mainFrame.updateModalita("start");
	}

	private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {

		mainFrame.updateModalita("in_esecuzione");
		GameOverFrame.soundEndGame.stopSound();
	}

	private ImageIcon ridimensionaImageIcon(URL url, int nuovaW, int nuovaH) {
		ImageIcon image = new ImageIcon(url);
		Image immagineScalata = image.getImage().getScaledInstance(nuovaW, nuovaH, Image.SCALE_DEFAULT);
		return new ImageIcon(immagineScalata);
	}

}

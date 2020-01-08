package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import game.Utilities;
import rankingManagement.Player;
import rankingManagement.UnclassifiedPlayerException;
import javax.sound.sampled.Clip;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import game.Sound;
import game.ExecutionFrame;
import javax.swing.*;

@SuppressWarnings("serial")
public class GameOverFrame extends javax.swing.JFrame {
	private Dimension dim; 
	private MainFrame mainFrame = MainFrame.getIstance();
	private javax.swing.JPanel panelGameOver;
	private javax.swing.JButton playAgainButton;
	private javax.swing.JButton mainMenuButton;
	private javax.swing.JButton enemy,asteroid;
	private javax.swing.JLabel background;
	private javax.swing.JButton score;
	private javax.swing.JTextField name;
	private javax.swing.JButton addButton;
	public static Sound soundEndGame;
    public static Clip clipEndGame;
 
	/**
	 * 
	 */
	public GameOverFrame() {

		initComponents();
		
		if (Settings.soundMusic == true){
		
			ExecutionFrame.soundInGame.stopSound();
			
			GameOverFrame.clipEndGame = Utilities.LoadSound(getClass().getResource("../resources/sound/endGame.wav"));
			GameOverFrame.soundEndGame = new Sound(clipEndGame);
			GameOverFrame.soundEndGame.loopSound();
		}
	}

	/**
	 * 
	 */
	private void initComponents() {

		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		this.dim = new Dimension(1000,600);
		this.setPreferredSize(dim.getSize());
		ImageIcon backgroundImage = resizeImageIcon(getClass().getResource("../resources/images/gameover2.png"),
				(int) dim.getWidth(), (int) dim.getHeight());
		this.setLocation((int) dimDisplay.getWidth() / 2 - (int) dim.getWidth()  / 2,
				(int) dimDisplay.getHeight() / 2 - (int) dim.getHeight() / 2);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("GameOver");
		this.setResizable(false);

		java.awt.GridBagConstraints gridBagConstraints;

		panelGameOver = new javax.swing.JPanel();
		playAgainButton = new javax.swing.JButton("Play Again");
		mainMenuButton = new javax.swing.JButton("Main Menu");
		background = new javax.swing.JLabel();
		score = new javax.swing.JButton("Great, your score is : " + mainFrame.getScore().getScoreValue());
		enemy = new javax.swing.JButton("Enemies destroyed: " + PanelExecution.getEnemiesDestoyed());
		asteroid = new javax.swing.JButton("Asteroids destroyed:  "+ PanelExecution.getAsteroidsDestoyed());
		background.setIcon(backgroundImage);

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
		score.setMaximumSize(new java.awt.Dimension(250, 20));
		score.setMinimumSize(new java.awt.Dimension(250, 20));

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 348;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(140, 720, 0, 720);
		panelGameOver.add(score, gridBagConstraints);

		playAgainButton.setFont(new java.awt.Font("Inc Free", 1, 35));
		playAgainButton.setForeground(Color.GREEN);
		playAgainButton.setFocusPainted(false);
		playAgainButton.setContentAreaFilled(false);
		playAgainButton.setBorderPainted(false);
		playAgainButton.setVerticalAlignment(1);
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
		gridBagConstraints.ipadx = 348;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(-140, 800, 0, 800);
		panelGameOver.add(playAgainButton, gridBagConstraints);

		mainMenuButton.setFont(new java.awt.Font("Inc Free", 1, 24));
		mainMenuButton.setForeground(Color.GREEN);
		mainMenuButton.setFocusPainted(false);
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBorderPainted(false);
		mainMenuButton.setVerticalAlignment(1);
		mainMenuButton.setMaximumSize(new java.awt.Dimension(107, 25));
		mainMenuButton.setMinimumSize(new java.awt.Dimension(107, 25));
		mainMenuButton.addActionListener(new java.awt.event.ActionListener() {				
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainMenuButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.ipadx = 348;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(-50, 800, 0, 800);
		panelGameOver.add(mainMenuButton, gridBagConstraints);
		
		enemy.setFont(new java.awt.Font("Inc Free", 1, 24));
		enemy.setForeground(Color.WHITE);
		enemy.setVerticalAlignment(1);
		enemy.setFocusPainted(false);
		enemy.setContentAreaFilled(false);
		enemy.setBorderPainted(false);
		enemy.setMaximumSize(new java.awt.Dimension(127, 25));
		enemy.setMinimumSize(new java.awt.Dimension(127, 25));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 348;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(70, 800, 0, 800);
		panelGameOver.add(enemy, gridBagConstraints);
		
		asteroid.setFont(new java.awt.Font("Inc Free", 1, 24));
		asteroid.setForeground(Color.WHITE);
		asteroid.setVerticalAlignment(1);
		asteroid.setFocusPainted(false);
		asteroid.setContentAreaFilled(false);
		asteroid.setBorderPainted(false);
		asteroid.setMaximumSize(new java.awt.Dimension(127, 25));
		asteroid.setMinimumSize(new java.awt.Dimension(127, 25));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 348;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(20, 800, 0, 800);
		panelGameOver.add(asteroid, gridBagConstraints);
		
		name = new JTextField("           Insert name",40);
		name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear(evt);
            }
        });
		name.requestFocusInWindow();
		name.setEditable(true);
		name.setFocusable(true);
		name.setEnabled(true);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 170;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(270, 800, 0, 800);
		panelGameOver.add(name,gridBagConstraints);
		
		addButton = new JButton("Add to the scoreboard");
		addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
					try {
						addPlayer(evt);
				    } catch (UnclassifiedPlayerException ex) {
				        JOptionPane.showMessageDialog(panelGameOver, "Sorry ... you didn't rank!","Result",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("../resources/images/logo_game2.png")));
				    } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					 
					addButton.setVisible(false);
					name.setVisible(false);
            }

        });
		addButton.setMaximumSize(new java.awt.Dimension(50, 25));
		addButton.setMinimumSize(new java.awt.Dimension(50, 25));
		addButton.setSize(50, 25);
		
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 170;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(410, 800, 0, 800);
		panelGameOver.add(addButton,gridBagConstraints);


		panelGameOver.getAccessibleContext().setAccessibleName("");
		panelGameOver.getAccessibleContext().setAccessibleDescription("");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panelGameOver, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE,
												(int) dim.getWidth(), javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panelGameOver, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE,
												(int) dim.getHeight(), javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));

		pack();
		
		panelGameOver.setFocusable(true);
		panelGameOver.requestFocus();

	}

	/**
	 * @param evt
	 * @throws UnclassifiedPlayerException
	 * @throws IOException
	 */
	private void addPlayer(java.awt.event.ActionEvent evt) throws UnclassifiedPlayerException, IOException{
		String playerName = this.name.getText();
		 if(playerName.equals("           Insert name") || playerName.equals("")) {
			 playerName="Anonymous";
		 }
		 name.setText("           Insert name");
		 Player player = new Player(playerName);
		 player.setScore(mainFrame.getScore().getScoreValue());
		 MainFrame.getScoreboard().addPlayer(player);
		 MainFrame.getScoreboard().save();
			 
		 int position = MainFrame.getScoreboard().getScoreboardList().indexOf(player);
		 JOptionPane.showMessageDialog(this,"Congratulations "+player.getPlayerTag()+", you entered the ranking in "+(position+1)+" position","Result",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("../resources/images/logo_game2.png")));
    } 
		 

	/**
	 * @param evt
	 */
	protected void mainMenuButtonActionPerformed(ActionEvent evt) {
		if(Settings.soundMusic == true) {
			GameOverFrame.soundEndGame.stopSound();
		}
		
		mainFrame.updateModality("start");
	}

	/**
	 * @param evt
	 */
	private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {

		mainFrame.updateModality("running");
		GameOverFrame.soundEndGame.stopSound();
		PanelExecution.setAsteroidsDestoyed(0);
		PanelExecution.setEnemiesDestoyed(0);
	}
	
	/**
	 * @param evt
	 */
	private void clear(java.awt.event.MouseEvent evt) {                                         
        this.name.setText("");
    }
	
	/**
	 * @param url
	 * @param newW
	 * @param newH
	 * @return
	 */
	private ImageIcon resizeImageIcon(URL url, int newW, int newH) {
		ImageIcon image = new ImageIcon(url);
		Image scaledImage = image.getImage().getScaledInstance(newW, newH, Image.SCALE_DEFAULT);
		return new ImageIcon(scaledImage);
	}

}
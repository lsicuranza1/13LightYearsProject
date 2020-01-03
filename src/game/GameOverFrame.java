package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import game.Utilities;
import javax.sound.sampled.Clip;
import java.awt.event.ActionEvent;
import java.net.URL;
import game.Sound;
import game.ExecutionFrame;
import javax.swing.*;
import gestioneClassifica.Giocatore;
import gestioneClassifica.GiocatoreNonClassificatoException;
@SuppressWarnings("serial")
public class GameOverFrame extends javax.swing.JFrame {
	private Dimension dim; 
	private MainFrame mainFrame = MainFrame.getIstance();
	private javax.swing.JPanel panelGameOver;
	private javax.swing.JButton playAgainButton;
	private javax.swing.JButton mainMenuButton;
	private javax.swing.JLabel sfondo, enemy, asteroid;
	private javax.swing.JButton score;
	private javax.swing.JTextField name;
	private javax.swing.JButton add;
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

		this.setLocation((int) dimDisplay.getWidth() / 2 - (int) dim.getWidth()  / 2,
				(int) dimDisplay.getHeight() / 2 - (int) dim.getHeight() / 2);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Game Over");
		this.setResizable(false);

		java.awt.GridBagConstraints gridBagConstraints;

		panelGameOver = new javax.swing.JPanel();
		playAgainButton = new javax.swing.JButton("Play Again");
		mainMenuButton = new javax.swing.JButton("Main Menu");
		sfondo = new javax.swing.JLabel();
		score = new javax.swing.JButton("Great, your score is : " + mainFrame.getScore().getScoreValue());
		enemy = new javax.swing.JLabel("Enemies destroyed: " + PanelEsecuzione.getEnemiesDestoyed());
		asteroid = new javax.swing.JLabel("Asteroids destroyed:  "+ PanelEsecuzione.getAsteroidsDestoyed());
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
		score.setMaximumSize(new java.awt.Dimension(250, 20));
		score.setMinimumSize(new java.awt.Dimension(250, 20));

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
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(100, 800, 0, 800);
		panelGameOver.add(playAgainButton, gridBagConstraints);

		mainMenuButton.setFont(new java.awt.Font("Inc Free", 1, 24));
		mainMenuButton.setForeground(Color.orange);
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
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(150, 800, 0, 800);
		panelGameOver.add(mainMenuButton, gridBagConstraints);
		
		enemy.setFont(new java.awt.Font("Inc Free", 1, 24));
		enemy.setForeground(Color.orange);
		enemy.setVerticalAlignment(1);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(210, 800, 0, 800);
		panelGameOver.add(enemy, gridBagConstraints);
		
		asteroid.setFont(new java.awt.Font("Inc Free", 1, 24));
		asteroid.setForeground(Color.orange);
		asteroid.setVerticalAlignment(1);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(245, 800, 0, 800);
		panelGameOver.add(asteroid, gridBagConstraints);
		
		name = new JTextField("           Inserire nome",40);
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
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(350, 820, 0, 800);
		panelGameOver.add(name,gridBagConstraints);
		
		add = new JButton("Add to the scoreboard");
		add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
					try {
						addPlayer(evt);
				    } catch (GiocatoreNonClassificatoException ex) {
				        JOptionPane.showMessageDialog(panelGameOver, "Spiacenti... non ti sei classificato","Risultato",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("../resources/images/logo_game2.png")));
				    }					
					add.setVisible(false);
					name.setVisible(false);
            }

        });
		add.setMaximumSize(new java.awt.Dimension(50, 25));
		add.setMinimumSize(new java.awt.Dimension(50, 25));
		add.setSize(50, 25);
		
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 170;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(410, 800, 0, 800);
		panelGameOver.add(add,gridBagConstraints);


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

	private void addPlayer(java.awt.event.ActionEvent evt) throws GiocatoreNonClassificatoException{
		String nomeGiocatore = this.name.getText();
		 if(nomeGiocatore.equals("           Inserire nome") || nomeGiocatore.equals("")) {
			 nomeGiocatore="Anonimo";
		 }
		 name.setText("Inserire nome");
		 Giocatore g = new Giocatore(nomeGiocatore);
		 g.setPunteggio(mainFrame.getScore().getScoreValue());
		 MainFrame.getC().aggiungiGiocatore(g);
		 MainFrame.getC().salvaSuFileBinario("classifica.dat");
			 
		 int position = MainFrame.getC().getClassifica().indexOf(g);
		 JOptionPane.showMessageDialog(this,"Congratulazioni "+g.getTagGiocatore()+" sei entrato in classifica al "+(position+1)+" posto","Risultato",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("../resources/images/logo_game2.png")));
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
		PanelEsecuzione.setAsteroidsDestoyed(0);
		PanelEsecuzione.setEnemiesDestoyed(0);
	}
	
	private void clear(java.awt.event.MouseEvent evt) {                                         
        this.name.setText("");
    }
	
	private ImageIcon ridimensionaImageIcon(URL url, int nuovaW, int nuovaH) {
		ImageIcon image = new ImageIcon(url);
		Image immagineScalata = image.getImage().getScaledInstance(nuovaW, nuovaH, Image.SCALE_DEFAULT);
		return new ImageIcon(immagineScalata);
	}

}

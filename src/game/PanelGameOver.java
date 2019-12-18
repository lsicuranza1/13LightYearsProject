package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PanelGameOver extends javax.swing.JFrame implements ActionListener {
	Dimension dim;
	MainFrame mainFrame = MainFrame.getIstance();
	private javax.swing.JButton jButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel sfondo;
	private javax.swing.JButton score;

	public PanelGameOver() {

		initComponents();
	}

	private void initComponents() {

<<<<<<< Updated upstream:src/game/PanelGameOver.java
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		dim.setSize(1000, 600);
=======
		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		
		int widthMenu = (int) ((dimDisplay.getWidth() * 60) / 100); //i numeri moltiplicati devono essere uguali sia per la width che per la height
		int heightMenu = (int) ((dimDisplay.getHeight() * 60) / 100);
		dim = new Dimension(widthMenu, heightMenu);
>>>>>>> Stashed changes:src/game/GameOverFrame.java
		this.setPreferredSize(dim.getSize());
		ImageIcon immagineSfondo = ridimensionaImageIcon(getClass().getResource("../resources/images/gameover2.png"),
				dim.width, dim.height);

		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();

		jButton = new javax.swing.JButton("Play Again");
		jButton1 = new javax.swing.JButton("Main Menu");
		sfondo = new javax.swing.JLabel();
		score = new javax.swing.JButton("Great, your score is : " + mainFrame.getScore().getScoreValue());

		setName("");
		setPreferredSize(new java.awt.Dimension(1000, 600));

		jPanel1.setAlignmentX(0.0F);
		jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
		jPanel1.setName("");
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(dim.getSize());
		jPanel1.setLayout(new java.awt.GridBagLayout());

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

		

		sfondo.setMaximumSize(new java.awt.Dimension(1000, 1000));

		jPanel1.getAccessibleContext().setAccessibleName("");
		jPanel1.getAccessibleContext().setAccessibleDescription("");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1000,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));

		pack();

		sfondo.setPreferredSize(dim.getSize());
		sfondo.setIcon(immagineSfondo);

		jPanel1.add(sfondo);
		mainFrame.getFrame().setVisible(true);
		mainFrame.getFrame().add(jPanel1);
		jPanel1.setFocusable(true);
		jPanel1.requestFocus();

	}

	protected void jButton1ActionPerformed(ActionEvent evt) {

		mainFrame.updateModalita("start");
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {

		mainFrame.updateModalita("in_esecuzione");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private ImageIcon ridimensionaImageIcon(URL url, int nuovaW, int nuovaH) {
		ImageIcon image = new ImageIcon(url);
		Image immagineScalata = image.getImage().getScaledInstance(nuovaW, nuovaH, Image.SCALE_DEFAULT);
		return new ImageIcon(immagineScalata);
	}

}

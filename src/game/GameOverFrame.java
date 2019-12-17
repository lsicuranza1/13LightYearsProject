package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GameOverFrame extends javax.swing.JFrame{
	private Dimension dim;
	private MainFrame mainFrame = MainFrame.getIstance();
	private javax.swing.JButton jButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel sfondo;
	private javax.swing.JButton score;

	public GameOverFrame() {

		initComponents();
	}

	private void initComponents() {

		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		
		int widthMenu = (int) ((dimDisplay.getWidth() * 30) / 100); //i numeri moltiplicati devono essere uguali sia per la width che per la height
		int heightMenu = (int) ((dimDisplay.getHeight() * 30) / 100);
		dim = new Dimension(widthMenu, heightMenu);
		this.setPreferredSize(dim.getSize());
		ImageIcon immagineSfondo = ridimensionaImageIcon(getClass().getResource("../resources/images/gameover2.png"),
				(int) dim.getWidth(), (int) dim.getHeight());

		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();

		jButton = new javax.swing.JButton("Play Again");
		jButton1 = new javax.swing.JButton("Main Menu");
		sfondo = new javax.swing.JLabel();
		score = new javax.swing.JButton("Great, your score is : " + mainFrame.getScore().getScoreValue());

		setName("");

		jPanel1.setAlignmentX(0.0F);
		jPanel1.setMinimumSize(dim.getSize());
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

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(300, 720, 0, 720);
		jPanel1.add(score, gridBagConstraints);

		jButton.setFont(new java.awt.Font("Inc Free", 1, 35));
		jButton.setForeground(Color.CYAN);
		jButton.setFocusPainted(false);
		jButton.setOpaque(false);
		jButton.setContentAreaFilled(false);
		jButton.setBorderPainted(false);
		jButton.setVerticalAlignment(1);
		jButton.setOpaque(false);
		jButton.setMaximumSize(new java.awt.Dimension(107, 25));
		jButton.setMinimumSize(new java.awt.Dimension(107, 25));
		jButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonActionPerformed(evt);
			}
		});

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(200, 800, 0, 800);
		jPanel1.add(jButton, gridBagConstraints);

		jButton1.setFont(new java.awt.Font("Inc Free", 1, 24));
		jButton1.setForeground(Color.orange);
		jButton1.setFocusPainted(false);
		jButton1.setOpaque(false);
		jButton1.setContentAreaFilled(false);
		jButton1.setBorderPainted(false);
		jButton1.setVerticalAlignment(1);
		jButton1.setOpaque(false);
		jButton1.setMaximumSize(new java.awt.Dimension(107, 25));
		jButton1.setMinimumSize(new java.awt.Dimension(107, 25));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(250, 800, 0, 800);
		jPanel1.add(jButton1, gridBagConstraints);


		jPanel1.getAccessibleContext().setAccessibleName("");
		jPanel1.getAccessibleContext().setAccessibleDescription("");

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

		pack();

		sfondo.setPreferredSize(dim.getSize());
		sfondo.setIcon(immagineSfondo);
		jPanel1.add(sfondo);
		this.setVisible(true);
		this.add(jPanel1);
		jPanel1.setFocusable(true);
		jPanel1.requestFocus();

	}

	protected void jButton1ActionPerformed(ActionEvent evt) {

		mainFrame.updateModalita("start");
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {

		mainFrame.updateModalita("in_esecuzione");
	}


	private ImageIcon ridimensionaImageIcon(URL url, int nuovaW, int nuovaH) {
		ImageIcon image = new ImageIcon(url);
		Image immagineScalata = image.getImage().getScaledInstance(nuovaW, nuovaH, Image.SCALE_DEFAULT);
		return new ImageIcon(immagineScalata);
	}

}

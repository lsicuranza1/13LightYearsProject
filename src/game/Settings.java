/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import game.MenuFrame;;

@SuppressWarnings("serial")
public class Settings extends javax.swing.JDialog {

	public static boolean soundEffects = true;
	public static boolean soundMusic = true;
	public static boolean padArrows = false;
	public boolean inGame;

	private javax.swing.JButton effects;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JButton music;

	public Settings(java.awt.Frame parent, boolean modal, boolean inGame) {
		super(parent, modal);
		this.inGame = inGame;
		initComponents();
		
	}

	private void initComponents() {

		jLabel3 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		effects = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		music = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("13 Light Years");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setFont(new java.awt.Font("Gabriola", 0, 24));
		setLocation(new java.awt.Point(737, 331));
		setModalityType(null);
		setResizable(false);

		jLabel3.setFont(new java.awt.Font("Gabriola", 1, 36));
		jLabel3.setText("Settings");

		jLabel2.setFont(new java.awt.Font("Gabriola", 0, 24));
		jLabel2.setText("Sound effects");

		effects.setText("ON");
		effects.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				effectsActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Gabriola", 0, 24));
		jLabel1.setText("Music");

		music.setText("ON");
		music.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				musicActionPerformed(evt);
			}
		});

		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/images/awsd.png")));
		jLabel4.setMaximumSize(new java.awt.Dimension(379, 120));
		jLabel4.setMinimumSize(new java.awt.Dimension(379, 120));
		jLabel4.setName("");
		jLabel4.setPreferredSize(new java.awt.Dimension(379, 120));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(25, 25, 25)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 390,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(music, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(83, 83, 83).addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(effects, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(8, 8, 8)))
				.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel3).addGap(165, 165, 165)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(effects, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(music, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
						.addGap(26, 26, 26)));

		getAccessibleContext().setAccessibleParent(null);

		pack();
	}

	private void effectsActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void musicActionPerformed(java.awt.event.ActionEvent evt) {
		MenuFrame a=new MenuFrame();
		a.gameClip.stop();
	

	}

}

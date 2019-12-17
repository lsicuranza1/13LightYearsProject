package game;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MenuFrame extends JFrame {
	private MainFrame mainFrame = MainFrame.getIstance();

	private Dimension dim;
//	public static Clip gameClip;
//	public static boolean demo = false;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel sfondo;

	private ImageIcon ridimensionaImageIcon(URL url, int nuovaW, int nuovaH) {
		ImageIcon image = new ImageIcon(url);
		Image immagineScalata = image.getImage().getScaledInstance(nuovaW, nuovaH, Image.SCALE_DEFAULT);
		return new ImageIcon(immagineScalata);
	}

	public MenuFrame() {
		initComponents();
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
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

		jButton2.setBackground(new java.awt.Color(255, 255, 255));
		jButton2.setFont(new java.awt.Font("Gabriola", 0, 40));
		jButton2.setForeground(new java.awt.Color(255, 255, 255));
		jButton2.setText("Play");
		jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null));
		jButton2.setContentAreaFilled(false);
		jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jButton2.setMaximumSize(new java.awt.Dimension(107, 25));
		jButton2.setMinimumSize(new java.awt.Dimension(107, 25));
		jButton2.setPreferredSize(new java.awt.Dimension(107, 25));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(269, 70, 0, 695);
		jPanel1.add(jButton2, gridBagConstraints);

		jButton3.setFont(new java.awt.Font("Gabriola", 0, 40));
		jButton3.setForeground(new java.awt.Color(255, 255, 255));
		jButton3.setText("Scoreboard");
		jButton3.setToolTipText("");
		jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jButton3.setContentAreaFilled(false);
		jButton3.setMaximumSize(new java.awt.Dimension(107, 25));
		jButton3.setMinimumSize(new java.awt.Dimension(107, 25));
		jButton3.setPreferredSize(new java.awt.Dimension(107, 25));
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(18, 70, 0, 695);
		jPanel1.add(jButton3, gridBagConstraints);

		jButton4.setFont(new java.awt.Font("Gabriola", 0, 40));
		jButton4.setForeground(new java.awt.Color(255, 255, 255));
		jButton4.setText("Settings");
		jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jButton4.setContentAreaFilled(false);
		jButton4.setMaximumSize(new java.awt.Dimension(107, 25));
		jButton4.setMinimumSize(new java.awt.Dimension(107, 25));
		jButton4.setPreferredSize(new java.awt.Dimension(107, 25));
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(18, 70, 65, 695);
		jPanel1.add(jButton4, gridBagConstraints);
		jButton4.getAccessibleContext().setAccessibleDescription("");

		jButton5.setFont(new java.awt.Font("Gabriola", 0, 40));
		jButton5.setForeground(new java.awt.Color(255, 255, 255));
		jButton5.setText("Demo");
		jButton5.setToolTipText("");
		jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		jButton5.setContentAreaFilled(false);
		jButton5.setMaximumSize(new java.awt.Dimension(107, 25));
		jButton5.setMinimumSize(new java.awt.Dimension(107, 25));
		jButton5.setPreferredSize(new java.awt.Dimension(107, 25));
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 148;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(18, 70, 0, 695);
		jPanel1.add(jButton5, gridBagConstraints);

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
		
		if (mainFrame.getFrame() != null) {
			sfondo.setPreferredSize(dim.getSize());
			sfondo.setIcon(immagineSfondo);

			jPanel1.add(sfondo);
			mainFrame.getFrame().setVisible(true);
			mainFrame.getFrame().add(jPanel1);
			jPanel1.setFocusable(true);
			jPanel1.requestFocus();
		} else {
			sfondo.setPreferredSize(new Dimension(30, 40));
			sfondo.setIcon(immagineSfondo);
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.updateModalita("in_esecuzione");

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		Settings set = new Settings(this, true, false);
		set.setVisible(true);
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

	}

}

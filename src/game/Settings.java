/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import game.MainFrame;

@SuppressWarnings("serial")
public class Settings extends javax.swing.JDialog {

	public static boolean soundEffects = true;
	public static boolean soundMusic = true;
	public static int mod;
	public boolean inGame;
	

	private javax.swing.JButton effects;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JButton music;	
	private JRadioButton wasd;
	private JRadioButton arrows;
	
	
	
	/**
	 * @wbp.nonvisual location=72,299
	 */
	

	public Settings(java.awt.Frame parent, boolean modal, boolean inGame) {
		super(parent, modal);
		this.inGame = inGame;
		initComponents();
		ButtonGroup bg = new ButtonGroup();
        bg.add(this.wasd);
        bg.add(this.arrows);
       
        if(soundEffects == false)
        	effects.setText("OFF");
        
        if(soundMusic == false)
        	music.setText("OFF");
        
        if(mod == 1) 
        	wasd.setSelected(true);        	
        else        	
        	arrows.setSelected(true);
        
	}

	private void initComponents() {

		jLabel3 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		effects = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		music = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
        wasd = new javax.swing.JRadioButton();        
        arrows = new javax.swing.JRadioButton();

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


		jLabel1.setFont(new java.awt.Font("Gabriola", 0, 24));
		jLabel1.setText("Music");

		
		
		wasd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wasdActionPerformed(evt);
            }
        });
		
		arrows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrowsActionPerformed(evt);
            }
        });
		
		 effects.setText("ON");
	        effects.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                effectsActionPerformed(evt);
	            }
	        });
	        
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
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(168, Short.MAX_VALUE)
					.addComponent(jLabel3)
					.addGap(165))
				.addGroup(layout.createSequentialGroup()
					.addGap(25)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(music, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(83)
							.addComponent(jLabel2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(effects, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(8)))
					.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addGap(96)
					.addComponent(wasd)
					.addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
					.addComponent(arrows)
					.addGap(101))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(effects, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(music, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(wasd)
						.addComponent(arrows))
					.addContainerGap())
		);
		getContentPane().setLayout(layout);

		getAccessibleContext().setAccessibleParent(null);

		pack();
	}

	private void effectsActionPerformed(java.awt.event.ActionEvent evt) {
		 
		String text = this.effects.getText();
		 
	        if (text.compareTo("ON") == 0) {	        	
	        		soundEffects = false;
	            this.effects.setText("OFF");
	            	            
	        } else {
	        	soundEffects = true;
	        	
	            this.effects.setText("ON");
	            
	            
	        }
	}

	private void musicActionPerformed(java.awt.event.ActionEvent evt) {
		String text = this.music.getText();
		 
        if (text.compareTo("ON") == 0) {
        	soundMusic = false;
            MenuFrame.gameMusic.stopSound();
                       
            this.music.setText("OFF");
        } else {
        	soundMusic = true;
        	//MenuFrame.gameMusic.playSound();
        	MenuFrame.gameMusic.loopSound();
            this.music.setText("ON");
        }
	}
	
	private void wasdActionPerformed(java.awt.event.ActionEvent evt) {
           mod = 1;  
    }
	
	private void arrowsActionPerformed(java.awt.event.ActionEvent evt) {
	       mod = 0;
	      
	}
	
	
}
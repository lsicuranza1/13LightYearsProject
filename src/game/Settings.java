package game;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Settings extends javax.swing.JDialog {

	public static boolean soundEffects = true;
	public static boolean soundMusic = true;
	public static int mod;
	public boolean inGame;

	private javax.swing.JButton effects;
	private javax.swing.JLabel labelMusic;
	private javax.swing.JLabel labelEffects;
	private javax.swing.JLabel title;
	private javax.swing.JLabel labelImage;
	private javax.swing.JButton music;	
	private JRadioButton wasd;
	private JRadioButton arrows;
	
	public Settings(JFrame parent, boolean modal, boolean inGame) {
		super(parent, modal);
		this.inGame = inGame;
		initComponents();
		ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.wasd);
        buttonGroup.add(this.arrows);
       
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

		title = new javax.swing.JLabel();
		labelEffects = new javax.swing.JLabel();
		effects = new javax.swing.JButton();
		labelMusic = new javax.swing.JLabel();
		music = new javax.swing.JButton();
		labelImage = new javax.swing.JLabel();
        wasd = new javax.swing.JRadioButton();        
        arrows = new javax.swing.JRadioButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("13 Light Years");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setFont(new java.awt.Font("Gabriola", 0, 24));
		setLocation(new java.awt.Point(737, 331));
		setModalityType(null);
		setResizable(false);

		title.setFont(new java.awt.Font("Gabriola", 1, 36));
		title.setText("Settings");

		labelEffects.setFont(new java.awt.Font("Gabriola", 0, 18));
		labelEffects.setText("Sound effects");

		labelMusic.setFont(new java.awt.Font("Gabriola", 0, 18));
		labelMusic.setText("Music");

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
	        
		labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("awsd.png")));
		labelImage.setMaximumSize(new java.awt.Dimension(379, 120));
		labelImage.setMinimumSize(new java.awt.Dimension(379, 120));
		labelImage.setName("");
		labelImage.setPreferredSize(new java.awt.Dimension(379, 120));
		
		this.addWindowListener(new WindowAdapter()
	    {
	        @Override
	        public void windowClosing(WindowEvent e)
	        {
	            MenuFrame.flagSettings = false;
	            e.getWindow().dispose();
	        }
	    });

		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(168, Short.MAX_VALUE)
					.addComponent(title)
					.addGap(165))
				.addGroup(layout.createSequentialGroup()
					.addGap(25)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelImage, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(labelMusic, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(music, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(83)
							.addComponent(labelEffects)
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
					.addComponent(title)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelEffects, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(effects, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(music, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelMusic, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelImage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		 
		String textButton = this.effects.getText();
		 
        if (textButton.compareTo("ON") == 0) {	        	
        	soundEffects = false;
            this.effects.setText("OFF");         	            
        } else {
        	soundEffects = true;        	
            this.effects.setText("ON");   
        }
	}

	private void musicActionPerformed(java.awt.event.ActionEvent evt) {
		
		String textButton = this.music.getText();
		 
        if (textButton.compareTo("ON") == 0) {
        	soundMusic = false;
            MenuFrame.gameMusic.stopSound();          
            this.music.setText("OFF");
        } else {
        	soundMusic = true;
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


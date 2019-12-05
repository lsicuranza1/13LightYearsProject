package game.patterns.state;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.List;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import game.GamePanel;
import game.Missile;
import game.SpaceShip;


public class StatoInEsecuzione extends javax.swing.JFrame implements Stato, ActionListener {
 
	GamePanel gamePanel = GamePanel.getIstance();
    
    Dimension dim;
    public static Clip gameClip;
    private boolean back = false;
    public static boolean demo = false;

	ImageIcon immagineSfondo;
	
    // ridimensiono larghezza e altezza dell'immagine  
    //in base alle dimensioni della finestra menù, che ho deciso io (nuovaW e nuova H)
    private ImageIcon ridimensionaImageIcon(URL url, int nuovaW, int nuovaH) {
        ImageIcon image = new ImageIcon(url);
        Image immagineScalata = image.getImage().getScaledInstance(nuovaW, nuovaH, Image.SCALE_DEFAULT);
        return new ImageIcon(immagineScalata);
	}

    
public StatoInEsecuzione() {
        System.out.println("In esecuzione");
        
        // fisso le dimensioni della finestra  
        dim = Toolkit.getDefaultToolkit().getScreenSize();  // restituisce la dimensione dello schermo in pixel
        dim.setSize(1000, 600);  // setto larghezza e altezza, da me scelti, per la finestra Menù
        this.setPreferredSize(dim.getSize());
        
        
        // ridimensiono lo sfondo in base alle dimensioni della schermata menù
        immagineSfondo = ridimensionaImageIcon(getClass().getResource("../../../resources/images/background-space.png"), dim.width, dim.height);
        
        initComponents();
      
        sfondo.setPreferredSize(dim.getSize());
        sfondo.setIcon(immagineSfondo);


    }

 
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    jPanel1 = new javax.swing.JPanel();
    panel2 = new javax.swing.JPanel();
    sfondo = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("13 Light Years");
    setName(""); // NOI18N
    setPreferredSize(new java.awt.Dimension(1000, 600));
    setResizable(false);
    
    panel2.setAlignmentX(0.0F);
    panel2.setMinimumSize(new java.awt.Dimension(1000, 600));
    panel2.setName(""); // NOI18N
    panel2.setOpaque(false);
    panel2.setPreferredSize(dim.getSize());
    panel2.setLayout(new java.awt.GridBagLayout());
    

    jPanel1.setAlignmentX(0.0F);
    jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
    jPanel1.setName(""); // NOI18N
    jPanel1.setOpaque(false);
    jPanel1.setPreferredSize(dim.getSize());
    jPanel1.setLayout(new java.awt.GridBagLayout());

    
    
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 148;
    gridBagConstraints.ipady = 32;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(269, 70, 0, 695);
    

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 148;
    gridBagConstraints.ipady = 32;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(18, 70, 0, 695);


    sfondo.setMaximumSize(new java.awt.Dimension(1000, 1000));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getRootPane());
    getRootPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );

    jPanel1.getAccessibleContext().setAccessibleName("");
    jPanel1.getAccessibleContext().setAccessibleDescription("");

    pack();
}// </editor-fold>//GEN-END:initComponents	

    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JLabel sfondo;
	
    @Override
	public void gestioneStato(Modalita modalita, String stato) {
		// TODO Auto-generated method stub
		if (stato.equals("pausa"))
			modalita.setStatoModalita(new StatoPausa());
		else if(stato.equals("game_over"))
			modalita.setStatoModalita(new StatoGameOver());
	}
 
}

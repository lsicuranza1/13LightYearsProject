package game.patterns.state;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import game.MainFrame;
import game.Settings;

public class StatoStart extends javax.swing.JFrame implements Stato {
	
	MainFrame mainFrame = MainFrame.getIstance();
    
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    public static Clip gameClip;
    private boolean back = false;
    public static boolean demo = false;
    
    double width = dim.getWidth();
	double height = dim.getHeight();
	
	int w= (int)((width*40)/100);
	int h= (int)((height*90)/100);

    // ridimensiono larghezza e altezza dell'immagine  
    //in base alle dimensioni della finestra menù, che ho deciso io (nuovaW e nuova H)
    private ImageIcon ridimensionaImageIcon(URL url, int nuovaW, int nuovaH) {
        ImageIcon image = new ImageIcon(url);
        Image immagineScalata = image.getImage().getScaledInstance(nuovaW, nuovaH, Image.SCALE_DEFAULT);
        return new ImageIcon(immagineScalata);
    }

    /**
     * Creates new form NewJFrame
     */
    public StatoStart() {
        
        // logo del gioco
        Image iconaFrame;
        iconaFrame = new ImageIcon(getClass().getResource("../../../resources/images/logo_game.png")).getImage();
        this.setIconImage(iconaFrame);
        // fisso le dimensioni della finestra  Menù a partire da quelle dinamiche dello schermo del pc
        //dim = Toolkit.getDefaultToolkit().getScreenSize();  // restituisce la dimensione dello schermo in pixel
        dim.setSize(w, h);  // setto larghezza e altezza, da me scelti, per la finestra Menù
        this.setPreferredSize(dim.getSize());
        
        
        // ridimensiono lo sfondo in base alle dimensioni della schermata menù
        ImageIcon immagineSfondo = ridimensionaImageIcon(getClass().getResource("../../../resources/images/sfondo_menu.png"), dim.width, dim.height);
        
        // Gif della Terra
        //nt w = new ImageIcon(getClass().getResource("/images/solar_system.gif")).getIconWidth() * 1/3;
        //int h = new ImageIcon(getClass().getResource("/images/solar_system.gif")).getIconHeight() * 1/3;
        //ImageIcon gif = ridimensionaImageIcon(getClass().getResource("/images/solar_system.gif"), w, h);
        
        // Gif del Sistema Solare
        //w = new ImageIcon(getClass().getResource("/images/solar_system.gif")).getIconWidth() * 1 / 3;
        //h = new ImageIcon(getClass().getResource("/images/solar_system.gif")).getIconHeight() * 1 / 3;
        //ImageIcon gif2 = ridimensionaImageIcon(getClass().getResource("/images/solar_system.gif"), w, h);
       
       
        //int w = new ImageIcon(getClass().getResource("/images/LogoSfondoBianco.png")).getIconWidth() * 1 / 3;
        //int h = new ImageIcon(getClass().getResource("/images/LogoSfondoBianco.png")).getIconHeight() * 1 / 3;
        //ImageIcon immagineLogo = ridimensionaImageIcon(getClass().getResource("/images/LogoSfondoBianco.png"), w, h);  
       
        initComponents();
      
        sfondo.setPreferredSize(dim.getSize());
        sfondo.setIcon(immagineSfondo);
        
        
    
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("13 Light Years");
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(w, h));
        setResizable(false);

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setMinimumSize(new java.awt.Dimension(w, h));
        jPanel1.setName(""); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(dim.getSize());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButton2.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jButton2.setText("Play");
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

        jButton3.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jButton3.setText("Scoreboard");
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

        jButton4.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jButton4.setText("Settings");
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

        jButton5.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jButton5.setText("Demo");
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

        sfondo.setMaximumSize(new java.awt.Dimension(1000, 1000));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    	//gamePanel.updateModalita("game_over");

    	mainFrame.updateModalita("in_esecuzione");
    	
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    	System.out.println("ciao");
    	mainFrame.updateModalita("game_over");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Settings set = new Settings(this, true, false);
        set.setVisible(true);
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    	System.out.println("ciao");
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NewJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
    
	
	
	@Override
	public void gestioneStato(Modalita modalita, String stato) {
		if (stato.equals("in_esecuzione")) {
			modalita.setStatoModalita(new StatoInEsecuzione());
			mainFrame.getFrame().setVisible(false);
			mainFrame.setFrame(new StatoInEsecuzione());
			mainFrame.getFrame().setVisible(true);
			mainFrame.getFrame().setTitle("13 Light Years");
		//TODO togliere;
			
		}else if (stato.equals("game_over")) {
			modalita.setStatoModalita(new StatoGameOver());
			mainFrame.getFrame().setVisible(false);
			mainFrame.setFrame(new StatoGameOver());
			mainFrame.getFrame().setVisible(true);
			mainFrame.getFrame().setTitle("13 Light Years");
			
		}
		
	}

 
}

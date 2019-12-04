package game.patterns.state;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.MainFrame;
import game.Missile;
import game.SpaceShip;


public class StatoInEsecuzione extends javax.swing.JFrame implements Stato {
 
	MainFrame mainFrame = MainFrame.getIstance();
	private SpaceShip spaceShip;
	private JPanel panel = new JPanel();
	private JButton button = new JButton();
    
public StatoInEsecuzione() {
        System.out.println("In esecuzione");
//        spaceShip = new SpaceShip(100,100);
//        panel.setSize(200, 200);
//        panel.setBackground(Color.black);
//        panel.setVisible(true);
        
//        mainFrame.getFrame().setLayout(new BorderLayout());
//        mainFrame.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        panel.setBackground(Color.RED);
//        mainFrame.getFrame().add(panel, BorderLayout.CENTER);
//        mainFrame.getFrame().setVisible(true);
        
        JFrame frame = new JFrame();
		frame.add(button);
		mainFrame.setFrame(frame);
        
        
    }

private void doDrawing(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;
    
    g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
            spaceShip.getY(), this);

    List<Missile> missiles = spaceShip.getMissiles();

    for (Missile missile : missiles) {
        
        g2d.drawImage(missile.getImage(), missile.getX(),
                missile.getY(), this);
    }
}


    @Override
	public void gestioneStato(Modalita modalita, String stato) {
		// TODO Auto-generated method stub
		if (stato.equals("pausa"))
			modalita.setStatoModalita(new StatoPausa());
		else if(stato.equals("game_over"))
			modalita.setStatoModalita(new StatoGameOver());
	}
 
}

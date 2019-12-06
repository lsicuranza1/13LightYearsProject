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
import java.awt.event.KeyListener;
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
import game.PanelEsecuzione;
import game.SpaceShip;


public class StatoInEsecuzione extends javax.swing.JFrame implements Stato{
 
	MainFrame mainFrame = MainFrame.getIstance();
	//private SpaceShip spaceShip = new SpaceShip(100,100,"/13LightYearsProject/src/resources/images/spaceship.png");
	private PanelEsecuzione panel = new PanelEsecuzione();

    //private SpaceShip ship;
    
	public StatoInEsecuzione() {
        System.out.println("In esecuzione");
        
        //mainFrame.getFrame().setLayout(new BorderLayout());
        //mainFrame.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.BLACK);
        panel.setSize(600, 600);
        //mainFrame.getFrame().add(panel, BorderLayout.CENTER);
        mainFrame.getFrame().setSize(600, 600);
        mainFrame.getFrame().setVisible(true);
        mainFrame.getFrame().add(panel);
        //ship = new SpaceShip(300, 300);
        panel.setFocusable(true);
        panel.requestFocus();
        
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

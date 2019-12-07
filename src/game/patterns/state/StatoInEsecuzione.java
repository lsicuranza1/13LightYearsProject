package game.patterns.state;

import java.awt.Color;

import game.MainFrame;
import game.PanelEsecuzione;


@SuppressWarnings("serial")
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
        panel.setSize(1000, 600);
        //mainFrame.getFrame().add(panel, BorderLayout.CENTER);
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

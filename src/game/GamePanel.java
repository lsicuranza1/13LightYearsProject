package game;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import game.patterns.state.Modalita;
import game.patterns.state.Stato;
import game.patterns.state.StatoStart;

public class GamePanel {

	private JFrame frame;
	private Modalita modalita;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	int w= (int)((width*40)/100);
	int h= (int)((height*90)/100);
	
	//Singleton
	private static GamePanel istance = null; // riferimento all' istanza
	
//	public GamePanel() {
//		initialize();
//	}
	
	public static GamePanel getIstance() {
		if (istance == null)
			istance = new GamePanel();
		return istance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePanel window = GamePanel.getIstance();
					window.setModalita(new Modalita());
					window.setFrame(new StatoStart());
					window.getFrame().setVisible(true);
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					frame.setSize(w,h);
					window.getFrame().setTitle("13 Light Years");
					window.getFrame().setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void updateModalita(String string) {
		Stato stato = modalita.getStatoModalita();
    	stato.gestioneStato(modalita, string);
	}

	public Modalita getModalita() {
		return modalita;
	}

	public void setModalita(Modalita modalita) {
		this.modalita = modalita;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

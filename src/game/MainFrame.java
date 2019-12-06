package game;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import game.patterns.state.Modalita;
import game.patterns.state.Stato;
import game.patterns.state.StatoStart;

public class MainFrame{

	private JFrame frame;
	private Modalita modalita;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	int w= (int)((width*40)/100);
	int h= (int)((height*90)/100);
	
	//Singleton
	private static MainFrame istance = null; // riferimento all' istanza
	
//	public MainFrame() {
//		initialize();
//	}
	
	public static MainFrame getIstance() {
		if (istance == null)
			istance = new MainFrame();
		return istance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = MainFrame.getIstance();
					window.setModalita(new Modalita());
					window.setFrame(new StatoStart());
					window.getFrame().setVisible(true);
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					frame.setSize(w,h);
					window.getFrame().setTitle("Menù Principale");
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

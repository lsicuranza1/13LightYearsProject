package game;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GamePanel {

	private JFrame frame;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); /*prende le dimensioni dello schermo*/
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	int w= (int)((width*40)/100);
	int h= (int)((height*90)/100);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePanel window = new GamePanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GamePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(w,h);
		frame.setTitle("13 Light Years");
		frame.setLocationRelativeTo(null);
		
	}

}

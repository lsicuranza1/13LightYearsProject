package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelEsecuzione extends JPanel implements ActionListener{
	private String fileName;
	public SpaceShip spaceShip;
	private Level level;
    private final int DELAY = 20;
    private Timer timer;
	
	
	public PanelEsecuzione() {
		
		addKeyListener(new TAdapter());
        setFocusable(false);
        
        fileName = "../resources/images/spaceship.png";
        spaceShip = new SpaceShip(100,100,fileName);
        
        level = new Level(this);
        
        timer = new Timer(DELAY, this);
        timer.start();
	}
	

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
                spaceShip.getY(), this);
        level.paintComponent(g2d);
        
        List<Missile> missiles = spaceShip.getMissiles();

        for (Missile missile : missiles) {
            
            g2d.drawImage(missile.getImage(), missile.getX(),
                    missile.getY(), this);
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
		this.updateSpaceShip();
		this.updateMissiles();
        this.repaint();
        //System.out.println("ActionPerformed");
    }
    
    private void updateMissiles() {

        List<Missile> missiles = spaceShip.getMissiles();

        for (int i = 0; i < missiles.size(); i++) {

            Missile missile = missiles.get(i);

            if (missile.isVisible()) {
            	
                missile.move();
            } else {

                missiles.remove(i);
            }
        }
    }
    
    public void updateSpaceShip() {
    	spaceShip.move();
    }
    
    
    public class TAdapter extends KeyAdapter{
	    @Override
	    public void keyReleased(KeyEvent e) {
	        spaceShip.keyReleased(e);
	    }
	
	    @Override
	    public void keyPressed(KeyEvent e) {
	        spaceShip.keyPressed(e);
	    }
    }

}

package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class PanelProva extends JPanel implements ActionListener{
	private String fileName = "../resources/images/spaceship.png";
	public SpaceShip spaceShip = new SpaceShip(100,100,fileName);
	
	
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

      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
		this.updateSpaceShip();
        //this.repaint();
        System.out.println("ActionPerformed");
    }
    
//    private void updateMissiles() {
//
//        List<Missile> missiles = spaceShip.getMissiles();
//
//        for (int i = 0; i < missiles.size(); i++) {
//
//            Missile missile = missiles.get(i);
//
//            if (missile.isVisible()) {
//
//                missile.move();
//            } else {
//
//                missiles.remove(i);
//            }
//        }
//    }

    public void updateSpaceShip() {
        System.out.println("update");
    	spaceShip.move();
    }

}

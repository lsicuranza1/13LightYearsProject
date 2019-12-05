package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelProva extends JPanel implements ActionListener{
	
	private final int ICRAFT_X = 100;
    private final int ICRAFT_Y = 600;
    private final int DELAY = 20;
    private Timer timer;
    private SpaceShip spaceShip;

    public PanelProva() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
//        setBackground(Color.BLACK);
//        setFocusable(true);

        spaceShip = new SpaceShip(100, 100);
        
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

//        List<Missile> missiles = spaceShip.getMissiles();
//
//        for (Missile missile : missiles) {
//            
//            g2d.drawImage(missile.getImage(), missile.getX(),
//                    missile.getY(), this);
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        updateMissiles();
        updateSpaceShip();

        repaint();
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

        spaceShip.move();
    }

    private class TAdapter extends KeyAdapter {

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

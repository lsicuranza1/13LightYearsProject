package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelEsecuzione extends JPanel implements ActionListener{
	private String fileName, enemyName;
	public SpaceShip spaceShip;
    private final int DELAY = 20;
    private Timer timer;

    private List<EnemiesSpaceShip> enemies;
    Random random = new Random();
    

	public PanelEsecuzione() {
		
		addKeyListener(new TAdapter());
        setFocusable(false);
        
        fileName = "../resources/images/spaceship.png";
        spaceShip = new SpaceShip(100,100,fileName);
        
     
        enemies = new ArrayList<>();
        
        //creiamo 10 nemici. poniamo lo spazio tra le navicelle 
        for(int i = 0; i<15; i++) {
        	int rand = random.nextInt(1000);
        	EnemiesSpaceShip enemy = new EnemiesSpaceShip( getX()+70*i, getY()+rand,  "../resources/images/firstEnemy.png");
        	enemies.add(enemy);
        	
        }
        
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
        
        Graphics2D g_en = (Graphics2D) g;
        Graphics2D g_bom = (Graphics2D) g;
        
        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
                spaceShip.getY(), this);
        
        
        for(EnemiesSpaceShip enemy : enemies) {
        	g_en.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
        	
        }
        for(EnemiesSpaceShip enemy : enemies) {
        	EnemiesSpaceShip.Bomb  bomb =  enemy.getBomb();
        	g_bom.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
        }

        

        		
        
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
        
        for(EnemiesSpaceShip enemy : enemies) {
        	EnemiesSpaceShip.Bomb bomb = enemy.getBomb();
        	
        	
        	if(bomb.getY()>650) {
        		bomb.setY(enemy.getY()+20);
        		bomb.setX(enemy.getX()+10);
        	}
        	bomb.move();
        }
        

    }
    
    public void updateSpaceShip() {
    	spaceShip.move();

    	
    	Iterator<EnemiesSpaceShip> et = enemies.iterator();
    	while(et.hasNext()) {
    		EnemiesSpaceShip enemy = et.next();
    		int y = enemy.getY();
    		enemy.move();
    	}
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

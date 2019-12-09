package game;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

public class Level {
	
    String fileName_asteroid = "../resources/images/asteroid-icon.png";
    String fileName_meteorite = "../resources/images/fiery-meteorite-icon.png";
    private static final int D_W = 1000;
    private static final int D_H = 600;
    List<Asteroid> asteroids;
    List<Meteorite> meteorites;
    Random random = new Random();
    int countToAddAsteroid = 0;
    int countToAddMeteorite = 0;
    int y_asteroid;
    int y_meteorite;
    PanelEsecuzione levelPanel;
    
    public Level(PanelEsecuzione panel) {
    	this.levelPanel = panel;
        asteroids = new ArrayList<>();
        meteorites = new ArrayList<>();
        //Asteroid asteroid = new Asteroid(100, y_asteroid, fileName_asteroid);
        //Meteorite meteorite = new Meteorite(100, y_meteorite, fileName_meteorite);
        y_asteroid = -1000;
        y_meteorite = -100;
        
        Timer timer = new Timer(40, new ActionListener(){
        	
            public void actionPerformed(ActionEvent e) {
            	
                if (countToAddAsteroid >= 50) {   //maggiore è il valore minore è la frequenza di uscita degli asteroidi (utile per gestione dei livelli)
                    int randX1 = random.nextInt(D_W);
                    asteroids.add(new Asteroid(randX1, y_asteroid, fileName_asteroid));
                    countToAddAsteroid = 0;
                }
                countToAddAsteroid++;
                
                if (countToAddMeteorite >= 50) {   //maggiore è il valore minore è la frequenza di uscita degli asteroidi (utile per gestione dei livelli)
                    int randX2 = random.nextInt(D_W);
                    meteorites.add(new Meteorite(randX2, y_meteorite, fileName_meteorite));
                    countToAddMeteorite = 0;
                }
                countToAddMeteorite++;
                
                Iterator<Asteroid> it_asteroids = asteroids.iterator();

                while (it_asteroids.hasNext()) {
                    Asteroid asteroid = (Asteroid)it_asteroids.next();
                    if (asteroid.getY() >= D_H) {
                        it_asteroids.remove();
                    } else {
                         asteroid.move();
                    }
                }
                levelPanel.repaint();
                
                Iterator<Meteorite> it_meteorites = meteorites.iterator();
                
                while (it_meteorites.hasNext()) {
                    Meteorite meteorites = (Meteorite)it_meteorites.next();
                    if (meteorites.getY() >= D_H) {
                        it_meteorites.remove();
                    } else {
                         meteorites.move();
                    }
                }
                levelPanel.repaint();
                
            }
            
        });
        timer.start();
    }
    
//    protected void paintComponent(Graphics2D g) {
//        //levelPanel.paintComponent(g);
//        //g.drawImage(fileName_background, 0, 0, this);
//        for (Asteroid asteroid : asteroids) {
//            asteroid.drawAsteroid(g);
//        }
//        for (Meteorite meteorite : meteorites) {
//            meteorite.drawMeteorite(g);
//        }
//    }
}

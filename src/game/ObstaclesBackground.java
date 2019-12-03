<<<<<<< HEAD
package game;
import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/* Usare AffineTrasform() per la rotazione degli asteroidi*/

public class ObstaclesBackground extends JPanel {

    private static final int D_W = 700;
    private static final int D_H = 490;
    BufferedImage asteroidImage;
    BufferedImage meteoriteImage;
    BufferedImage background;
    List<Asteroid> asteroids;
    List<Meteorite> meteorites;
    Random random = new Random();
    int countToAddAsteroid = 0;
    int countToAddMeteorite = 0;
    int y_asteroid;
    int y_meteorite;
	private Double rotationSpeed;
	private Double angle;

    public ObstaclesBackground() {
        try {
            asteroidImage = ImageIO.read(getClass().getResource("../images/asteroid-icon.png"));
            meteoriteImage = ImageIO.read(getClass().getResource("../images/fiery-meteorite-icon.png"));
            background = ImageIO.read(getClass().getResource("../images/background-space.png"));
        } catch (IOException ex) {
            Logger.getLogger(ObstaclesBackground.class.getName()).log(Level.SEVERE, null, ex);
        }
        asteroids = new ArrayList<>();
        meteorites = new ArrayList<>();
        y_asteroid = 0 - asteroidImage.getHeight();
        y_meteorite = 0 - meteoriteImage.getHeight();

        Timer timer = new Timer(40, new ActionListener(){
        	
            public void actionPerformed(ActionEvent e) {
            	
                if (countToAddAsteroid >= 20) {
                    int randX1 = random.nextInt(D_W);
                    asteroids.add(new Asteroid(ObstaclesBackground.this, asteroidImage, randX1, y_asteroid));
                    countToAddAsteroid = 0;
                }
                countToAddAsteroid++;
                
                if (countToAddMeteorite >= 20) {
                    int randX2 = random.nextInt(D_W);
                    meteorites.add(new Meteorite(ObstaclesBackground.this, meteoriteImage, randX2, y_meteorite));
                    countToAddMeteorite = 0;
                }
                countToAddMeteorite++;
                
                Iterator it_asteroids = asteroids.iterator();

                while (it_asteroids.hasNext()) {
                    Asteroid asteroid = (Asteroid)it_asteroids.next();
                    if (asteroid.y >= D_H) {
                        it_asteroids.remove();
                    } else {
                         asteroid.move();
                    }
                }
                repaint();
                
                Iterator it_meteorites = meteorites.iterator();
                
                while (it_meteorites.hasNext()) {
                    Meteorite meteorites = (Meteorite)it_meteorites.next();
                    if (meteorites.y >= D_H) {
                        it_meteorites.remove();
                    } else {
                         meteorites.move();
                    }
                }
                repaint();
            }
            
        });
        timer.start();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        for (Asteroid asteroid : asteroids) {
            asteroid.drawAsteroid(g);
        }
        for (Meteorite meteorite : meteorites) {
            meteorite.drawMeteorite(g);
        }
    }
    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public class Asteroid {
        Rectangle2D rectangle;
        Image asteroidImage;
        JPanel panel;
        int x, y;

        public Asteroid(JPanel panel, Image image, int x, int y) {
            this.panel = panel;
            this.asteroidImage = image;
            this.x = x;
            this.y = y;
    		angle = Math.random() * 360;
    		rotationSpeed = Math.random();
            rectangle = new Rectangle2D.Double(
                    x, y, image.getWidth(panel), image.getHeight(panel));
        }

        public void drawAsteroid(Graphics g) {
            g.drawImage(asteroidImage, x, y, panel);
        }

        public void move() {
            y += 3;
        }
    }
    
    public class Meteorite {
        Rectangle2D rectangle;
        Image meteoriteImage;
        JPanel panel;
        int x, y;

        public Meteorite(JPanel panel, Image image, int x, int y) {
            this.panel = panel;
            this.meteoriteImage = image;
            this.x = x;
            this.y = y;
            rectangle = new Rectangle2D.Double(
                    x, y, image.getWidth(panel), image.getHeight(panel));
        }
        
        public void drawMeteorite(Graphics g) {
            g.drawImage(meteoriteImage, x, y, panel);
        }

        public void move() {
            y += 10;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new ObstaclesBackground());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
=======
package game;
import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/* Usare AffineTrasform() per la rotazione degli asteroidi*/

public class ObstaclesBackground extends JPanel {

    private static final int D_W = 700;
    private static final int D_H = 490;
    BufferedImage asteroidImage;
    BufferedImage meteoriteImage;
    BufferedImage background;
    List<Asteroid> asteroids;
    List<Meteorite> meteorites;
    Random random = new Random();
    int countToAddAsteroid = 0;
    int countToAddMeteorite = 0;
    int y_asteroid;
    int y_meteorite;
	private Double rotationSpeed;
	private Double angle;

    public ObstaclesBackground() {
        try {
            asteroidImage = ImageIO.read(getClass().getResource("/asteroid-icon.png"));
            meteoriteImage = ImageIO.read(getClass().getResource("/fiery-meteorite-icon.png"));
            background = ImageIO.read(getClass().getResource("/background-space.png"));
        } catch (IOException ex) {
            Logger.getLogger(ObstaclesBackground.class.getName()).log(Level.SEVERE, null, ex);
        }
        asteroids = new ArrayList<>();
        meteorites = new ArrayList<>();
        y_asteroid = 0 - asteroidImage.getHeight();
        y_meteorite = 0 - meteoriteImage.getHeight();

        Timer timer = new Timer(40, new ActionListener(){
        	
            public void actionPerformed(ActionEvent e) {
            	
                if (countToAddAsteroid >= 20) {
                    int randX1 = random.nextInt(D_W);
                    asteroids.add(new Asteroid(ObstaclesBackground.this, asteroidImage, randX1, y_asteroid));
                    countToAddAsteroid = 0;
                }
                countToAddAsteroid++;
                
                if (countToAddMeteorite >= 20) {
                    int randX2 = random.nextInt(D_W);
                    meteorites.add(new Meteorite(ObstaclesBackground.this, meteoriteImage, randX2, y_meteorite));
                    countToAddMeteorite = 0;
                }
                countToAddMeteorite++;
                
                Iterator it_asteroids = asteroids.iterator();

                while (it_asteroids.hasNext()) {
                    Asteroid asteroid = (Asteroid)it_asteroids.next();
                    if (asteroid.y >= D_H) {
                        it_asteroids.remove();
                    } else {
                         asteroid.move();
                    }
                }
                repaint();
                
                Iterator it_meteorites = meteorites.iterator();
                
                while (it_meteorites.hasNext()) {
                    Meteorite meteorites = (Meteorite)it_meteorites.next();
                    if (meteorites.y >= D_H) {
                        it_meteorites.remove();
                    } else {
                         meteorites.move();
                    }
                }
                repaint();
            }
            
        });
        timer.start();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        for (Asteroid asteroid : asteroids) {
            asteroid.drawAsteroid(g);
        }
        for (Meteorite meteorite : meteorites) {
            meteorite.drawMeteorite(g);
        }
    }
    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public class Asteroid {
        Rectangle2D rectangle;
        Image asteroidImage;
        JPanel panel;
        int x, y;

        public Asteroid(JPanel panel, Image image, int x, int y) {
            this.panel = panel;
            this.asteroidImage = image;
            this.x = x;
            this.y = y;
    		angle = Math.random() * 360;
    		rotationSpeed = Math.random();
            rectangle = new Rectangle2D.Double(
                    x, y, image.getWidth(panel), image.getHeight(panel));
        }

        public void drawAsteroid(Graphics g) {
            g.drawImage(asteroidImage, x, y, panel);
        }

        public void move() {
            y += 3;
        }
    }
    
    public class Meteorite {
        Rectangle2D rectangle;
        Image meteoriteImage;
        JPanel panel;
        int x, y;

        public Meteorite(JPanel panel, Image image, int x, int y) {
            this.panel = panel;
            this.meteoriteImage = image;
            this.x = x;
            this.y = y;
            rectangle = new Rectangle2D.Double(
                    x, y, image.getWidth(panel), image.getHeight(panel));
        }
        
        public void drawMeteorite(Graphics g) {
            g.drawImage(meteoriteImage, x, y, panel);
        }

        public void move() {
            y += 10;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new ObstaclesBackground());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
>>>>>>> refs/heads/Develop
}
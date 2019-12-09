package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ScrollingBackground {

    public static void main(String[] args) {
        new ScrollingBackground();
    }

    public ScrollingBackground() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setSize(600, 700);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BackgroundPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BackgroundPanel extends JPanel {

        private BufferedImage bg;
        private int yOffset = 0;
        private int yDelta = 2;

        public BackgroundPanel() {
            try {
                bg = ImageIO.read(getClass().getResource("../resources/images/space.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Timer timer = new Timer(80, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    yOffset += yDelta;
                    if (yOffset > getHeight()) {
                        yOffset = 0;
                    }
                    repaint();;
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return bg == null ? new Dimension(600, 700) : new Dimension(600,700);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
                Graphics2D g2d = (Graphics2D) g.create();

                int xPos = (getWidth() - bg.getWidth()) / 2;
                int yPos = yOffset;

                while (yPos > 0) {
                    yPos -= bg.getHeight();
                    g2d.drawImage(bg, xPos, yPos, this);
                }

                yPos = yOffset;
                while (yPos < getHeight()) {
                    g2d.drawImage(bg, xPos, yPos, this);
                    yPos += bg.getHeight();
                }

                g2d.dispose();
            }
        }
    }
}
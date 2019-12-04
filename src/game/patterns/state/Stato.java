package game.patterns.state;

import java.awt.Graphics;

public interface Stato {
    
    public void gestioneStato(Modalita modalita, String stato);

	void paintComponent(Graphics g);
    
//    public void paintComponent(Graphics g);
}
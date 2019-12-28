/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneClassifica;



/**
 *
 * @author gruppo35
 */

public class GiocatorePresenteException extends Exception {
    private Giocatore g;
    /**
     * Creates a new instance of <code>GiocatorePresenteException</code> without
     * detail message.
     * @param g
     */
    public GiocatorePresenteException(Giocatore g) {
        this.g=g;
    	System.out.println("Costr");
    }

    /**
     *
     * @return
     */
    public Giocatore getG() {
        return g;
    }
    

    /**
     * Constructs an instance of <code>GiocatorePresenteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public GiocatorePresenteException(String msg) {
        super(msg);

    }
}

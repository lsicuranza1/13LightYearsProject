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

public class GiocatoreNonClassificatoException extends Exception {
    private Giocatore g;
    /**
     * Creates a new instance of <code>GiocatoreNonClassificatoException</code>
     * without detail message.
     * 
     * @param g
     */
    public GiocatoreNonClassificatoException(Giocatore g) {
    	System.out.println("Costr");
        this.g=g;
    }

    /**
     *
     * @return
     */
    public Giocatore getG() {
        return g;
    }
    

    /**
     * Constructs an instance of <code>GiocatoreNonClassificatoException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public GiocatoreNonClassificatoException(String msg) {
        super(msg);
    }
}

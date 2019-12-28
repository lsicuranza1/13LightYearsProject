/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneClassifica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author gruppo35
 */

public class Giocatore implements Serializable{
    private final String tagGiocatore;
    private int punteggio;
    private final LocalDate data;

    /**
     *
     * @param tagGiocatore
     */
    public Giocatore(String tagGiocatore) {
        this.tagGiocatore = tagGiocatore;
        this.punteggio = 0;
        this.data= LocalDate.now();
    }
    

    /**
     *
     * @return
     */
    public String getTagGiocatore() {
        return tagGiocatore;
    }

    /**
     *
     * @return
     */
    public int getPunteggio() {
        return punteggio;
    }
    
    /**
     *
     * @return
     */
    public String getVisibleData(){
        return data.getDayOfMonth()+"-"+data.getMonthValue()+"-"+data.getYear();
    }

    /**
     *
     * @return
     */
    public LocalDate getData() {
        return this.data ;
    }

    /**
     *
     * @param punteggio
     */
    public synchronized void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.tagGiocatore);
        hash = 89 * hash + this.punteggio;
        hash = 89 * hash + Objects.hashCode(this.data);
        return hash;
    }

    /**
     *
     * @param g
     * @return
     */
    public boolean equals(Giocatore g) {
        if(!this.getTagGiocatore().equals(g.getTagGiocatore()))
            return false;
        if(this.getPunteggio()!=g.getPunteggio())
            return false;
        return this.getVisibleData().equals(g.getVisibleData());
    }


    @Override
    public synchronized String toString() {
        return  tagGiocatore+punteggio+this.getData();
    }

    
}

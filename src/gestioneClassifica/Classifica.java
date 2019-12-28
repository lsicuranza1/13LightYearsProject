package gestioneClassifica;

import java.io.*;
import java.util.*;

/**
 *
 * @author gruppo35
 */

public class Classifica implements Serializable,Iterable<Giocatore>{
    private List<Giocatore> classifica;
    private final int maxSize;
    private final String nomeFile;

    /**
     *
     */
    public Classifica() {
        this.classifica=new ArrayList<>();
        this.maxSize=10;
        this.nomeFile="classifica.dat";
    }
    
    /**
     *
     * @param g
     * @throws GiocatorePresenteException
     * @throws GiocatoreNonClassificatoException
     */
    public synchronized void aggiungiGiocatore(Giocatore g) throws GiocatorePresenteException, GiocatoreNonClassificatoException{
        ComparatorGiocatore cg=new ComparatorGiocatore();
        for(Giocatore gtemp: this)
            if(gtemp.equals(g))
                throw new GiocatorePresenteException(g);
    			System.out.println("Eccezione");
        if(classifica.size()<this.maxSize){
            classifica.add(g);
            classifica.sort(cg);
            return;
        }
        if(classifica.get(maxSize-1).getPunteggio()<g.getPunteggio()){
                classifica.remove(maxSize-1);
                classifica.add(g);
                classifica.sort(cg); 
                return;
        }
        salvaSuFileBinario();
        throw new GiocatoreNonClassificatoException(g);

    }
    
    /**
     *
     */
    public synchronized void resetClassifica(){
        classifica.clear();
        salvaSuFileBinario();
    }
    
    /**
     *
     */
    public synchronized void salvaSuFileBinario(){
        
        try(ObjectOutputStream s=new ObjectOutputStream(new FileOutputStream(nomeFile) )) {
            s.writeObject(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }   
    }
    
    /**
     *
     */
    public void leggiDaFileBinario(){
        try(ObjectInputStream s= new ObjectInputStream(new FileInputStream(nomeFile))){
            Classifica c = (Classifica) s.readObject();
            this.classifica=c.getClassifica();
        } catch (FileNotFoundException ex) {
        	System.out.println("File not found!");           
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
	
    }
    
    @Override
    public Iterator<Giocatore> iterator() {
        return classifica.iterator();
    }
    
    /**
     *
     * @return
     */
    public List<Giocatore> getClassifica(){
        return this.classifica;
    }   
}

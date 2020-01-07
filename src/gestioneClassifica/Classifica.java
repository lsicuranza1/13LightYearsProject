package gestioneClassifica;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Classifica implements Serializable,Iterable<Giocatore>{
    private List<Giocatore> classifica;
    private final int maxSize;

    public Classifica() { 
        this.classifica=new ArrayList<>();
        this.maxSize=10;
    }
    
    //giocatorePresenteException non funziona al momento
    public void aggiungiGiocatore(Giocatore g) throws GiocatoreNonClassificatoException{
        ComparatorGiocatore cg=new ComparatorGiocatore();
//        for(Giocatore gtemp: this)
//            if(gtemp.equals(g))
//                throw new GiocatorePresenteException(g);
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
        salvaSuFileBinario("classifica.dat");
        throw new GiocatoreNonClassificatoException(g);

    }

    public void resetClassifica(){
        classifica.clear();
        salvaSuFileBinario("classifica.dat");
    }

    public void salvaSuFileBinario(String nomeFile){
        
        try(ObjectOutputStream s=new ObjectOutputStream(new FileOutputStream(nomeFile) )) {
            if(nomeFile=="classifica.dat") {
            	 s.writeObject(this);
            }else {
            	throw new IOException();
            }
        } catch (IOException e) {
        	System.out.println("Error in the file I/O");
		} 
    }

    public void leggiDaFileBinario(String nomeFile){
        try(ObjectInputStream s= new ObjectInputStream(new FileInputStream(nomeFile))){
        	if(nomeFile=="classifica.dat") {
        		Classifica c = (Classifica) s.readObject();
                this.classifica=c.getClassifica(); 
        	}
        } catch (IOException | ClassNotFoundException ex) {
           System.out.println("Error in the file I/O");
        }
	
    }
    
    @Override
    public Iterator<Giocatore> iterator() {
        return classifica.iterator();
    }

    public List<Giocatore> getClassifica(){
        return this.classifica;
    }  
}

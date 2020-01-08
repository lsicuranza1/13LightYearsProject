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
    public void aggiungiGiocatore(Giocatore g) throws GiocatoreNonClassificatoException, IOException{
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

    public void resetClassifica() throws IOException{
        classifica.clear();
        salvaSuFileBinario("classifica.dat");
    }

    public void salvaSuFileBinario(String nomeFile) throws IOException{   
		if(nomeFile=="classifica.dat") {
			ObjectOutputStream s=new ObjectOutputStream(new FileOutputStream(nomeFile));
			s.writeObject(this);
        }else {
            throw new IOException();
        }
    }

    public void leggiDaFileBinario(String nomeFile) throws IOException, ClassNotFoundException{
    	if(nomeFile=="classifica.dat") {
    		ObjectInputStream s= new ObjectInputStream(new FileInputStream(nomeFile));
    		Classifica c = (Classifica) s.readObject();
            this.classifica=c.getClassifica();
        }else {
            throw new IOException();
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


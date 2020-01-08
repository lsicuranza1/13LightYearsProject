package rankingManagement;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Scoreboard implements Serializable,Iterable<Player>{
    private List<Player> scoreboard;
    private final int maxSize;

    /**
     * 
     */
    public Scoreboard() { 
        this.scoreboard=new ArrayList<>();
        this.maxSize=10;
    }
    
    /**
     * @param g
     * @throws UnclassifiedPlayerException
     * @throws IOException
     */
    public void addPlayer(Player g) throws UnclassifiedPlayerException, IOException{
    	
        PlayerComparator cg=new PlayerComparator();
        
        if(scoreboard.size()<this.maxSize){
            scoreboard.add(g);
            scoreboard.sort(cg);
            return;
        }
        
        if(scoreboard.get(maxSize-1).getScore()<g.getScore()){
                scoreboard.remove(maxSize-1);
                scoreboard.add(g);
                scoreboard.sort(cg);  
                return;
        }
        
        save("scoreboard.dat");
        throw new UnclassifiedPlayerException(g);
        
    }

    /**
     * @throws IOException
     */
    public void resetScoreboard() throws IOException{
        scoreboard.clear();
        save("scoreboard.dat"); 
    }

    /**
     * @param fileName
     * @throws IOException
     */
    public void save(String fileName) throws IOException{
    	
		if(fileName == "scoreboard.dat") {		
			ObjectOutputStream s=new ObjectOutputStream(new FileOutputStream(fileName));
			s.writeObject(this);
			s.close();
        }else {
            throw new IOException();
        }
		
    }

    /**
     * @param fileName
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void load(String fileName) throws IOException, ClassNotFoundException{
    	
    	if(fileName == "scoreboard.dat") {
    		ObjectInputStream s= new ObjectInputStream(new FileInputStream(fileName));
    		Scoreboard c = (Scoreboard) s.readObject();
            this.scoreboard=c.getScoreboardList();
            s.close();
        }else {
            throw new IOException();
        }
    }
     
    /**
     *
     */
    @Override
    public Iterator<Player> iterator() {
        return scoreboard.iterator();
    }

    /**
     * @return
     */
    public List<Player> getScoreboardList(){
        return this.scoreboard;
    }  
}


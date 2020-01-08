package rankingManagement;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Scoreboard implements Serializable,Iterable<Player>{
    private List<Player> scoreboard;
    private final int maxSize;
    private File fileScoreBoard;

    public Scoreboard() { 
        this.scoreboard=new ArrayList<>();
        this.maxSize=10;
        this.fileScoreBoard = new File("./scoreboard.dat");
    }
    
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
        
        save();
        throw new UnclassifiedPlayerException(g);
        
    }

    public void resetScoreboard() throws IOException{
        scoreboard.clear();
        save(); 
    }

    public void save() throws IOException{
    			
		ObjectOutputStream s=new ObjectOutputStream(new FileOutputStream(fileScoreBoard));
		s.writeObject(this);
		s.close();
		
    }

    public void load() throws IOException, ClassNotFoundException{
    	
    	if (fileScoreBoard.exists()) {
			ObjectInputStream s= new ObjectInputStream(new FileInputStream(fileScoreBoard));
			Scoreboard c = (Scoreboard) s.readObject();
		    this.scoreboard=c.getScoreboardList();
		    s.close();
    	}
    }
     
    @Override
    public Iterator<Player> iterator() {
        return scoreboard.iterator();
    }

    public List<Player> getScoreboardList(){
        return this.scoreboard;
    }  
}


package rankingManagement;

import java.io.*;
import java.util.*;


public class Scoreboard implements Serializable,Iterable<Player>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Player> scoreboard;
    private final int maxSize;
    private File fileScoreBoard;

    /**
     * The constructor of the Scoreboard class
     */
    public Scoreboard() { 
        this.scoreboard=new ArrayList<>();
        this.maxSize=10;
        this.fileScoreBoard = new File("./scoreboard.dat");
    }
    
    /**
     * This method allows us to ass a player to our Scoreboard
     * @param g A player
     * @throws UnclassifiedPlayerException A player that is not entered in the scoreboard
     * @throws IOException Problem in the Input/Output
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
        
        save();
        throw new UnclassifiedPlayerException(g);
        
    } 

    /**
     * It resets the scoreboard
     * @throws IOException Problem in the Input/Output
     */
    public void resetScoreboard() throws IOException{
        scoreboard.clear();
        save(); 
    }

    /**
     * It allows us to save the scoreboard on a file
     * @throws IOException Problem in the Input/Output
     */
    public void save() throws IOException{
    			
		ObjectOutputStream s=new ObjectOutputStream(new FileOutputStream(fileScoreBoard));
		s.writeObject(this);
		s.close();
		
    }

    /**
     * It allows us to load the scoreboard from a file
     * @throws IOException Problem in the Input/Output
     * @throws ClassNotFoundException Class not found
     */
    public void load() throws IOException, ClassNotFoundException{
    	
    	if (fileScoreBoard.exists()) {
			ObjectInputStream s= new ObjectInputStream(new FileInputStream(fileScoreBoard));
			Scoreboard c = (Scoreboard) s.readObject();
		    this.scoreboard=c.getScoreboardList();
		    s.close();
    	}
    }
     
    /**
     * It returns an Iterator on the List of the players
     */
    @Override
    public Iterator<Player> iterator() {
        return scoreboard.iterator();
    }

    /**
     * It return the List of players
     * @return A List
     */
    public List<Player> getScoreboardList(){
        return this.scoreboard;
    }  
}


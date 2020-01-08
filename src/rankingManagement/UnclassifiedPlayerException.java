package rankingManagement;

public class UnclassifiedPlayerException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private Player g;

    /**
     * The constructor of the UnclassifiedPlayerException
     * @param g A player
     */ 
    public UnclassifiedPlayerException(Player g) {
        this.g=g;
    }
 
    /**
     * It return the Player
     * @return A Player
     */
    public Player getG() {
        return g;
    }

    /** 
     * It sets the message of the exception
     * @param msg A message
     */
    public UnclassifiedPlayerException(String msg) {
        super(msg);
    }
}

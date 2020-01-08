package rankingManagement;

public class UnclassifiedPlayerException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private Player g;

    /**
     * @param g
     */
    public UnclassifiedPlayerException(Player g) {
        this.g=g;
    }
 
    /**
     * @return
     */
    public Player getG() {
        return g;
    }

    /**
     * @param msg
     */
    public UnclassifiedPlayerException(String msg) {
        super(msg);
    }
}

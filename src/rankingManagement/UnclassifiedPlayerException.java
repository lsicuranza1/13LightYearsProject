package rankingManagement;

public class UnclassifiedPlayerException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private Player g;

    public UnclassifiedPlayerException(Player g) {
        this.g=g;
    }
 
    public Player getG() {
        return g;
    }

    public UnclassifiedPlayerException(String msg) {
        super(msg);
    }
}

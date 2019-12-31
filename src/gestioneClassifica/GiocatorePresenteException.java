package gestioneClassifica;

public class GiocatorePresenteException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Giocatore g;

    public GiocatorePresenteException(Giocatore g) {
        this.g=g;
    }
 
    public Giocatore getG() {
        return g;
    }

    public GiocatorePresenteException(String msg) {
        super(msg);

    }
}

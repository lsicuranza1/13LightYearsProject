package gestioneClassifica;

public class GiocatoreNonClassificatoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Giocatore g;

    public GiocatoreNonClassificatoException(Giocatore g) {
        this.g=g;
    }
 
    public Giocatore getG() {
        return g;
    }

    public GiocatoreNonClassificatoException(String msg) {
        super(msg);
    }
}

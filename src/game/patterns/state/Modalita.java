package game.patterns.state;
 
@SuppressWarnings("serial")
public class Modalita extends javax.swing.JFrame {
 
    private Stato statoModalita;
 
    public Modalita(){
        this.statoModalita = new StatoStart();
    }

	public Stato getStatoModalita() {
		return statoModalita;
	}

	public void setStatoModalita(Stato statoModalita) {
		this.statoModalita = statoModalita;
	}
 
}
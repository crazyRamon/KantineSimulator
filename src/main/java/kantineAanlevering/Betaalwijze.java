package kantineAanlevering;

public abstract class Betaalwijze {

    protected double saldo = 10;

    /** 
     * Methode om krediet te initialiseren
     * @param saldo
     */
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getSaldo() {
		return saldo;
	}

	protected void voegSaldoToe(double hoeveelheid) {
    	this.saldo += hoeveelheid;
    }
    
    /**
     * schrijft bedrag af van saldo, open voor uitbreiding i.e. omzet valideren.
     * 
     * @param hoeveelheid
     * @return of afschrijving gelukt is
     */
    protected boolean schrijfAf(double hoeveelheid) {
    	saldo -= hoeveelheid;
    	return true;
    }

	/**
     * Methode om betaling af te handelen
     *
     * @param tebetalen
     * @return Boolean om te kijken of er voldoende saldo is
     */
    public abstract void betaal(double tebetalen, Persoon klant) throws TeWeinigGeldException;
}
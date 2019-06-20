package kantineAanlevering;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen, Persoon klant) throws TeWeinigGeldException{
    	if(tebetalen > saldo) throw new TeWeinigGeldException(klant.getVoornaam() + " " + klant.getAchternaam() + " heeft te weinig geld");
        schrijfAf(tebetalen);
    }
}
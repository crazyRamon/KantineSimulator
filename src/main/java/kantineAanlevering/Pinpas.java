package kantineAanlevering;

public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     * @throws TeWeinigGeldException 
     */
    public void betaal(double tebetalen, Persoon klant) throws TeWeinigGeldException {
        if(saldo - tebetalen < kredietlimiet) throw new TeWeinigGeldException(klant.getVoornaam() + " " + klant.getAchternaam() + " heeft onvoldoende saldo");
        schrijfAf(tebetalen);
    }
}

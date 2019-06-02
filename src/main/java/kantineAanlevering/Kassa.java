package kantineAanlevering;

import java.util.Iterator;

public class Kassa {

	private int aantalArtikelen;
	private double geldInKassa;	
	private KassaRij kassaRij;
	
    /**
     * Constructor
     */
    public Kassa(KassaRij kassaRij) {
    	this.resetKassa();
        this.kassaRij = kassaRij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        aantalArtikelen += klant.getAantalArtikelen();
        geldInKassa += klant.getTotaalprijs();
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return geldInKassa;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        aantalArtikelen = 0;
        geldInKassa = 0;
    }
}
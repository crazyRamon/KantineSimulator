package kantineAanlevering;

import java.util.Iterator;

public class Kassa {

	public int aantalArtikelen;
	public double geldInKassa;	
	public int totDagKlanten;	
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
        Iterator<Artikel> it = klant.getArtikelIterator();
        while(it.hasNext()) {
        	Artikel artikel = it.next();
        	geldInKassa += artikel.getPrijs();
        	aantalArtikelen++;
        }
        totDagKlanten++;
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
        totDagKlanten = 0;
    }
    
    public KassaRij getKassaRij() {
    	return kassaRij;
    }
}
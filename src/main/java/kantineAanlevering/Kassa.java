package kantineAanlevering;

import java.util.Iterator;

public class Kassa {

	public int aantalDagArtikelen;
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
     * @param dienblad die afgerekend moet worden
     * @throws TeWeinigGeldException 
     */
    public void rekenAf(Dienblad dienblad) throws TeWeinigGeldException {
        Iterator<Artikel> it = dienblad.getArtikelIterator();
        double totaalbedrag = 0;
        int aantalArtikelen = 0;
        while(it.hasNext()) {
        	Artikel artikel = it.next();
        	totaalbedrag += artikel.getPrijs();
        	aantalArtikelen++;
        }
        
        //kijkt of een klant een kortingskaart heeft, genereerd de korting en haalt deze van het totaalBedrag af
        if(dienblad.getKlant() instanceof KortingskaartHouder) {
        	KortingskaartHouder kortingskaartHouder = (KortingskaartHouder)dienblad.getKlant();
        	double korting = totaalbedrag * (kortingskaartHouder.geefKortingsPercentage());
        	if(kortingskaartHouder.heeftMaximum() && korting > 1) korting = 1;
        	totaalbedrag -= korting;
        }
        
        //Als de klant genoeg saldo heeft kan hij/zij afrekenen
        dienblad.getKlant().setBetaalwijze(new Pinpas());
        /** if(!dienblad.getKlant().getBetaalwijze().betaal(totaalbedrag)) {
        	System.out.println("Klant " + totDagKlanten + " heeft te weinig saldo. €" + dienblad.getKlant().getBetaalwijze().getSaldo() + " v/d €" + totaalbedrag);
        } else {
	        geldInKassa += totaalbedrag;
	        aantalDagArtikelen += aantalArtikelen;	        
        } */
        dienblad.getKlant().getBetaalwijze().betaal(totaalbedrag, dienblad.getKlant());
        geldInKassa += totaalbedrag;
        aantalDagArtikelen += aantalArtikelen;
        
        totDagKlanten++;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalDagArtikelen() {
        return aantalDagArtikelen;
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
        aantalDagArtikelen = 0;
        geldInKassa = 0;
        totDagKlanten = 0;
    }
    
    public KassaRij getKassaRij() {
    	return kassaRij;
    }
}
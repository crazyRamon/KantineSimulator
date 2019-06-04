package kantineAanlevering;

public class Kantine {

    private Kassa kassa;
    private KantineAanbod aanbod;

	/**
     * Constructor
     */
    public Kantine() {
        KassaRij kassarij = new KassaRij();
        this.kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnaam) {
        Dienblad klant = new Dienblad(persoon);
        //Artikel appel = new Artikel("Appel", 0.00);
        for(String naam : artikelnaam) {
        	klant.voegToe(new Artikel(naam, 1.00));
        }
        this.kassa.getKassaRij().sluitAchteraan(klant);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     * Dit kan beter in een while loop omdat die elke keer kijkt of er nog iemand in de rij staat.
     * Wanneer er een for gebruikt wordt, wordt er maar één keer naar gekeken.
     */
    public void verwerkRijVoorKassa() {
        while(kassa.getKassaRij().erIsEenRij()) {
            this.kassa.rekenAf(this.kassa.getKassaRij().verwijderEerstePersoonInRij());
        }
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
    public double hoeveelheidGeldInKassa() {
       return this.kassa.geldInKassa;
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
    public int aantalArtikelen() {
        return this.kassa.aantalArtikelen;
    }
    
    /**
     * Deze methode geeft het aantal gepasseerde klanten.
     *
     * @return het aantal gepasseerde klanten
     */
    public int aantalKlanten() {
        return this.kassa.totDagKlanten;
    }

    /**
     * Deze methode reset de bijgehouden telling van
     * het aantal artikelen en "leegt" de inhoud van de kassa.
     */
    public void resetKassa() {
        this.kassa.resetKassa();
    }

    public KantineAanbod getAanbod() {
		return aanbod;
	}

	public void setAanbod(KantineAanbod aanbod) {
		this.aanbod = aanbod;
	}
}
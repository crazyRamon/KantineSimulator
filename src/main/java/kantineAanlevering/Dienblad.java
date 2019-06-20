package kantineAanlevering;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
	
    private Stack<Artikel> artikelen = new Stack<>();
    private Persoon klant;

    /**
     * Constructor
     * 
     * @param klant
     */
    public Dienblad(Persoon klant) {
        this.klant = klant;
    }
    
    /**
     * Lege constructor
     */
    public Dienblad() {
    	this.klant = null;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        this.artikelen.push(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
    	return artikelen.size();
    }
    
    /**
     * 
     * @param klant
     */
    public void setKlant(Persoon klant) {
    	this.klant = klant;
    }

    public Persoon getKlant() {
		return klant;
	}

	/**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalprijs() {
    	double totaalprijs = 0;
        for(Artikel artikel : artikelen) {
        	totaalprijs += artikel.getPrijs();
        }
        return totaalprijs;
    }
    
    public Iterator<Artikel> getArtikelIterator() {
    	return artikelen.iterator();
    }
    
    public int getKlantBsn() {
		return this.klant.getBsn();
	}

    /**
     * 
     * @param bsn
     */
	public void setKlantBsn(int bsn) {
		this.klant.setBsn(bsn);
	}

	public String getKlantVoornaam() {
		return this.klant.getVoornaam();
	}

	/**
	 * 
	 * @param voornaam
	 */
	public void setKlantVoornaam(String voornaam) {
		this.klant.setVoornaam(voornaam);
	}

	public String getKlantAchternaam() {
		return this.klant.getAchternaam();
	}

	/**
	 * 
	 * @param achternaam
	 */
	public void setKlantAchternaam(String achternaam) {
		this.klant.setAchternaam(achternaam);;
	}

	public String getKlantGeboortedatum() {
		return this.klant.getGeboortedatum();
	}
}


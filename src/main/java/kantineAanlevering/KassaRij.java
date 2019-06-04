package kantineAanlevering;

import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {
	
	private LinkedList<Dienblad> rij = new LinkedList<>();

    /**
     * Constructor
     * Maakt een rij aan
     */
    public KassaRij() {
    	
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        this.rij.addLast(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad verwijderEerstePersoonInRij() {
        if(erIsEenRij()) {
        	return this.rij.removeFirst();
        } else {
        	return null;
        }
    }
    
    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        if(erIsEenRij()) {
        	return this.rij.getFirst();
        } else {
        	return null;
        }
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return this.rij.size() > 0;
    }
}
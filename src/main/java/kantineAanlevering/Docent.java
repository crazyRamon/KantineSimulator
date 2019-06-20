package kantineAanlevering;

public class Docent extends Persoon implements KortingskaartHouder {
	
	private String afkorting;
	private String afdeling;

	public Docent(String afdeling, int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		super("Docent", bsn, voornaam, achternaam, geboortedatum, geslacht);
		this.genereerAfkorting();
		this.afdeling = afdeling;
	}

	public Docent() {
		super("Docent");
	}

	public String getAfkorting() {
		return afkorting;
	}

	public boolean setAfkorting(String afkorting) {
		if(afkorting.length() != 4) return false;
		this.afkorting = afkorting.toUpperCase();
		return true;
	}
	
	public void genereerAfkorting() {
		this.afkorting = (this.getAchternaam().substring(0,2) + this.getVoornaam().substring(0,2)).toUpperCase();
	}

	public String getAfdeling() {
		return afdeling;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public double geefKortingsPercentage() {
		return 0.25;
	}

	@Override
	public boolean heeftMaximum() {
		return true;
	}

	@Override
	public double geefMaximum() {
		return 1;
	}

	@Override
	public String toString() {
		return "Type: " + this.type +
				" Afkorting: " + this.getAfkorting() + 
				" Afdeling: " + this.getAfdeling() + 
				" BSN: " + this.getBsn() + 
				" Voornaam: " + this.getVoornaam() + 
				" Achternaam: " + this.getAchternaam() +
				" Geboortedatum: " + this.getGeboortedatum() +
				" Geslacht: " + this.getGeslacht();
	}

}

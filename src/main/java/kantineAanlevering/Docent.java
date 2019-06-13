package kantineAanlevering;

public class Docent extends Persoon {
	
	private String afkorting;
	private String afdeling;

	public Docent(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		super("Docent", bsn, voornaam, achternaam, geboortedatum, geslacht);
		// TODO Auto-generated constructor stub
	}

	public Docent() {
		super("Docent");
		// TODO Auto-generated constructor stub
	}

	public String getAfkorting() {
		return afkorting;
	}

	public boolean setAfkorting(String afkorting) {
		if(afkorting.length() != 4) return false;
		this.afkorting = afkorting.toUpperCase();
		return true;
	}
	
	public void genereerAfkorting(String afkorting) {
		this.afkorting = (this.getAchternaam().substring(0,2) + this.getVoornaam().substring(0,2)).toUpperCase();
	}

	public String getAfdeling() {
		return afdeling;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}

}

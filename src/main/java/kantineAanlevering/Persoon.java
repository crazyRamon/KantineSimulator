package kantineAanlevering;

public class Persoon {

	private int bsn;
	private String voornaam;
	private String achternaam;
	private Datum geboortedatum;
	private char geslacht;
		
	/**
	 * Constructor
	 * 
	 * @param bsn BSN nummer
	 * @param voornaam
	 * @param achternaam
	 * @param geboortedatum geboortedatum in dd-mm-jjjj
	 * @param geslacht geslacht (M/V)
	 */
	public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		this.bsn = bsn;
		this.voornaam = voornaam;
		this.achternaam = achternaam;		
		this.geboortedatum = geboortedatum;		
		this.setGeslacht(geslacht);
	}
	
	public Persoon() {
		bsn = 0;
		voornaam = "";
		achternaam = "";
		geboortedatum = new Datum();
		geslacht = 'O';
	}

	public int getBsn() {
		return bsn;
	}

	public void setBsn(int bsn) {
		this.bsn = bsn;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGeboortedatum() {
		if(geboortedatum.getJaar() != 0) {
			return geboortedatum.getDatumAsString();
		} else {
			return "Onbekend";
		}
	}

	public void setGeboortedatum(Datum geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public String getGeslacht() {
		switch(geslacht) {
			case 'M':
				return "Man";
			case 'V':
				return "Vrouw";
			default:
				return "Onbekend";
		}
	}

	public void setGeslacht(char geslacht) {
		if(geslacht == 'M' || geslacht == 'V') {
			this.geslacht = geslacht;
		} else {
			this.geslacht = 'O';
		}
	}
	
	@Override
	public String toString() {
		return "BSN: " + this.getBsn() + 
				" Voornaam: " + this.getVoornaam() + 
				" Achternaam: " + this.getAchternaam() +
				" Geboortedatum: " + this.getGeboortedatum() +
				" Geslacht: " + this.getGeslacht();
	}
	
}

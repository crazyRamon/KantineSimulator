package kantineAanlevering;

public abstract class Persoon {

	protected String type;
	private int bsn;
	private String voornaam;
	private String achternaam;
	private Datum geboortedatum;
	private char geslacht;
	private Betaalwijze betaalwijze;
		
	/**
	 * Constructor
	 * 
	 * @param bsn BSN nummer
	 * @param voornaam
	 * @param achternaam
	 * @param geboortedatum geboortedatum in dd-mm-jjjj
	 * @param geslacht geslacht (M/V)
	 */
	public Persoon(String type, int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		this.bsn = bsn;
		this.voornaam = voornaam;
		this.achternaam = achternaam;		
		this.geboortedatum = geboortedatum;		
		this.setGeslacht(geslacht);
	}
	
	public Persoon() {
		type = "onbekend";
		bsn = 0;
		voornaam = "";
		achternaam = "";
		geboortedatum = new Datum();
		geslacht = 'O';
	}
	
	public Persoon(String type) {
		this.type = type;
		bsn = 0;
		voornaam = "";
		achternaam = "";
		geboortedatum = new Datum();
		geslacht = 'O';
	}
	
	public abstract String getType();

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

	public Betaalwijze getBetaalwijze() {
		return betaalwijze;
	}

	public void setBetaalwijze(Betaalwijze betaalwijze) {
		this.betaalwijze = betaalwijze;
	}

	@Override
	public abstract String toString();
	
}

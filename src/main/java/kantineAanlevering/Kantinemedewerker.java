package kantineAanlevering;

public class Kantinemedewerker extends Persoon implements KortingskaartHouder {
	
	private int medewerkersnummer;
	private boolean magAchterKassaStaan;

	public Kantinemedewerker(int medewerkersnummer, boolean magAchterKassaStaan, int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		super("Kantinemedewerker", bsn, voornaam, achternaam, geboortedatum, geslacht);
		this.medewerkersnummer = medewerkersnummer;
		this.magAchterKassaStaan = magAchterKassaStaan;
	}

	public Kantinemedewerker() {
		super("Kantinemedewerker");
		// TODO Auto-generated constructor stub
	}

	public int getMedewerkersnummer() {
		return medewerkersnummer;
	}

	public void setMedewerkersnummer(int medewerkersnummer) {
		this.medewerkersnummer = medewerkersnummer;
	}

	public boolean getMagAchterKassaStaan() {
		return magAchterKassaStaan;
	}

	public void setMagAchterKassaStaan(boolean magAchterKassaStaan) {
		this.magAchterKassaStaan = magAchterKassaStaan;
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public double geefKortingsPercentage() {
		return 0.35;
	}

	@Override
	public boolean heeftMaximum() {
		return false;
	}

	@Override
	public double geefMaximum() {
		return 0;
	}

	@Override
	public String toString() {
		return "Type: " + this.getType() +
				" Medewerkersnummer: " + this.getMedewerkersnummer() + 
				" MagAchterKassaStaan: " + this.getMagAchterKassaStaan() + 
				" BSN: " + this.getBsn() + 
				" Voornaam: " + this.getVoornaam() + 
				" Achternaam: " + this.getAchternaam() +
				" Geboortedatum: " + this.getGeboortedatum() +
				" Geslacht: " + this.getGeslacht();
	}
	
}

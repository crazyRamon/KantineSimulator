package kantineAanlevering;

public class Kantinemedewerker extends Persoon {
	
	private int medewerkersnummer;
	private boolean magAchterKassaStaan;

	public Kantinemedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		super("Kantinemedewerker", bsn, voornaam, achternaam, geboortedatum, geslacht);
		// TODO Auto-generated constructor stub
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

	public boolean isMagAchterKassaStaan() {
		return magAchterKassaStaan;
	}

	public void setMagAchterKassaStaan(boolean magAchterKassaStaan) {
		this.magAchterKassaStaan = magAchterKassaStaan;
	}
	
}

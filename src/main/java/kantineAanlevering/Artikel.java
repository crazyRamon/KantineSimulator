package kantineAanlevering;
public class Artikel {
	
	private String naam;
	private float prijs;
	
	/**
	 * Cunstructor
	 * 
	 * @param naam
	 * @param prijs
	 */
	public Artikel(String naam, float prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}
	
	public Artikel() {
		this.naam = "";
		this.prijs = 0;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public float getPrijs() {
		return prijs;
	}
	
	/**
	 * 
	 * @param naam
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	/**
	 * 
	 * @param prijs
	 */
	public void setPrijs(float prijs) {
		this.prijs = prijs;
	}
	
	@Override
	public String toString() {
		return "Naam: " + this.getNaam() +
				" Prijs: " + this.getPrijs();
	}
}

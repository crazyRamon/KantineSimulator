package kantineAanlevering;

public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
   * Constructor
   * 
   * @param dag
   * @param maand
   * @param jaar
   */
	public Datum(int dag, int maand, int jaar) {
		this();
		if(bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}
	
	/**
	 * data loze constructor	
	 */
	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}
	/**
	* @param dag
	* @param maand
	* @param jaar
	*/
	public boolean bestaatDatum(int dag, int maand, int jaar){

		if(dag < 1 || dag > 31 || //test dag
			maand < 1 || maand > 12 || //test maand
			jaar < 1900 || jaar > 2100) //test jaar
			return false;
		switch(maand) {
			//wanneer maand 4, 6, 9 of 11 is kan er geen dag 31 zijn
			case 4:
			case 6:
			case 9:
			case 11:
				if(dag == 31) return false;
				break;
			//wanneer maand 2 is kan hij alleen tot en met dag 28 of 29 gaan ivm schrikkeljaar
			case 2:
				//schrikkeljaar bepalen en correcte boolean returnen want dit is de laatste test voor een valide datum
				if((jaar % 100 != 0 || jaar % 400 == 0) && jaar % 4 != 0 ) {
					return dag <= 28;
				} else {
					return dag <= 29;
				}
		}
		return true;
		
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "placeholder";
	}	

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
}

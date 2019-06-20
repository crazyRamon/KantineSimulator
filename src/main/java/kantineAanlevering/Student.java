package kantineAanlevering;

public class Student extends Persoon {
	
	private int studentennummer;
	private String studierichting;

	public Student(int studentennummer, String studierichting, int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		super("Student", bsn, voornaam, achternaam, geboortedatum, geslacht);
		this.studentennummer = studentennummer;
		this.studierichting = studierichting;
	}

	public Student() {
		super("Student");
	}

	public int getStudentennummer() {
		return studentennummer;
	}

	public void setStudentennummer(int studentennummer) {
		this.studentennummer = studentennummer;
	}

	public String getStudierichting() {
		return studierichting;
	}

	public void setStudierichting(String studierichting) {
		this.studierichting = studierichting;
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Type: " + this.type +
				" Studentennummer: " + this.getStudentennummer() + 
				" Studierichting: " + this.getStudierichting() + 
				" BSN: " + this.getBsn() + 
				" Voornaam: " + this.getVoornaam() + 
				" Achternaam: " + this.getAchternaam() +
				" Geboortedatum: " + this.getGeboortedatum() +
				" Geslacht: " + this.getGeslacht();
	}

}

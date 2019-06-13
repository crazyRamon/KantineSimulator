package kantineAanlevering;

public class Student extends Persoon {
	
	private int studentennummer;
	private String studierichting;

	public Student(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		super("Student", bsn, voornaam, achternaam, geboortedatum, geslacht);
		// TODO Auto-generated constructor stub
	}

	public Student() {
		super("Student");
		// TODO Auto-generated constructor stub
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

}

package kantineAanlevering;

public class TeWeinigGeldException extends Exception {

	public TeWeinigGeldException() {
		System.out.println("Klant heeft te weinig geld");
	}
	
	public TeWeinigGeldException(Exception e) {
		System.out.println("Klant heeft te weinig geld " + e);
	}
	
	public TeWeinigGeldException(String message) {
		System.out.println(message);
	}
	
}

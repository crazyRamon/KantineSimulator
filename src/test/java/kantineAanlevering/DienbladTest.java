package kantineAanlevering;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DienbladTest {

	@Test
	void test() {
		Dienblad dienblad = new Dienblad();
		Artikel artikel = new Artikel("Appel", 1.50);
		dienblad.voegToe(artikel);
	}

}

package kantineAanlevering;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersoonTest {

	@Test
	void test() {
		Persoon testPersoon = new Persoon(1234567890, "Ramon", "Kits", new Datum(1, 12, 1999), 'M');
		assertEquals(testPersoon.toString(), "BSN: 1234567890 Voornaam: Ramon Achternaam: Kits Geboortedatum: placeholder Geslacht: Man");
	}

}

package kantineAanlevering;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DatumTest {

	@Test
	void test() {
		Datum datum = new Datum();
		boolean input = datum.bestaatDatum(29, 2, 2012);
		boolean eOutput = true;
		assertEquals(input, eOutput);
	}
	
	@Test
	void test2() {
		Datum datum = new Datum();
		boolean input = datum.bestaatDatum(31, 11, 2012);
		boolean eOutput = false;
		assertEquals(input, eOutput);
	}
	
	@Test
	void test3() {
		Datum datum = new Datum();
		boolean input = datum.bestaatDatum(1, 1, 1800);
		boolean eOutput = false;
		assertEquals(input, eOutput);
	}
	
	@Test
	void test4() {
		Datum datum = new Datum(12, 4, 2044);
		String str = datum.getDatumAsString();
		boolean eOutput = false;
		assertEquals(str, "placeholder");
	}

}

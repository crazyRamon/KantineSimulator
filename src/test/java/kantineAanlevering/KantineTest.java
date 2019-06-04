package kantineAanlevering;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KantineTest {

	@Test
	void test() {
		Kantine kantine = new Kantine();
		kantine.loopPakSluitAan();
	}

}

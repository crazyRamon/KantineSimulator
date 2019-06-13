package kantineAanlevering;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class AdministratieTest {

	@Test
	void test() {
		//Administratie ad = new Administratie();
		System.out.println(Administratie.berekenGemiddeldAantal(new int[] {45, 56, 34, 39, 40, 31}));
		System.out.println(Administratie.berekenGemiddeldeOmzet(new double[] {567.70, 498.25, 458.90}));
		System.out.println(Arrays.toString(Administratie.berekenDagOmzet(new double[] {321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35})));
	}

}

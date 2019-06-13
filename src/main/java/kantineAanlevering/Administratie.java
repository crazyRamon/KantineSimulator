package kantineAanlevering;

import java.util.Arrays;

public class Administratie {
	
	private final static int DAYS_IN_WEEK = 7;

    private Administratie() {    	
    }
	
	/**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
    	int sum = 0;
        for(int i = 0; i < aantal.length; i++) {
        	sum += aantal[i];
        }
        double average = (double)sum / aantal.length;
        return average;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
    	double sum = 0;
        for(int i = 0; i < omzet.length; i++) {
        	sum += omzet[i];
        }
        double average = sum / omzet.length;
        return average;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {        	
            int j = 0;
            while(omzet.length - j * DAYS_IN_WEEK > i) {
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;
            }
        }
        return temp;
    }
}

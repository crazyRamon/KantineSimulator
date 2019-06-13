package kantineAanlevering;

import java.util.ArrayList;
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
    public static double berekenGemiddeldAantal(ArrayList<Integer> aantal) {
    	if(aantal.size() == 0) return 0;
    	int sum = 0;
        for(int i = 0; i < aantal.size(); i++) {
        	sum += aantal.get(i);
        }
        double average = (double)sum / aantal.size();
        return average;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(ArrayList<Double> omzet) {
    	if(omzet.size() == 0) return 0;
    	double sum = 0;
        for(int i = 0; i < omzet.size(); i++) {
        	sum += omzet.get(i);
        }
        double average = sum / omzet.size();
        return average;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(ArrayList<Double> omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {        	
            int j = 0;
            while(omzet.size() - j * DAYS_IN_WEEK > i) {
                temp[i] += omzet.get(i + DAYS_IN_WEEK * j);
                j++;
            }
        }
        return temp;
    }
}

package kantineAanlevering;

import java.util.*;

public class KantineSimulatie_2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;
    
    //dag statestieken opslaan
    ArrayList<Double> dagOmzet = new ArrayList<>();
    ArrayList<Integer> dagAfzet = new ArrayList<>();

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
        {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;
    
    //aantal dagen van de simulatie
    public static final int DAGEN = 14;

    /**
     * Constructor
     *
     */
    public KantineSimulatie_2() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
            AANTAL_ARTIKELEN,
            MIN_ARTIKELEN_PER_SOORT,
            MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
            artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for(int i = 0; i < lengte ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     * + 1 want standaard bagint nextInt() vanaf 1 maar je wilt 0 als minimale waarde als min = 0;
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for(int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

        	System.out.println("-----Dag " + (i + 1) + "-----");
        	
            // bedenk hoeveel klanten vandaag binnen lopen
            int aantalKlanten = getRandomValue(0, 100);
            //int aantalKlanten = get100;

            // laat de klanten maar komen...
            for(int j = 0; j < aantalKlanten; j++) {
            	
            	int randomPercentage = random.nextInt(100);
            	Persoon klant = null;
            	
            	if(randomPercentage < 1) {
            		klant = new Kantinemedewerker(1007, true, 1234567890, "Ramon", "Kits", new Datum(1, 12, 1999), 'M');
            	} else if(randomPercentage < 10) {
            		klant = new Docent("ICT", 1234567890, "Ramon", "Kits", new Datum(1, 12, 1999), 'M');
            	} else if(randomPercentage < 100) {
            		klant = new Student(389517, "HBO-ICT", 1234567890, "Ramon", "Kits", new Datum(1, 12, 1999), 'M');
            	}
            	            	            	
                // maak klant en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(1, 5) ;

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                    aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                
                kantine.loopPakSluitAan(klant, artikelen);

            }

            // verwerk rij voor de kassa

            try {
				kantine.verwerkRijVoorKassa();
			} catch (TeWeinigGeldException e) {
				e.printStackTrace();
			}
            
            //voeg dagomzet en dagafzet toe
            dagOmzet.add(kantine.hoeveelheidGeldInKassa());
            dagAfzet.add(kantine.aantalDagArtikelen());
            
            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen

            System.out.println("Aantal artikelen: " + kantine.aantalDagArtikelen());
            System.out.println("Omzet: �" + String.format("%.2f", kantine.hoeveelheidGeldInKassa()));
            System.out.println("Aantal klanten: " + kantine.aantalKlanten());
            System.out.println();

            // reset de kassa voor de volgende dag

            kantine.resetKassa();
        }
        
        System.out.println("Gemiddelde dagomzet: �" + String.format("%.2f",Administratie.berekenGemiddeldeOmzet(dagOmzet)));
        System.out.println("Gemiddelde dagafzet: " + Math.round(Administratie.berekenGemiddeldAantal(dagAfzet)));
        System.out.println();
        System.out.println("Totaal dagomzet per weekdag");
        double[] weekdagOmzet = Administratie.berekenDagOmzet(dagOmzet);
        System.out.println("Maandag: �" + String.format("%.2f", weekdagOmzet[0]));
        System.out.println("Dinsdag: �" + String.format("%.2f", weekdagOmzet[1]));
        System.out.println("Woensdag: �" + String.format("%.2f", weekdagOmzet[2]));
        System.out.println("Donderdag: �" + String.format("%.2f", weekdagOmzet[3]));
        System.out.println("Vrijdag: �" + String.format("%.2f", weekdagOmzet[4]));
        System.out.println("Zaterdag: �" + String.format("%.2f", weekdagOmzet[5]));
        System.out.println("Zondag: �" + String.format("%.2f", weekdagOmzet[6]));
    }
    
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_2 sim = new KantineSimulatie_2();
        sim.simuleer(dagen);
    }
}
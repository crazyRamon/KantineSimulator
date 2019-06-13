package kantineAanlevering;

public class KantineSimulatie_1 {

    private static Kantine kantine;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public KantineSimulatie_1() {
        kantine = new Kantine();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
    	
    	String[] artikels = {"Appel", "Peer"};

        for(int i = 0; i < dagen; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for(int j = 0; j < 10 + i; j++){
                kantine.loopPakSluitAan(new Student(), artikels);
            }

            // verwerk rij voor de kassa
            
            kantine.verwerkRijVoorKassa();

            // toon dagtotalen (artikelen en geld in kassa)
            
            System.out.println("Aantal artikelen: " + kantine.aantalArtikelen());
            System.out.println("Omzet: €" + String.format("%.2f",kantine.hoeveelheidGeldInKassa()));

            // reset de kassa voor de volgende dag
            
            kantine.resetKassa();
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_1 sim = new KantineSimulatie_1();
        sim.simuleer(dagen);
    }
}
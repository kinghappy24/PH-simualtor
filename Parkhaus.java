import java.util.List;
import java.util.ArrayList;

public class Parkhaus {
    private final int anzahlParkplaetze;
    private final List<Schranke> schranken;
    private final List<Kasse> kassen;
    private final ArrayList<Fahrzeug> fahrzeuge;

    public Parkhaus(int anzahlParkplaetze, List<Schranke> schranken, List<Kasse> kassen) {
        this.anzahlParkplaetze = anzahlParkplaetze;
        this.schranken = schranken;
        this.kassen = kassen;
        this.fahrzeuge = new ArrayList<>();
    }

    public Ticket ticketErstellen(Fahrzeug fahrzeug) throws InterruptedException {
        System.out.println("Wird geschaut, ob es einen freien Platz gibt...");
        Thread.sleep(3000);

        int freiePlaetze = (int) (Math.random() * 12);

        if (freiePlaetze > 0) {
            System.out.println("Es gibt " + freiePlaetze + " freie Plätze. Ticket ziehen? (ziehen/aufwiedersehen)");
            fahrzeuge.add(fahrzeug);
            return new Ticket(2);
        } else {
            System.out.println("Leider gibt es keine freien Plätze. Aufwiedersehen.");
            return null;
        }
    }
}

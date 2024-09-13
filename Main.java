import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Schranke> schrankenListe = new ArrayList<>();
        schrankenListe.add(new Schranke());
        schrankenListe.add(new Schranke());

        ArrayList<Kasse> kassenListe = new ArrayList<>();
        kassenListe.add(new Kasse(3.0));

        Parkhaus parkhaus = new Parkhaus(100, schrankenListe, kassenListe);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ein Kennzeichen Nummer eingeben:");
        String kennzeichen = scanner.nextLine();

        Fahrzeug fahrzeug = new Fahrzeug(kennzeichen);


        Ticket ticket = parkhaus.ticketErstellen(fahrzeug);
        if (ticket != null) {
            System.out.println("Möchten Sie ein Ticket ziehen? (ziehen/aufwiedersehen)");
            String antwort = scanner.nextLine();

            if (antwort.equalsIgnoreCase("ziehen")) {
                System.out.println("Ticket wurde erstellt.");
                Thread.sleep(2000);
                schrankenListe.get(0).oeffnen();
                System.out.println("es wird ins Parkhaus eingefahren...");
                Thread.sleep(1000);

                System.out.println("Möchten Sie das Parkhaus verlassen? (ja/nein)");
                String verlassen = scanner.nextLine();

                if (verlassen.equalsIgnoreCase("ja")) {
                    System.out.println("Bitte zahlen Sie die Gebühr: 3 CHF");
                    System.out.println("Zahlen? (zahlen)");
                    String zahlen = scanner.nextLine();
                    if (zahlen.equalsIgnoreCase("zahlen")) {
                        kassenListe.get(0).bezahlung();
                        Thread.sleep(1000);
                        schrankenListe.get(1).oeffnen();
                        System.out.println("Sie fahren aus dem Parkhaus...");
                        Thread.sleep(1000);
                        System.out.println("Auf Wiedersehen!");
                    }
                }
            } else {
                System.out.println("Auf Wiedersehen.");
            }
        } else {
            System.out.println("Kein freier Platz. Auf Wiedersehen.");
        }

        scanner.close();
    }
}

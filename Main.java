import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.function.Consumer;

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


        Supplier<Boolean> ticketZiehen = () -> {
            try {
                Ticket ticket = parkhaus.ticketErstellen(fahrzeug);
                if (ticket != null) {
                    System.out.println("Ticket wurde erstellt.");
                    return true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        };



        Consumer<Ticket> ticketBezahlen = (ticket) -> {
            System.out.println("Bitte Gebühr zahlen: 3 CHF");
            System.out.println("Zahlen? (zahlen)");
            String zahlen = scanner.nextLine();
            if (zahlen.equalsIgnoreCase("zahlen")) {
                kassenListe.get(0).bezahlung();
                schrankenListe.get(1).oeffnen();
                System.out.println("Sie fahren aus dem Parkhaus...");
            }
        };




        if (ticketZiehen.get()) {
            Ticket dummyTicket = new Ticket(2);
            System.out.println("Möchten Sie das Parkhaus verlassen? (ja/nein)");
            String verlassen = scanner.nextLine();
            if (verlassen.equalsIgnoreCase("ja")) {
                ticketBezahlen.accept(dummyTicket);
            }
        } else {
            System.out.println("Kein Ticket, auf Wiedersehen!");
        }

        scanner.close();
    }
}

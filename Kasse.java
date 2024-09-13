public class Kasse {
    private final double preisProStunde;

    public Kasse(double preisProStunde) {
        this.preisProStunde = 3.0;
    }

    public double berechnePreis(Ticket ticket) {
        return 3.0;
    }

    public void bezahlung() {
        System.out.println("Bezahlung erfolgreich :)");
    }
}

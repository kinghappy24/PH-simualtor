public class Schranke {
    private final boolean offen;

    public Schranke() {
        this.offen = false;
    }

    private Schranke(boolean offen) {
        this.offen = offen;
    }

    public Schranke oeffnen() {
        return new Schranke(true);
    }

    public Schranke schliessen() {
        return new Schranke(false);
    }

    public boolean isOffen() {
        return offen;
    }
}

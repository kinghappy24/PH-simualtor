public class Ticket {
    private final boolean bezahlt;
    private final int parkdauer;

    public Ticket(int parkdauer) {
        this.bezahlt = false;
        this.parkdauer = parkdauer;
    }

    private Ticket(boolean bezahlt, int parkdauer) {
        this.bezahlt = bezahlt;
        this.parkdauer = parkdauer;
    }

    public Ticket bezahlen() {
        return new Ticket(true, this.parkdauer);
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public int getParkdauer() {
        return parkdauer;
    }
}

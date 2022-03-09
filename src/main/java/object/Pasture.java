package object;

public class Pasture {
    private Bag bag;
    private int sumCow;
    private int sumChick;

    public Pasture() {
    }

    public Pasture(Bag bag, int schick, int scow) {
        this.sumCow = scow;
        this.sumChick = schick;
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}

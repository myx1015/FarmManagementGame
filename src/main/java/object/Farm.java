package object;

public class Farm {
    private Bag bag;

    public Farm(Bag bag) {
        this.bag = bag;
    }

    public Farm() {
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}

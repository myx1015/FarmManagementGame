package object;

public class Home {
    public int energy;
    int[] dayTab = new int[25];
    String[] name = new String[25];
    boolean[] water = new boolean[25];
    boolean[] fertilize = new boolean[25];
    private Farm farm;
    private Pasture pasture;
    private Bag bag;
    private int g;
    private int d;


    public Home(int g, int e, int d, Farm f, Pasture p, Bag b, int[] dayTab, String[] name, boolean[] water, boolean[] fertilize) {
        this.dayTab = dayTab;
        this.name = name;

        this.g = g;
        this.d = d;
        this.farm = f;
        this.pasture = p;
        this.bag = b;
        this.energy = e;
        this.water = water;
        this.fertilize = fertilize;
    }

    public Home() {
    }

    public boolean[] getWater() {
        return water;
    }

    public void setWater(boolean[] water) {
        this.water = water;
    }

    public boolean[] getFertilize() {
        return fertilize;
    }

    public void setFertilize(boolean[] fertilize) {
        this.fertilize = fertilize;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Pasture getPasture() {
        return pasture;
    }

    public void setPasture(Pasture pasture) {
        this.pasture = pasture;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }


    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int[] getDayTab() {
        return dayTab;
    }

    public void setDayTab(int[] dayTab) {
        this.dayTab = dayTab;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }
}

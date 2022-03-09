package object;

import javax.swing.*;

public class Seeds {
    public String name;
    public int growdays;
    public int price;
    public ImageIcon i;
    public String path;
    public int firstday;

    public Seeds(String name, int growdays, int price, String path) {
        this.name = name;
        this.growdays = growdays;
        this.price = price;
        this.path = path;
        this.i = new ImageIcon(path);
    }

    public void setFirstday(int d) {
        this.firstday = d;
    }

    public String getName() {
        return name;
    }

}

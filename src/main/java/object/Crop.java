package object;

import javax.swing.*;

public class Crop {
    public String name;
    public int price;
    //private String pathImg;
    public ImageIcon i;
    public String path;

    public Crop() {
    }

    public Crop(String name, int price, String path) {
        this.name = name;
        this.price = price;
        this.path = path;
        //this.pathImg = new ImageIcon(path).toString();
        this.i = new ImageIcon(path);
    }


    public String getName() {
        return this.name;
    }
}

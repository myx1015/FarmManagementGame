package object;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Cow extends GameObject {

    ImageIcon imgichick = new ImageIcon("src/main/resources/cow.png");
    Image imgchick = imgichick.getImage();
    int size;
    int xSpeed;
    int ySpeed;
    int state;
    private Random random = new Random();
    private int green = 255, red = 100;


    public Cow() {
        int num = 200 + (int) (Math.random() * (500 - 200 + 1));
        this.x = random.nextInt(750);
        this.y = num;
        this.width = 100;
        this.height = 70;
        this.state = 1;
    }

    public ImageIcon getImgichick() {
        return imgichick;
    }

    public void setImgichick(ImageIcon imgichick) {
        this.imgichick = imgichick;
    }

    public Image getImgchick() {
        return imgchick;
    }

    public void setImgchick(Image imgchick) {
        this.imgchick = imgchick;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void drawself(Graphics g) {
//        if(x + size> 650 - 4) x = 650 - size - 4;
//        else if(x < 4) x = 4;
//        if(y < 4) y = 4;
//        else if(y > 500) y = 500 - size - 4;

        g.drawImage(imgchick, x, y, width, height, null);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }


    public void setState(int state) {
        this.state = state;
    }
}

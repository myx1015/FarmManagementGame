package object;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Chick extends GameObject {

    ImageIcon imgichick = new ImageIcon("src/main/resources/chicken.png");
    Image imgchick = imgichick.getImage();
    private final Random random = new Random();
    private final int green = 255;
    private final int red = 100;


    public Chick() {

        int num = 200 + (int) (Math.random() * (500 - 200 + 1));

        this.x = random.nextInt(750);
        this.y = num;
        this.width = 42;
        this.height = 40;
    }

    public void drawself(Graphics g) {
        g.drawImage(imgchick, x, y, width, height, null);
    }

    @Override
    public String toString() {
        return "Tree [state=" + state + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
    }


}

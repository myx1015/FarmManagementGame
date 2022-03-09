package object;

import java.awt.*;

public class BuyFeed extends GameObject {


    public BuyFeed(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 150;
        this.height = 20;
    }

    @Override
    public void drawself(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, width, height);

    }


}

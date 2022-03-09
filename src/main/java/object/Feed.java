package object;

import Interface.PastureGamePanel;

import java.awt.*;

import static control.GlobalClass.animal;

public class Feed extends GameObject {

    public static final int WATER_SCOPE = 100; //消防员喷水半径
    public int speed = 3;
    public boolean islive = true;
    private final Farmer fireman = new Farmer(); //临时存储消防员的坐标
    private final int dir;

    public Feed(int x, int y, int dir) {
        this.width = 10;
        this.height = 10;
        fireman.x = x;
        fireman.y = y;
        this.x = x + Farmer.WIDTH / 2 - width / 2;
        this.y = y + Farmer.HEIGHT / 2 - height / 2;
        this.dir = dir;
    }

    public void drawself(Graphics g) {
        if (islive) {
            g.setColor(Color.orange);
            g.fillOval(x, y, width, height);
            switch (dir) {
                case 1://东
                    x += speed;
                    break;
                case 2://西
                    x -= speed;
                    break;
                case 3://南
                    y += speed;
                    break;
                case 4://北
                    y -= speed;
                    break;
                case 5://东南
                    x += speed;
                    y += speed;
                    break;
                case 6://东北
                    x += speed;
                    y -= speed;
                    break;
                case 7://西南
                    x -= speed;
                    y += speed;
                    break;
                case 8://西北
                    x -= speed;
                    y -= speed;
                    break;
            }
            if (x < 0 || y < 0 || x > PastureGamePanel.WIDTH || y > PastureGamePanel.HEIGHT || getDistance(fireman) >= WATER_SCOPE)
                islive = false;
            Chick c = null;
            for (GameObject e : animal)
                if (e.getRect().intersects(getRect()) && (e.state == 2 || e.state == 1)) {
                    islive = false;
                    c = (Chick) e;
                }
            if (c != null) {
                c.state = 3;
            }
        }
    }
}

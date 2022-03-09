package object;

import java.awt.*;

public class GameObject {

    public int x, y, width, height, state;
    public boolean islive = true;
    //判断两个物体中心的距离
    private final Point p1 = new Point();
    private final Point p2 = new Point();

    //获取物体的矩形
    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public void drawself(Graphics g) {

    }

    public double getDistance(GameObject o) {
        p1.setLocation(x + width / 2, y + height / 2);
        p2.setLocation(o.x + o.width / 2, o.y + o.height / 2);
        return p1.distance(p2);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

package object;


import Interface.PastureGamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static control.GlobalClass.*;

public class Farmer extends GameObject {

    public static final int WIDTH = 50;
    public static final int HEIGHT = 90;
    public static int surplusfood = 400;
    public static int feedvalue = 0;
    public static boolean replenishfood = false; //是否在补充水分
    public boolean left = false, right = false, up = false, down = false;
    public int speed;
    public List<Feed> food = new ArrayList<>();
    ImageIcon imgiFarmer = new ImageIcon("src/main/resources/farmerA.PNG");
    Image imgFarmer = imgiFarmer.getImage();
    ImageIcon grass1 = new ImageIcon("src/main/resources/IMG_7024.PNG");
    Image imggrass1 = grass1.getImage();
    ImageIcon grass2 = new ImageIcon("src/main/resources/IMG_7025.PNG");
    Image imggrass2 = grass2.getImage();
    ImageIcon grass3 = new ImageIcon("src/main/resources/IMG_7026.PNG");
    Image imggrass3 = grass3.getImage();
    private final int liveCount = 0;

    public Farmer() {
        this.width = WIDTH;
        this.height = HEIGHT;
        this.speed = 2;
        this.islive = true;
        this.state = 10;
        this.x = 400;
        this.y = 400;
    }

    //按下
    public void keyPr(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = true;
                down = false;
                left = false;
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                up = false;
                down = true;
                left = false;
                right = false;
                break;
            case KeyEvent.VK_LEFT:
                up = false;
                down = false;
                left = true;
                right = false;
                break;
            case KeyEvent.VK_RIGHT:
                up = false;
                down = false;
                left = false;
                right = true;
                break;
            case KeyEvent.VK_SPACE:
                if (energyI > 0) {
                    Isfeed = true;
                    if (surplusfood > 0  && feedvalue < 400) energyI--;
                    for (int i = 1; i <= 8; i++) {
                        if (surplusfood > 0  && feedvalue < 400) {
                            food.add(new Feed(x, y, i));
                            surplusfood -= 10;
                            feedvalue += 10;
                            Feedcount++;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You don't have energy", "no energy", JOptionPane.WARNING_MESSAGE);
                }
                break;
        }
    }

    //松开
    public void keyRe(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
    }

    //画出消防员喷的水
    private void drawWater(Graphics g) {
        for (BuyFeed r : PastureGamePanel.bf)
            if (r.getRect().intersects(getRect()) && surplusfood < 400) {
                replenishfood = true;
                break;
            } else replenishfood = false;
        if (replenishfood) {
            if (gold > 0) {
                surplusfood += 4;
                //feedvalue += 20;
                gold -= 1;
            }
        } //补饲料
        for (int i = 0; i < food.size(); i++) {
            food.get(i).drawself(g);
        }
        Feed w = null;
        for (Feed wa : food)     //水出界 移除容器
            if (!wa.islive)
                w = wa;
        if (w != null) food.remove(w);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", 20, 20));
        g.drawString("Feeding: 1 energy", 0, 20);
        g.drawString("Energy:" + energyI + "   " + "Money:" + gold + "    Day:" + dayinit, 0, 45);
        g.drawString("Surplus feed:", 0, 80);
        g.drawString("Buy feed:", 50, 630);
        g.setColor(Color.orange);
        g.drawRect(0, 90, 400, 20);
        g.fillRect(0, 90, surplusfood, 20);
        g.drawImage(imggrass1, 30, 180, 184, 68, null);
        g.drawImage(imggrass2, 150, 380, 166, 124, null);
        g.drawImage(imggrass3, 600, 200, 237, 92, null);
        g.drawImage(imggrass1, 450, 480, 237, 92, null);

        //g.drawPanel();
    }


    private void drawFeedValue(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", 20, 20));
        g.drawString("The satiety of animals:", 0, 130);
        g.setColor(Color.red);
        g.drawRect(0, 140, 400, 20);
        g.fillRect(0, 140, feedvalue, 20);
    }

    private void drawRule(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", 20, 20));
        g.drawString("Control farmer : ↑ ↓ ← → ", 600, 30);
        g.drawString("Control feed : space ", 600, 60);
        g.setColor(Color.red);
        g.drawString("No feeding today,no milk or eggs tomorrow", 480, 90);
    }


    public void drawself(Graphics g) {
        if (islive) {
            drawFeedValue(g);
            drawWater(g);
            drawRule(g);
            g.drawImage(imgFarmer, x, y, width, height, null);
            if (left) x -= speed;
            if (right) x += speed;
            if (up) y -= speed;
            if (down) y += speed;
        }
    }

}

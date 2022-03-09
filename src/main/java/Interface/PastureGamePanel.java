package Interface;

import object.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static control.GlobalClass.SUMCHICK;
import static control.GlobalClass.SUMCOW;


@SuppressWarnings("serial")
public class PastureGamePanel extends JPanel implements Runnable {


    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;

    public static final int Farmer_count = 1; //  消防员的数量
    public static List<GameObject> chicklist = new ArrayList<>();
    public static List<GameObject> cowlist = new ArrayList<>();
    public static List<BuyFeed> bf = new ArrayList<>();
    public List<GameObject> farmerlist = new ArrayList<>();
    //    List<GameObject> hungryanimal = new ArrayList<>();
//    List<GameObject> nowFireTrees = new ArrayList<>();
    private final boolean ispaint = true;
    private final Pasture pasture;


    public PastureGamePanel(Pasture pasture) throws IOException {

        this.pasture = pasture;

        setBackground(new Color(193, 255, 193));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        new Thread(this).start();

        bf.add(new BuyFeed(100, 650));
        bf.add(new BuyFeed(300, 650));

        for (int i = 0; i < Farmer_count; i++) {
            farmerlist.add(new Farmer());
        }
        for (int i = 0; i < SUMCHICK; i++)
            chicklist.add(new Chick());
        for (int i = 0; i < SUMCOW; i++)
            cowlist.add(new Cow());

    }

    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight()); //画背景
        //boolean exitFlag = true;
        for (int i = 0; i < Farmer_count; i++) {
            farmerlist.get(i).drawself(g);
        }
        for (int i = 0; i < SUMCHICK; i++) {
            chicklist.get(i).drawself(g);
            chicklist.get(i).setX(chicklist.get(i).getX() - 1);
            if (chicklist.get(i).getX() < -50) {
                chicklist.get(i).setX(850);
            }
        }
        for (int i = 0; i < SUMCOW; i++) {
            cowlist.get(i).drawself(g);
            cowlist.get(i).setX(cowlist.get(i).getX() - 2);
            if (cowlist.get(i).getX() < -100) {
                cowlist.get(i).setX(800);
            }
        }
        for (BuyFeed r : bf)
            r.drawself(g);
    }

    public void run() {
        while (true) {
            if (ispaint) {
                repaint();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

package control;

import object.GameObject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class GlobalClass {
    public static int Farmer_count = 1;
    public static String n;
    public static int p;
    public static int countbag = 0;
    public static JButton[] bagbtn = new JButton[25];
    public static int[] daygrowthTab = new int[25];
    public static int bagi = 0;
    public static int energyI = 10;
    public static int gold;
    public static int dayinit = 1;
    public static ArrayList<Integer> count = new ArrayList<>();
    public static String filename;
    public static List<GameObject> animal = new ArrayList<>();

    public static JPanel bagmain = new JPanel();

    public static int SUMCOW = 4;
    public static int SUMCHICK = 3;

    public static boolean IFhaveegg = true;

    public static boolean IFhavemilk = true;

    public static boolean Isfeed = false;
    public static boolean hungry = true;

    public static boolean IsPause = false;

    public static int Feedcount = 0;

    public static int countbag2 = 0;
    public static int countbag3 = 0;

    public static boolean[] Fertilize = new boolean[25];

    public static boolean[] Water = new boolean[25];

    public static JButton[] btnCrop = new JButton[25];

    public static ImageIcon imgBrown = new ImageIcon("src/main/resources/brown.png");
    public static ImageIcon imgGreen = new ImageIcon("src/main/resources/green.png");
    public static ImageIcon imginit = new ImageIcon("src/main/resources/ING.JPG");

    public static ImageIcon AfterFertilize = new ImageIcon("src/main/resources/shifeiAfter.PNG");
    public static ImageIcon AfterWater = new ImageIcon("src/main/resources/WaterAfter.PNG");
    public static ImageIcon both = new ImageIcon("src/main/resources/both.PNG");

    public static String[] name = new String[26];
    public static int energyMax = 10;
    public static int capacityPasture = 8;


    public GlobalClass() {
        Farmer_count = 1;
        countbag = 0;
        bagbtn = new JButton[25];
        daygrowthTab = new int[25];
        bagi = 0;
        energyI = 10;

        dayinit = 1;
        count = new ArrayList<>();

        animal = new ArrayList<>();

        bagmain = new JPanel();

        SUMCOW = 4;
        SUMCHICK = 3;

        IFhaveegg = true;

        IFhavemilk = true;

        Isfeed = false;
        hungry = true;

        IsPause = false;

        Feedcount = 0;

        countbag2 = 0;
        countbag3 = 0;
        Fertilize = new boolean[25];

        Water = new boolean[25];

        btnCrop = new JButton[25];


        name = new String[26];
        energyMax = 10;
        capacityPasture = 8;
        object.Farmer.surplusfood= 400;
        object.Farmer.feedvalue = 0;
        object.Farmer.replenishfood = false;
    }

}

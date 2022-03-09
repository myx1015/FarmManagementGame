package Interface;

import control.CountDownUtils;
import control.GlobalClass;
import control.MyThread;
import object.Bag;
import object.Farm;
import object.Home;
import object.Pasture;
import utils.JsonUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import static control.GlobalClass.*;
import static object.Farmer.feedvalue;


public class HomeMainPanel {

    final String gameRule = "Run your own farm with your own hands.\n\n" +
            "You can grow fields on farms and raise animals on pastures to obtain products.\n" +
            "Notice! Reclaiming farmland and feeding animals requires energy, so please \n" +
            "use your daily energy wisely. \n" +
            "Tips: Animals will not produce products without food, and crops will die without water.\n\n" +
            "Use your mind to expand your farm in the game\n";
    public int energy;
    private FarmMainPanel farm;
    private PastureMainPanel pastureMainPanel;
    private BagMainPanel bagMainPanel;
    private Home home;

    public HomeMainPanel(int g, int e, int d, FarmMainPanel f, PastureMainPanel p, BagMainPanel b, int[] dayTab, String[] name, boolean[] water, boolean[] fertilize) {
        Water = water;
        Fertilize = fertilize;
        daygrowthTab = dayTab;
        for (int i = 0; i < 25; i++) {
            if (daygrowthTab[i] >= 4 && daygrowthTab[i] <= 6) {
                if (name[i].equals("Broccoli")) {
                    setbuttonpic("src/main/resources/brocoli.png", btnCrop[i], 100, 70);
                    btnCrop[i].setText("Broccoli");
                    btnCrop[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                    btnCrop[i].setHorizontalTextPosition(SwingConstants.CENTER);
                }
                if (name[i].equals("Tomato")) {
                    setbuttonpic("src/main/resources/Tomato2.png", btnCrop[i], 100, 70);
                    btnCrop[i].setText("Tomato");
                    btnCrop[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                    btnCrop[i].setHorizontalTextPosition(SwingConstants.CENTER);
                }
                if (name[i].equals("Potato")) {
                    setbuttonpic("src/main/resources/Potato2.png", btnCrop[i], 100, 70);
                    btnCrop[i].setText("Potato");
                    btnCrop[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                    btnCrop[i].setHorizontalTextPosition(SwingConstants.CENTER);
                }
                if (name[i].equals("Eggplant")) {
                    setbuttonpic("src/main/resources/Eggplant2.png", btnCrop[i], 100, 70);
                    btnCrop[i].setText("Eggplant");
                    btnCrop[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                    btnCrop[i].setHorizontalTextPosition(SwingConstants.CENTER);
                }
                if (name[i].equals("Carrot")) {
                    setbuttonpic("src/main/resources/Carrot2.png", btnCrop[i], 100, 70);
                    btnCrop[i].setText("Carrot");
                    btnCrop[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                    btnCrop[i].setHorizontalTextPosition(SwingConstants.CENTER);
                }

            } else if (daygrowthTab[i] < 4 && daygrowthTab[i] > 0) {
                imginit.setImage(imginit.getImage().getScaledInstance(145, 120, Image.SCALE_DEFAULT));
                btnCrop[i].setIcon(imginit);
                btnCrop[i].setText(name[i]);
                btnCrop[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                btnCrop[i].setHorizontalTextPosition(SwingConstants.CENTER);
            }
        }
        gold = g;
        energyI = e;
        dayinit = d;
        this.farm = f;
        this.pastureMainPanel = p;
        this.bagMainPanel = b;
        initGameFrame();
    }

    public HomeMainPanel() {

    }

    FarmMainPanel getFarm() {
        return this.farm;
    }

    public void setFarm(FarmMainPanel farm) {
        this.farm = farm;
    }

    PastureMainPanel getPastureMainPanel() {
        return this.pastureMainPanel;
    }

    public void setPastureMainPanel(PastureMainPanel pastureMainPanel) {
        this.pastureMainPanel = pastureMainPanel;
    }

    BagMainPanel getBagMainPanel() {
        return this.bagMainPanel;
    }

    public void setBagMainPanel(BagMainPanel bagMainPanel) {
        this.bagMainPanel = bagMainPanel;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    private void initGameFrame() {

        JFrame mainFrame;
        CountDownUtils cd = new CountDownUtils();//倒计时
        final int[] lefttime = {cd.begincount()};
        mainFrame = new JFrame("Farm Management");
        mainFrame.setSize(900, 680);
        mainFrame.getContentPane().setLayout(null);
        JPanel imagePanel = (JPanel) mainFrame.getContentPane();
        imagePanel.setOpaque(false);
        String path = "src/main/resources/backg.png";
        ImageIcon background = new ImageIcon(path);
        background.setImage(background.getImage().getScaledInstance(900, 638, Image.SCALE_DEFAULT));
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, mainFrame.getWidth(), mainFrame.getHeight());
        mainFrame.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);

        JLabel dayleft = new JLabel("Day left time :" + lefttime[0]);
        Timer myTimer3 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lefttime[0] > 0) {
                    lefttime[0] = lefttime[0] - 1;
                    dayleft.setText("Day left time :" + lefttime[0]);
                } else if (lefttime[0] == 0) {

                    JOptionPane.showMessageDialog(null, "Time out,you will go to next day", "Time out", JOptionPane.WARNING_MESSAGE);
                    energyI = energyMax;
                    int daynext = dayinit + 1;
                    dayinit = daynext;

                    if (Isfeed) {
                        hungry = false;
                        if (hungry == false) {
                            IFhaveegg = true;
                            IFhavemilk = true;
                        }
                    }
                    Isfeed = false;
                    hungry = true;
                    if (hungry) {
                        feedvalue = 0;
                    }

                    for (int i = 0; i < 25; i++) {
                        if (daygrowthTab[i] != 0) {
                            daygrowthTab[i]++;
                        }
                    }

                    lefttime[0] = cd.begincount();

                    for (int i = 0; i < 25; i++) {
                        int finalI = i;
                        if (daygrowthTab[finalI] > 0) {
                            if (Water[finalI] == false) {
                                btnCrop[finalI].setText(null);
                                btnCrop[finalI].setIcon(imgBrown);
                                Water[finalI] = false;
                                Fertilize[finalI] = false;
                                daygrowthTab[finalI] = 0;
                            } else {
                                if (Fertilize[finalI]) {
                                    btnCrop[finalI].setIcon(AfterFertilize);
                                    //btnCrop[finalI].repaint();
                                } else {
                                    btnCrop[finalI].setIcon(imginit);
                                    //btnCrop[finalI].repaint();
                                }
                            }
                        }
                        if (daygrowthTab[finalI] >= 4 && daygrowthTab[finalI] <= 6) {
                            String n1 = btnCrop[finalI].getText();
                            if (n1 == "Broccoli") {
                                setbuttonpic("src/main/resources/brocoli.png", btnCrop[finalI], 100, 70);
                            }
                            if (n1 == "Tomato") {
                                setbuttonpic("src/main/resources/Tomato2.png", btnCrop[finalI], 100, 70);
                            }
                            if (n1 == "Potato") {
                                setbuttonpic("src/main/resources/Potato2.png", btnCrop[finalI], 100, 70);
                            }
                            if (n1 == "Eggplant") {
                                setbuttonpic("src/main/resources/Eggplant2.png", btnCrop[finalI], 100, 70);
                            }
                            if (n1 == "Carrot") {
                                setbuttonpic("src/main/resources/Carrot2.png", btnCrop[finalI], 100, 70);
                            }
                        } else if (daygrowthTab[finalI] >= 7) {
                            btnCrop[finalI].setText(null);
                            btnCrop[finalI].setIcon(imgBrown);
                            Water[finalI] = false;
                            Fertilize[finalI] = false;
                            daygrowthTab[finalI] = 0;
                        }

                        Water[finalI] = false;

                    }
                    pastureMainPanel.dispose();
                    pastureMainPanel.getToolPasture().dispose();
                    pastureMainPanel.setToolPasture(new ToolPasture(getBagMainPanel()));
                    farm.dispose();
                }
            }
        });


        JMenu menu1, menu2, submenu1;
        JMenuItem i1, i2, i3, i4, i5;
        JMenuBar mb = new JMenuBar();
        menu1 = new JMenu("File");
        submenu1 = new JMenu("Sub Menu");
        i1 = new JMenuItem("New");

        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int response = JOptionPane.showConfirmDialog(null, "Are you sure to create new game without save？", "", JOptionPane.YES_NO_OPTION);
                if (response == 0) {

                    myTimer3.stop();
                    mainFrame.dispose();
                    farm.dispose();
                    pastureMainPanel.dispose();
                    pastureMainPanel.getToolPasture().dispose();

                    Bag b1 = new Bag(25);
                    // BagMainPanel b1 = new BagMainPanel();
                    int goldinit = 50;

                    //HomeMainPanel home1 = new HomeMainPanel(goldinit,10,1,new FarmMainPanel(b1,goldinit),new PastureMainPanel(b1,new PastureGamePanel()),b1);

                    for (int i = 0; i < 25; i++) daygrowthTab[i] = 0;
                    for (int i = 0; i < 25; i++) name[i] = "";
                    for (int i = 0; i < 25; i++) Water[i] = false;
                    for (int i = 0; i < 25; i++) Fertilize[i] = false;
                    GlobalClass gb = new GlobalClass();

                    Home home1 = new Home(goldinit, 10, 1, new Farm(b1), new Pasture(b1, SUMCHICK, SUMCOW), b1, daygrowthTab, name, Water, Fertilize);
                    BagMainPanel thisbag = new BagMainPanel(home1.getBag());
                    ToolPasture toolPasture = new ToolPasture(thisbag);
                    try {
                        HomeMainPanel homestart = new HomeMainPanel(home1.getG(), home1.getEnergy(), home1.getD(), new FarmMainPanel(home1.getFarm(), thisbag), new PastureMainPanel(home1.getPasture(), thisbag, toolPasture), thisbag, home1.getDayTab(), home1.getName(), home1.getWater(), home1.getFertilize());
                        homestart.setHome(home1);
                        //mainFrame.dispose();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //mainFrame.dispose();
                }
            }
        });

        i2 = new JMenuItem("Open");
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoadGame LoadGame1 = new LoadGame();
            }
        });

        i4 = new JMenuItem("Save");
        i4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JsonUtil jsonUtil = new JsonUtil();
                try {
                    String str = JOptionPane.showInputDialog("input filename：");

                    if (str.equals("")) {
                        //System.out.println(111);
                        JOptionPane.showMessageDialog(null, "you didn't put in", "WARNING", JOptionPane.WARNING_MESSAGE);

                    } else {
                        File f = new File("src/main/java/plan/" + str + ".json");
                        if (f.exists() && !f.isDirectory()) {
                            JOptionPane.showMessageDialog(null, "The name already exist", "WARNING", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JsonUtil.exportObjetEnJson(str, new Home(gold, energyI, dayinit, getHome().getFarm(), getHome().getPasture(), getHome().getBag(), daygrowthTab, name, Water, Fertilize));//写入
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        i3 = new JMenuItem("Quit");
        i3.addActionListener(e -> mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING)));

        menu2 = new JMenu("Help");
        i5 = new JMenuItem("Game Rule");
        i5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, gameRule, "Game Rule", JOptionPane.PLAIN_MESSAGE);
            }
        });

        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i4);
        menu1.addSeparator();
        menu1.add(i3);

        menu2.add(i5);

        mb.add(menu1);
        mb.add(menu2);
        mainFrame.setJMenuBar(mb);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);

        Font btnfont = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
        JButton b1 = new JButton();
        b1.setText("Farm");
        b1.setBounds(70, 300, 100, 50);
        b1.setFont(btnfont);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FarmMainPanel f1 = getFarm();
                f1.setVisible(true);
            }
        });

        JButton b2 = new JButton("Next day");
        b2.setFont(btnfont);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println(Isfeed);
//                System.out.println(IFhavemilk);
                int daynext = dayinit + 1;
                dayinit = daynext;
                energyI = energyMax;

                if (Isfeed) {
                    hungry = false;
                    if (hungry == false) {
                        IFhaveegg = true;
                        IFhavemilk = true;
//                        System.out.println(IFhavemilk);
                    }
                }
                Isfeed = false;
                hungry = true;
                if (hungry) {
                    feedvalue = 0;
                }

                for (int i = 0; i < 25; i++) {
                    if (daygrowthTab[i] != 0) {
                        daygrowthTab[i]++;
                    }
                }

                lefttime[0] = cd.begincount();

                for (int i = 0; i < 25; i++) {
                    int finalI = i;
                    if (daygrowthTab[finalI] > 0) {
                        if (Water[finalI] == false) {
                            btnCrop[finalI].setText(null);
                            btnCrop[finalI].setIcon(imgBrown);
                            Water[finalI] = false;
                            Fertilize[finalI] = false;
                            daygrowthTab[finalI] = 0;
                        } else {
                            if (Fertilize[finalI]) {
                                btnCrop[finalI].setIcon(AfterFertilize);
                            } else {
                                btnCrop[finalI].setIcon(imginit);
                            }
                        }
                    }
                    if (daygrowthTab[finalI] >= 4 && daygrowthTab[finalI] <= 6) {
                        String n1 = btnCrop[finalI].getText();
                        System.out.println(n1);
                        if (n1 == "Broccoli") {
                            setbuttonpic("src/main/resources/brocoli.png", btnCrop[finalI], 100, 70);
                        }
                        if (n1 == "Tomato") {
                            setbuttonpic("src/main/resources/Tomato2.png", btnCrop[finalI], 100, 70);
                        }
                        if (n1 == "Potato") {
                            setbuttonpic("src/main/resources/Potato2.png", btnCrop[finalI], 100, 70);
                        }
                        if (n1 == "Eggplant") {
                            setbuttonpic("src/main/resources/Eggplant2.png", btnCrop[finalI], 100, 70);
                        }
                        if (n1 == "Carrot") {
                            setbuttonpic("src/main/resources/Carrot2.png", btnCrop[finalI], 100, 70);
                        }
                    } else if (daygrowthTab[finalI] >= 7) {
                        btnCrop[finalI].setText(null);
                        btnCrop[finalI].setIcon(imgBrown);
                        Water[finalI] = false;
                        Fertilize[finalI] = false;
                        daygrowthTab[finalI] = 0;
                    }
                    Water[finalI] = false;
                    //btnCrop[finalI].repaint();
                }
                pastureMainPanel.dispose();
                pastureMainPanel.getToolPasture().dispose();

                pastureMainPanel.setToolPasture(new ToolPasture(getBagMainPanel()));
                farm.dispose();
            }
        });

        b2.setBounds(620, 280, 150, 50);
        b2.setOpaque(false);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);


        JButton b3 = new JButton("Pasture");
        b3.setFont(btnfont);
        b3.setBounds(315, 520, 150, 50);
        b3.setOpaque(false);
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PastureMainPanel biblio = getPastureMainPanel();
                biblio.setVisible(true);
                ToolPasture toolPasture = biblio.getToolPasture();
                toolPasture.setVisible(true);
                toolPasture.repaint();
            }
        });


        JLabel day = new JLabel("Day:" + dayinit);
        Timer myTimer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                day.setText("Day:" + dayinit);
            }
        });
        myTimer.start();

        JLabel money = new JLabel("Money:" + gold);
        Timer myTimer2 = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                money.setText("Money:" + gold);
            }
        });
        myTimer2.start();

        myTimer3.start();


        Font font = new Font("Consolas", Font.PLAIN, 30);
        day.setFont(font);
        day.setBounds(20, 10, 150, 30);
        money.setFont(font);
        money.setBounds(250, 10, 200, 30);
        dayleft.setBounds(500, 10, 300, 30);
        dayleft.setFont(font);

        ImageIcon imgbag = new ImageIcon("src/main/resources/bag.png");
        imgbag.setImage(imgbag.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JButton bag = new JButton(imgbag);
        bag.setOpaque(false);
        bag.setContentAreaFilled(false);
        bag.setBorderPainted(false);

        bag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BagMainPanel b1 = getBagMainPanel();
                b1.setVisible(true);
            }
        });

        bag.setBounds(10, 510, 100, 100);

        JButton pause = new JButton("Pause");
        //setbuttonpic("src/main/resources/music.png", pause, "", 30, 30);
        pause.setBounds(780, 5, 100, 50);
        pause.setOpaque(false);
        pause.setContentAreaFilled(false);
        pause.setBorderPainted(false);

        MyThread myThread = new MyThread();
        myThread.start();

        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Btn = pause.getText();
                if (Btn.equals("Pause")) {
                    myThread.toSuspend();
                    pause.setText("Continue");
                } else {
                    myThread.toResume();
                    pause.setText("Pause");
                }

            }
        });


        mainFrame.getContentPane().add(b1);
        mainFrame.getContentPane().add(b2);
        mainFrame.getContentPane().add(b3);
        mainFrame.getContentPane().add(day);
        mainFrame.getContentPane().add(money);
        mainFrame.getContentPane().add(dayleft);
        mainFrame.getContentPane().add(mainpanel);
        mainFrame.getContentPane().add(bag);
        mainFrame.getContentPane().add(pause);

        mainFrame.setVisible(true);
    }

    private void setbuttonpic(String path, JButton b, String text, int w, int h) {
        ImageIcon imgI = new ImageIcon(path);
        imgI.setImage(imgI.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        b.setIcon(imgI);
        b.setText(text);
        b.setVerticalTextPosition(SwingConstants.BOTTOM);
        b.setHorizontalTextPosition(SwingConstants.CENTER);

    }

    private void setbuttonpic(String path, JButton b, int w, int h) {
        ImageIcon buttonface = new ImageIcon(path);
        buttonface.setImage(buttonface.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setFocusPainted(false);
        b.setBorder(null);
        b.setBackground(null);
        b.setIcon(buttonface);
    }


}

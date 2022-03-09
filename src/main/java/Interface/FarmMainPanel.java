package Interface;

import control.DragPicListener;
import object.Farm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static control.GlobalClass.*;


public class FarmMainPanel extends JFrame {


    private BagMainPanel bagMainPanel;
    private Farm farm;

    public FarmMainPanel(Farm f, BagMainPanel bg) {
        super("Farm");
        setResizable(false);
        this.farm = f;
        this.bagMainPanel = bg;
        setupUI();
    }

    public FarmMainPanel() {

    }

    public static JButton[] getBtnCrop() {
        return btnCrop;
    }

    public BagMainPanel getBagMainPanel() {
        return bagMainPanel;
    }

    public void setBagMainPanel(BagMainPanel bagMainPanel) {
        this.bagMainPanel = bagMainPanel;
    }


    private void setupUI() {

        setSize(900, 750);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        setupPanel();
    }

    private void setupPanel() {
        imgGreen.setImage(imgGreen.getImage().getScaledInstance(150, 140, Image.SCALE_DEFAULT));
        imgBrown.setImage(imgBrown.getImage().getScaledInstance(150, 140, Image.SCALE_DEFAULT));

        for (int i = 0; i < 25; i++) {
            daygrowthTab[i] = 0;
            Fertilize[i] = false;
            Water[i] = false;
            name[i] = "";
        }


        JPanel toppanel = new JPanel();
        toppanel.setLayout(new GridLayout(4, 1, 3, 3));
        toppanel.setBackground(new Color(205, 186, 150));

        JLabel jLabelenergy = new JLabel("Develop each area ：1 energy，Plants need to be watered every day", JLabel.CENTER);


        JLabel jLabelenergy2 = new JLabel("Remember to water the seeds after planting! ! ! Otherwise the crops will die", JLabel.CENTER);

        JLabel jLabeltop = new JLabel("Energy:" + energyI + "   " + "Money:" + gold, JLabel.CENTER);

        JLabel jLabelenergy3 = new JLabel("Drag a water bottle or fertilizer to water/fertilize the crops", JLabel.CENTER);

        Timer myTimer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabeltop.setText("Energy: " + energyI + "   " + "Money:" + gold);
            }
        });
        myTimer.start();

        jLabeltop.setForeground(new Color(0x776e65));
        jLabeltop.setFont(new Font("Dialog", 1, 20));

        jLabelenergy.setForeground(new Color(0x776e65));
        jLabelenergy.setFont(new Font("Dialog", 1, 20));

        jLabelenergy2.setForeground(Color.red);
        jLabelenergy2.setFont(new Font("Dialog", 1, 20));


        jLabelenergy3.setForeground(Color.red);
        jLabelenergy3.setForeground(new Color(0x776e65));
        jLabelenergy3.setFont(new Font("Dialog", 1, 20));


        toppanel.add(jLabeltop);
        toppanel.add(jLabelenergy);
        toppanel.add(jLabelenergy2);
        toppanel.add(jLabelenergy3);


        getContentPane().add(toppanel, BorderLayout.NORTH);


        var icon1 = new ImageIcon("src/main/resources/water.PNG");
        var label1 = new JLabel(icon1, JLabel.CENTER);

        var button = new JButton(icon1);
        button.setFocusable(false);
        label1.setTransferHandler(new TransferHandler("icon"));

        DragPicListener lis = new DragPicListener(label1, 1);
        label1.addMouseListener(lis);
        label1.addMouseMotionListener(lis);


        var icon2 = new ImageIcon("src/main/resources/shifei.PNG");
        var label2 = new JLabel(icon2, JLabel.CENTER);

        var button2 = new JButton(icon2);
        button2.setFocusable(false);
        label1.setTransferHandler(new TransferHandler("icon"));

        DragPicListener lis3 = new DragPicListener(label2, 2);
        label2.addMouseListener(lis3);
        label2.addMouseMotionListener(lis3);


        JButton btn2 = new JButton("Fertilize");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridLayout(4, 7, 5, 7));
        mainpanel.add(label1);
        mainpanel.add(label2);


        //btnCrop=new JButton[25];


        for (int i = 0; i < 25; i++) {
            btnCrop[i] = new JButton(imgGreen);
            btnCrop[i].setOpaque(true); //foreground设置透明
            btnCrop[i].setBorderPainted(false);
            int finalI = i;
            btnCrop[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (btnCrop[finalI].getIcon() == imgGreen) {
                        //int response = JOptionPane.showConfirmDialog(null, "Are you willing to spend 1 energy to develop this area？", "", JOptionPane.YES_NO_OPTION);
                        if (energyI > 0) {
                            energyI = energyI - 1;
                            btnCrop[finalI].setIcon(imgBrown);
                        } else {
                            JOptionPane.showMessageDialog(null, "You don't have energy", "no energy", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if (btnCrop[finalI].getIcon() == imgBrown) {
                        BuySeeds buyseed = new BuySeeds(btnCrop[finalI], dayinit, finalI);
                        //System.out.println(btnCrop[finalI]);
                        //System.out.println(daygrowthTab[finalI]);
                    } else if (btnCrop[finalI].getIcon() != imgBrown && btnCrop[finalI].getIcon() != imgGreen) {

                        if (daygrowthTab[finalI] >= 4) {

                            String n1 = btnCrop[finalI].getText();

                            bagbtn[bagi] = new JButton(n1);

                            bagmain.add(bagbtn[bagi]);
                            countbag++;

                            bagi++;
                            btnCrop[finalI].setOpaque(true);

                            btnCrop[finalI].setContentAreaFilled(true);
                            btnCrop[finalI].setFocusPainted(true);
                            btnCrop[finalI].setText(null);
                            btnCrop[finalI].setIcon(null);

                            btnCrop[finalI].setIcon(imgGreen);
                            Fertilize[finalI] = false;
                            Water[finalI] = false;
                            daygrowthTab[finalI] = 0;
                        }
                    }
                }
            });
            mainpanel.add(btnCrop[i]);
        }

        getContentPane().add(mainpanel, BorderLayout.CENTER);

        JPanel down = new JPanel();
        down.setLayout(new FlowLayout());

        JButton bag = new JButton("Bag");

        bag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BagMainPanel b1 = getBagMainPanel();
                b1.setVisible(true);
            }
        });

        JButton back = new JButton("BACK");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                dispose();
            }
        });

        down.add(bag);
        down.add(back);
        getContentPane().add(down, BorderLayout.SOUTH);
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}


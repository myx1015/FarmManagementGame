package Interface;

import object.Chick;
import object.Cow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Interface.PastureGamePanel.chicklist;
import static Interface.PastureGamePanel.cowlist;
import static control.GlobalClass.*;

public class ToolPasture extends JFrame {

    BagMainPanel bm;

    public ToolPasture(BagMainPanel bm) {
        this.bm = bm;
        setResizable(false);
        //setLocationRelativeTo(null);
        setLocation(320, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(205, 186, 150));

        JToolBar Toolbar = new JToolBar(JToolBar.VERTICAL);
        Toolbar.setLayout(new GridLayout(4, 1, 5, 5));
        Toolbar.setBackground(new Color(205, 186, 150));
        add(Toolbar, BorderLayout.WEST);

        JLabel lblToolbar = new JLabel("Harvestable");
        lblToolbar.setFont(new Font("Dialog", 1, 16));
        Toolbar.add(lblToolbar);


        ImageIcon imgEgg = new ImageIcon("src/main/resources/egg.png");
        imgEgg.setImage(imgEgg.getImage().getScaledInstance(50, 55, Image.SCALE_DEFAULT));
        JButton btnEgg = new JButton(imgEgg);

        ImageIcon imgMilk = new ImageIcon("src/main/resources/milk.png");
        imgMilk.setImage(imgMilk.getImage().getScaledInstance(30, 55, Image.SCALE_DEFAULT));
        JButton btnMilk = new JButton(imgMilk);

        if (IFhaveegg && IFhavemilk) {
            btnEgg.setVisible(true);
            btnMilk.setVisible(true);
            btnEgg.repaint();
            btnMilk.repaint();
        } else if (!IFhaveegg && IFhavemilk) {
            btnEgg.setVisible(false);
            btnMilk.setVisible(true);
            btnEgg.repaint();
            btnMilk.repaint();
        } else if (IFhaveegg && !IFhavemilk) {
            btnEgg.setVisible(true);
            btnMilk.setVisible(false);
            btnEgg.repaint();
            btnMilk.repaint();
        } else if (!IFhaveegg && !IFhavemilk) {
            btnEgg.setVisible(false);
            btnMilk.setVisible(false);
            btnEgg.repaint();
            btnMilk.repaint();
        }


        btnEgg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (IFhaveegg == true) {
                    int egg = SUMCHICK;
                    bagmain.add(new JButton("Egg*" + SUMCHICK));
                    countbag2++;
                    IFhaveegg = false;
                    btnEgg.setVisible(false);
                    btnEgg.repaint();
                }
            }
        });


        btnEgg.setText("Egg");
        btnEgg.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEgg.setHorizontalTextPosition(SwingConstants.CENTER);
        Toolbar.add(btnEgg);


        btnMilk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (IFhavemilk == true) {
                    int milk = SUMCOW;
                    bagmain.add(new JButton("Milk*" + SUMCOW));
                    countbag3++;
                    IFhavemilk = false;
                    btnMilk.setVisible(false);
                    btnMilk.repaint();
                }
            }
        });


        btnMilk.setText("Milk");
        btnMilk.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnMilk.setHorizontalTextPosition(SwingConstants.CENTER);
        Toolbar.add(btnMilk);

        JToolBar Store = new JToolBar(JToolBar.VERTICAL);
        Store.setLayout(new GridLayout(4, 1, 5, 5));
        Store.setBackground(new Color(205, 186, 150));
        add(Store, BorderLayout.EAST);

        JLabel lblStore = new JLabel("Store");
        lblStore.setFont(new Font("Dialog", 1, 16));
        Store.add(lblStore);

        ImageIcon imgChicken = new ImageIcon("src/main/resources/chicken.png");
        imgChicken.setImage(imgChicken.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT));
        JButton btnChicken = new JButton(imgChicken);


        btnChicken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                if (gold >= 10) {
                    if (SUMCHICK + SUMCOW <= capacityPasture) {
                        gold -= 10;
                        SUMCHICK++;
                        chicklist.add(new Chick());
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "Your pasture is too small, please expand the pasture", "no space", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You don't have money", "no money", JOptionPane.WARNING_MESSAGE);
                }
                //mainFrame.dispose();
            }
        });

        btnChicken.setText("Chicken");
        btnChicken.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnChicken.setHorizontalTextPosition(SwingConstants.CENTER);
        Store.add(btnChicken);

        ImageIcon imgCow = new ImageIcon("src/main/resources/cow.png");
        imgCow.setImage(imgCow.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT));
        JButton btnCow = new JButton(imgCow);


        btnCow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (gold >= 20) {
                    if (SUMCHICK + SUMCOW <= capacityPasture) {
                        gold -= 20;
                        SUMCOW++;
                        cowlist.add(new Cow());
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "Your pasture is too small, please expand the pasture", "no space", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You don't have money", "no money", JOptionPane.WARNING_MESSAGE);
                }
                //mainFrame.dispose();
            }
        });


        btnCow.setText("Cow");
        btnCow.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCow.setHorizontalTextPosition(SwingConstants.CENTER);
        Store.add(btnCow);


        JPanel down = new JPanel();
        down.setLayout(new FlowLayout());

        JButton bag = new JButton("Bag");

        bag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BagMainPanel b1 = getBm();
                b1.setVisible(true);
            }
        });

        JButton extendPasture = new JButton("ExtendPasture");

        extendPasture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int response = JOptionPane.showConfirmDialog(null, "Are you willing to spend 100 golds to extend this pasture？", "", JOptionPane.YES_NO_OPTION);
                if (response == 0) {
                    if (gold > 100) {
                        gold -= 100;
                        capacityPasture += 5;
                    } else {
                        JOptionPane.showMessageDialog(null, "Your don't have enough money", "no money", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                }
            }
        });

        down.add(bag);
        down.add(extendPasture);
        add(BorderLayout.SOUTH, down);

        //add(down,BorderLayout.SOUTH);


        pack();

    }

    public BagMainPanel getBm() {
        return bm;
    }

    public void setBm(BagMainPanel bm) {
        this.bm = bm;
    }
}

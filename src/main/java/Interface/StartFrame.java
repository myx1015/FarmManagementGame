package Interface;

import object.Bag;
import object.Farm;
import object.Home;
import object.Pasture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static control.GlobalClass.*;


public class StartFrame {


    final String gameRule = "Run your own farm with your own hands.\n\n" +
            "You can grow fields on farms and raise animals on pastures to obtain products.\n" +
            "Notice! Reclaiming farmland and feeding animals requires energy, so please \n" +
            "use your daily energy wisely. \n" +
            "Tips: Animals will not produce products without food, and crops will die without water.\n\n" +
            "Use your mind to expand your farm in the game\n";

    public StartFrame() {
        initFrame();
    }

    private void initFrame() {

        JFrame mainFrame;

        mainFrame = new JFrame("FarmManagement");
        mainFrame.setSize(900, 680);
        mainFrame.setResizable(false);//固定窗口尺寸
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);//窗口居中
        mainFrame.getContentPane().setLayout(null);


        JPanel imagePanel = (JPanel) mainFrame.getContentPane();
        imagePanel.setOpaque(false);

        String path = "src/main/resources/IMG_7007.PNG";
        ImageIcon background = new ImageIcon(path);
        background.setImage(background.getImage().getScaledInstance(mainFrame.getWidth(), mainFrame.getHeight(), Image.SCALE_DEFAULT));

        JLabel label = new JLabel(background);
        label.setBounds(0, 0, mainFrame.getWidth(), mainFrame.getHeight());

        mainFrame.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));

        Font font = new Font("Consolas", Font.PLAIN, 25);


        JButton btn1 = new JButton("New Game");
        btn1.setFont(font);
        btn1.setForeground(Color.white);
        btn1.setOpaque(false);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Bag b1 = new Bag(25);
                // BagMainPanel b1 = new BagMainPanel();
                int goldinit = 50;

                //HomeMainPanel home1 = new HomeMainPanel(goldinit,10,1,new FarmMainPanel(b1,goldinit),new PastureMainPanel(b1,new PastureGamePanel()),b1);
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
                mainFrame.dispose();

            }
        });

        btn1.setBounds(355, 275, 200, 50);


        JButton load = new JButton("Load Game");
        load.setForeground(Color.white);
        load.setFont(font);
        load.setOpaque(false);
        load.setContentAreaFilled(false);
        load.setBorderPainted(false);

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoadGame LoadGame1 = new LoadGame();
                //Home home1 = new Home();
                //mainFrame.dispose();
            }
        });
        // jPanel.add(newLine(load));
        load.setBounds(355, 365, 200, 50);

        JButton btn2 = new JButton("Game Rule");
        btn2.setForeground(Color.white);
        btn2.setFont(font);
        btn2.setOpaque(false);
        btn2.setContentAreaFilled(false);
        btn2.setBorderPainted(false);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, gameRule, "Game Rule", JOptionPane.PLAIN_MESSAGE);
            }
        });

        btn2.setBounds(355, 465, 200, 50);

        JButton btn3 = new JButton("Quit");
        btn3.setForeground(Color.white);
        btn3.setFont(font);
        btn3.setOpaque(false);
        btn3.setContentAreaFilled(false);
        btn3.setBorderPainted(false);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        btn3.setBounds(355, 555, 200, 50);

        mainFrame.getContentPane().add(btn1);
        mainFrame.getContentPane().add(load);
        mainFrame.getContentPane().add(btn2);
        mainFrame.getContentPane().add(btn3);

        mainFrame.setVisible(true);
    }

    //添加新一行垂直居中的控件，通过在控件两边填充glue对象实现
    private JPanel newLine(Component c) {

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
        jp.add(Box.createHorizontalGlue());
        jp.add(c);
        jp.add(Box.createHorizontalGlue());
        jp.setOpaque(false);//设置不透明

        return jp;
    }

}

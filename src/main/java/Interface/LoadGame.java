package Interface;

import object.Home;
import utils.JsonUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import static control.GlobalClass.filename;


public class LoadGame {


    public LoadGame() {
        initFrame();
    }

    private void initFrame() {
        JFrame mainFrame;
        JList list1 = null;
        mainFrame = new JFrame("LoadGame");
        mainFrame.setSize(300, 400);
        mainFrame.setResizable(false);//固定窗口尺寸
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);//窗口居中
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));

        DefaultListModel gamename = new DefaultListModel();

        File file = new File("src/main/java/plan/");
        File[] listFiles = file.listFiles();


        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                gamename.addElement(listFiles[i].getName());
            }
        }


        JList gameList = new JList(gamename);
        gameList.setPreferredSize(new Dimension(200, 300));
        gameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gameList.setSelectedIndex(0);
        gameList.setVisibleRowCount(5);

        JScrollPane vegListScrollPane = new JScrollPane(gameList);

        mainFrame.getContentPane().add(newLine(Box.createVerticalStrut(30)));


        mainFrame.getContentPane().add(newLine(vegListScrollPane));


        mainFrame.getContentPane().add(newLine(Box.createVerticalStrut(30)));


        JButton btn1 = new JButton("Enter Game");


        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();

                if (mouseEvent.getClickCount() == 1) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());

                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                        filename = o.toString();
                        System.out.println("Double-clicked on: " + o);
                    }
                }
            }
        };

        gameList.addMouseListener(mouseListener);


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JsonUtil jsonUtil = new JsonUtil();
                try {
                    Home h = JsonUtil.importJsonEnHome(filename);
                    BagMainPanel thisbag = new BagMainPanel(h.getBag());
                    ToolPasture toolPasture = new ToolPasture(thisbag);
                    HomeMainPanel homestart = new HomeMainPanel(h.getG(), h.getEnergy(), h.getD(), new FarmMainPanel(h.getFarm(), thisbag), new PastureMainPanel(h.getPasture(), thisbag, toolPasture), thisbag, h.getDayTab(), h.getName(), h.getWater(), h.getFertilize());
                    homestart.setHome(h);
                    System.out.println(h);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mainFrame.dispose();

            }
        });
        mainFrame.getContentPane().add(newLine(btn1));

        mainFrame.setVisible(true);
    }

    //Add a new line of vertically centered controls by filling glue objects on both sides of the controls
    private JPanel newLine(Component c) {

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
        jp.add(Box.createHorizontalGlue());
        jp.add(c);
        jp.add(Box.createHorizontalGlue());
        jp.setOpaque(false);

        return jp;
    }


}

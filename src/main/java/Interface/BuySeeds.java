package Interface;

import control.FriListCellRenderer;
import control.ListModel;
import object.Seeds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static control.GlobalClass.*;


public class BuySeeds {

    public int day;
    private int pos;

    public BuySeeds(JButton button, int d, int pos) {
        this.pos = pos;
        this.day = d;
        initFrame(button);
    }

    private void initFrame(JButton jt) {
        JFrame mainFrame;
        mainFrame = new JFrame("Buy seeds");
        mainFrame.setSize(300, 400);
        mainFrame.setResizable(false);//固定窗口尺寸
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);//窗口居中
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        ArrayList<Seeds> uArray = new ArrayList<>();
        uArray.add(new Seeds("Broccoli", 3, 5, "src/main/resources/brocoli.png"));
        uArray.add(new Seeds("Tomato", 3, 6, "src/main/resources/Tomato.png"));
        uArray.add(new Seeds("Eggplant", 3, 7, "src/main/resources/Eggplant.png"));
        uArray.add(new Seeds("Carrot", 3, 4, "src/main/resources/Carrot.png"));
        uArray.add(new Seeds("Potato", 3, 3, "src/main/resources/Potato.png"));

        ListModel buddy = new ListModel(uArray);
        @SuppressWarnings("rawtypes")
        JList buddyList = new JList(buddy);
        //设置单元渲染器
        buddyList.setCellRenderer(new FriListCellRenderer());
        buddyList.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        buddyList.setPreferredSize(new Dimension(360, 350));

        JScrollPane jp = new JScrollPane(buddyList);
        jp.setPreferredSize(new Dimension(360, 400));

        buddyList.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {

                int index = buddyList.getSelectedIndex();
                Seeds o = (Seeds) buddyList.getModel().getElementAt(index);
                int response = JOptionPane.showConfirmDialog(null, "Are you want to buy " + o.name + " for this area？", "", JOptionPane.YES_NO_OPTION);
                if (response == 0) { //yes
                    if (gold >= 5) {
                        n = o.getName();
                        o.setFirstday(dayinit);
                        int pr = o.price;
                        p = pr;
                        gold = gold - p;
                        daygrowthTab[pos] = 1;
                        name[pos] = n;
                        imginit.setImage(imginit.getImage().getScaledInstance(145, 120, Image.SCALE_DEFAULT));
                        jt.setIcon(imginit);
                        jt.setText(n);
                        jt.setVerticalTextPosition(SwingConstants.BOTTOM);
                        jt.setHorizontalTextPosition(SwingConstants.CENTER);
                        mainFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "You don't have money", "no money", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });


        mainFrame.getContentPane().add(jp);

        mainFrame.getContentPane().add(newLine(Box.createVerticalStrut(30)));


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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}

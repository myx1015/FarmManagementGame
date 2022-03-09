package control;

import object.Seeds;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"rawtypes", "serial"})
public class FriListCellRenderer extends JLabel implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        /*******Convert the data into a seed object, what is passed in the AbstractListModel is a seed object;*******/
        Seeds seeds = (Seeds) value;
        /*******Set the text of JLable*******/
        String text = "<html>" + seeds.name + "<br/>" + "Growth days: " + seeds.growdays + "<br/>" + "Price: " + seeds.price + " <html/>";
        setText(text);//设置JLable的文字
        /*******Set the picture of JLable*****/
        // Get the Image of this icon, and then create a scaled version of this image.
        Image img = seeds.i.getImage().getScaledInstance(65, 50, Image.SCALE_DEFAULT);
        setIcon(new ImageIcon(img));//Set the picture of JLable
        setIconTextGap(30);//Set the distance between JLable's picture and text
        return this;
    }

}

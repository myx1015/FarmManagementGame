package control;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

import static control.GlobalClass.*;

/**
 *
 */
public class DragPicListener extends MouseInputAdapter {
    /**
     * Coordinate points
     */
    Point point = new Point(0, 0);
    Point initialPoint;

    /**
     * This event is triggered when the mouse is dragged. Record the position of the mouse button (start dragging).
     */
    Component dragPicLabel;
    int tag;

    public DragPicListener(Component dragP, int tag) {
        AfterFertilize.setImage(AfterFertilize.getImage().getScaledInstance(150, 115, Image.SCALE_DEFAULT));
        AfterWater.setImage(AfterWater.getImage().getScaledInstance(150, 115, Image.SCALE_DEFAULT));
        both.setImage(both.getImage().getScaledInstance(150, 115, Image.SCALE_DEFAULT));

        this.dragPicLabel = dragP;
        this.tag = tag;
    }


    public void mouseDragged(MouseEvent e) {

        // Convert coordinate system
        Point newPoint = SwingUtilities.convertPoint(dragPicLabel, e
                .getPoint(), dragPicLabel.getParent());

        // Set the new position of the label
        dragPicLabel.setLocation(dragPicLabel.getX()
                + (newPoint.x - point.x), dragPicLabel.getY()
                + (newPoint.y - point.y));

        // Change the coordinate point
        point = newPoint;

        int row = Math.floorDiv((int) point.getY(), 150);
        int column = Math.floorDiv((int) point.getX(), 140);
        int listPosition = row * 7 + column - 2;
        if (listPosition >= 0) {
            if (this.tag == 2) {
                if (daygrowthTab[listPosition] > 0 && Fertilize[listPosition] == false) {
                    gold--;
                    Fertilize[listPosition] = true;
                    daygrowthTab[listPosition]++;
                    if (Fertilize[listPosition] && !Water[listPosition]) {
                        btnCrop[listPosition].setIcon(AfterFertilize);
                    } else if (Fertilize[listPosition] && Water[listPosition]) {
                        btnCrop[listPosition].setIcon(both);
                    } else if (!Fertilize[listPosition] && Water[listPosition]) {
                        btnCrop[listPosition].setIcon(AfterWater);
                    }
                    btnCrop[listPosition].repaint();
                }
            } else if (tag == 1) {
                if (daygrowthTab[listPosition] > 0 && Water[listPosition] == false && daygrowthTab[listPosition] <= 3) {
                    Water[listPosition] = true;
                    if (!Fertilize[listPosition] && Water[listPosition]) {
                        btnCrop[listPosition].setIcon(AfterWater);
                    } else if (Fertilize[listPosition] && Water[listPosition]) {
                        btnCrop[listPosition].setIcon(both);
                    } else if (Fertilize[listPosition] && !Water[listPosition]) {
                        btnCrop[listPosition].setIcon(AfterFertilize);
                    }
                    btnCrop[listPosition].repaint();
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    /**
     * This event is triggered when the mouse is pressed. Record the position of the mouse button (start dragging).
     */
    public void mousePressed(MouseEvent e) {
        // 得到当前坐标点
        // 转换坐标系统
        point = SwingUtilities.convertPoint(dragPicLabel, e.getPoint(),
                dragPicLabel.getParent());

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
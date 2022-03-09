package control;

import object.Seeds;

import javax.swing.*;
import java.util.ArrayList;

public class ListModel extends AbstractListModel {

    ArrayList<Seeds> uArray;

    public ListModel(ArrayList<Seeds> uArray) {
        this.uArray = uArray;
    }

    @Override
    public int getSize() {
        return uArray.size();
    }

    @Override
    public Object getElementAt(int index) {
        return uArray.get(index);
    }
}

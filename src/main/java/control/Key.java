package control;

import Interface.PastureGamePanel;
import object.Farmer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static control.GlobalClass.Farmer_count;

public class Key implements KeyListener {

    private final PastureGamePanel ui;

    public Key(PastureGamePanel g) {
        ui = g;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < Farmer_count; i++) {
            Farmer f = (Farmer) ui.farmerlist.get(i);
            f.keyPr(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (int i = 0; i < Farmer_count; i++) {
            Farmer f = (Farmer) ui.farmerlist.get(i);
            f.keyRe(e);
        }
    }

}

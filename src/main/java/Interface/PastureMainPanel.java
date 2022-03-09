package Interface;

import control.Key;
import object.Pasture;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class PastureMainPanel extends JFrame {

    //private PastureGamePanel ui;
    private Pasture pasture;
    private BagMainPanel bagMainPanel;
    private ToolPasture toolPasture;

    public PastureMainPanel(Pasture pasture, BagMainPanel bg, ToolPasture toolPasture) throws IOException {
        this.toolPasture = toolPasture;
        this.bagMainPanel = bg;
        this.pasture = pasture;
        //this.bag = getPasture().getBag();

        PastureGamePanel ui = new PastureGamePanel(getPasture());
        setResizable(false);
        //setLocationRelativeTo(null);
        setLocation(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Key key = new Key(ui);
        add(ui, BorderLayout.CENTER);
        pack();
        addKeyListener(key);
    }

    public ToolPasture getToolPasture() {
        return toolPasture;
    }

    public void setToolPasture(ToolPasture toolPasture) {
        this.toolPasture = toolPasture;
    }

    public Pasture getPasture() {
        return pasture;
    }

    public void setPasture(Pasture pasture) {
        this.pasture = pasture;
    }


    public BagMainPanel getBagMainPanel() {
        return bagMainPanel;
    }

    public void setBagMainPanel(BagMainPanel bagMainPanel) {
        this.bagMainPanel = bagMainPanel;
    }
}


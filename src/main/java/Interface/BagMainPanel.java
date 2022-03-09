package Interface;

import object.Bag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static control.GlobalClass.*;

public class BagMainPanel extends JFrame {

    private final Bag bag;

    public BagMainPanel(Bag b) {
        super("Bag");
        this.bag = b;
        setResizable(false);
        setupUI();
    }

    private void setupUI() {
        setSize(300, 500);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(Color.white);
        setupPanel();
    }

    private void setupPanel() {

        getContentPane().setLayout(new BorderLayout());
        bagmain.setLayout(new GridLayout(5, 5, 5, 5));
        JButton saleButton = new JButton("Sell All");
        JButton eat = new JButton("Eat food");
        JPanel down = new JPanel();
        down.setLayout(new FlowLayout());

        saleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int somme = countbag * 10 + countbag2 * 5 + countbag3 * 7;
                gold += somme;
                countbag = 0;
                countbag2 = 0;
                countbag3 = 0;
                bagmain.removeAll();
                bagmain.repaint();
            }
        });


        eat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int somme = countbag + countbag2 + countbag3;
                energyI += somme;
                if (energyI > 10) energyI = 10;
                countbag = 0;
                countbag2 = 0;
                countbag3 = 0;
                bagmain.removeAll();
                bagmain.repaint();
            }
        });

        down.add(saleButton);
        down.add(eat);
        getContentPane().add(BorderLayout.CENTER, bagmain);
        getContentPane().add(BorderLayout.SOUTH, down);

    }
}


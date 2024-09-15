package lab2;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class AllBordersJava extends JFrame {

    public AllBordersJava() {
        setTitle("Border Example");
        setSize(600, 400);
        setLayout(new GridLayout(3, 2, 10, 10));
        add(createPanelWithBorder("Line Border", BorderFactory.createLineBorder(Color.BLACK, 2)));
        add(createPanelWithBorder("Etched Border", BorderFactory.createEtchedBorder(EtchedBorder.RAISED)));
        add(createPanelWithBorder("Bevel Border", BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        add(createPanelWithBorder("Matte Border", BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED)));
        add(createPanelWithBorder("Empty Border", BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        add(createPanelWithBorder("Lowered Bevel Border", BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createPanelWithBorder(String title, Border border) {
        JPanel panel = new JPanel();
        panel.setBorder(border);
        panel.add(new JLabel(title));
        return panel;
    }

    public static void main(String[] args) {
        new AllBordersJava();
    }
}
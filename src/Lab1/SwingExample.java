package lab1;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;

public class SwingExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Example");
        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("Swing Label");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Swing Button Clicked");
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(label);

        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


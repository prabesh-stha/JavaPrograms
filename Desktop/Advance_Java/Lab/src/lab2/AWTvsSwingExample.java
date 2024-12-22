package lab2;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class AWTvsSwingExample {
    public static void main(String[] args) {
        // Create a JFrame for Swing components
        JFrame swingFrame = new JFrame("Swing Example");
        swingFrame.setSize(300, 200);
        swingFrame.setLayout(new FlowLayout());
        
        // Create a JButton (Swing)
        JButton swingButton = new JButton("Swing Button");
        swingFrame.add(swingButton);
        
        // Create a JLabel (Swing)
        JLabel swingLabel = new JLabel("This is a Swing Button");
        swingFrame.add(swingLabel);
        
        // Add action listener for the Swing button
        swingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swingLabel.setText("Swing Button Clicked!");
            }
        });
        
        // JFrame for AWT components
        Frame awtFrame = new Frame("AWT Example");
        awtFrame.setSize(300, 200);
        awtFrame.setLayout(new FlowLayout());
        
        // Create a Button (AWT)
        Button awtButton = new Button("AWT Button");
        awtFrame.add(awtButton);
        
        // Create a Label (AWT)
        Label awtLabel = new Label("This is an AWT Button");
        awtFrame.add(awtLabel);
        
        // Add action listener for the AWT button
        awtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                awtLabel.setText("AWT Button Clicked!");
            }
        });
        
        // Add window listeners to close the frames
        swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swingFrame.setVisible(true);
        
        awtFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                awtFrame.dispose();
            }
        });
        awtFrame.setVisible(true);
    }
}

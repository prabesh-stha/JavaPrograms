package lab2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class FocusEventJava  extends JFrame {

    JLabel label;
    JTextField textField;
    JButton button;

    public FocusEventJava() {
        setTitle("Focus Listener Example");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        label = new JLabel("Select a text field to see focus events.");
        textField = new JTextField("Text Field");
        
        button = new JButton("Click here");
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                label.setText("Text Field gained focus.");
            }

            @Override
            public void focusLost(FocusEvent e) {
                label.setText("Text Field lost focus.");
            }
        });

       
        add(label);
        add(textField);
        add(button);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FocusEventJava();
    }
}

package lab2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MouseEventJava extends JFrame {

    private JLabel label;

    public MouseEventJava() {
        setTitle("MouseAdapter on JFrame");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        label = new JLabel("Perform mouse actions in the frame.", JLabel.CENTER);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released at (" + e.getX() + ", " + e.getY() + ")");
            }
            
        	@Override
        	public void mouseEntered(java.awt.event.MouseEvent e) {
        		label.setText("Entered at ("+ e.getX() + "X" + e.getY() + "Y" +")");
        	}

        	@Override
        	public void mouseExited(java.awt.event.MouseEvent e) {
        		label.setText("Exited at ("+ e.getX() + "X" + e.getY() + "Y" +")");

        	}
        });
        add(label, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventJava();
    }
}


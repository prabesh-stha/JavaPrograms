package lab1;
import java.awt.*;
import java.awt.event.*;

public class AwtExample {

	public static void main(String[] args) {
        Frame frame = new Frame("Prabesh 26197");
        Button button = new Button("Click Me");
        Label label = new Label("AWT Label");
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(label);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("AWT Button Clicked");
            }
        });

        frame.setSize(400, 150);
        frame.setVisible(true);
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        }}


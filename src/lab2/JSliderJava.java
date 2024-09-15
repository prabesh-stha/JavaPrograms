package lab2;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class JSliderJava extends JFrame{

	 private JSlider slider;
	    private JLabel valueLabel;

	    public JSliderJava() {
	        setTitle("JSlider ChangeEvent Example");
	        setSize(400, 200);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());
	        slider = new JSlider(0, 100, 50);

	        valueLabel = new JLabel("Current Value: " + slider.getValue(), JLabel.CENTER);

	        slider.addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                int value = slider.getValue();
	                valueLabel.setText("Current Value: " + value);
	            }
	        });

	        add(slider, BorderLayout.CENTER);
	        add(valueLabel, BorderLayout.SOUTH);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	     new JSliderJava();
	    }

}

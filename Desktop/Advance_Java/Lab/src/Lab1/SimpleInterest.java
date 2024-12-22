package lab1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SimpleInterest extends JFrame implements ActionListener {
	JLabel principleLabel, timeLabel, rateLabel, result;
	JTextField principleField, timeField, rateField;
	JButton button;
	
	public SimpleInterest() {
		setTitle("Simple Interest");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		GroupLayout layout = new GroupLayout(container);
		container.setLayout(layout);
		
		principleLabel = new JLabel("Principle");
		timeLabel = new JLabel("Time");
		rateLabel = new JLabel("Rate");
		
		result = new JLabel("");
		
		principleField = new JTextField(10);
		principleField.setToolTipText("Enter the principle amount");
		
		timeField = new JTextField(10);
		timeField.setToolTipText("Enter time in years");
		
		rateField = new JTextField(10);
		rateField.setToolTipText("Enter rate in percent");
		
		button = new JButton("Calculate SI");
		button.addActionListener(this);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(principleLabel)
						.addComponent(timeLabel)
						.addComponent(rateLabel)
						.addComponent(button)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(principleField)
						.addComponent(timeField)
						.addComponent(rateField)
						.addComponent(result)
						)
				
				);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(principleLabel)
							.addComponent(principleField)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(timeLabel)
							.addComponent(timeField)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(rateLabel)
							.addComponent(rateField)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(button)
							.addComponent(result)
							)
				);
		
		
	}

	public static void main(String[] args) {
		new SimpleInterest();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int p,t,r;
		float si;
	    try {
	        p = Integer.parseInt(principleField.getText());
	        t = Integer.parseInt(timeField.getText());
	        r = Integer.parseInt(rateField.getText());
	        
	        si = (p * t * r) / 100.0f;  // Use 100.0f to ensure floating-point division
	        result.setText("Simple Interest: " + String.valueOf(si));
	    } catch (NumberFormatException ex) {
	        result.setText("Please enter valid numbers.");
	    }
		
		
		
	}

}

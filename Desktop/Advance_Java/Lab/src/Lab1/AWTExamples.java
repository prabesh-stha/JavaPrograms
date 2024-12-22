package lab1;

import javax.swing.*;

import java.awt.*;
import javax.swing.tree.*;
import java.awt.event.*;
import java.io.*;

class AWTExamples extends JFrame implements ActionListener{
	JButton button;
	public AWTExamples() {
		setTitle("Table");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250,250);
		setLayout(new BorderLayout());
		
		button = new JButton("Button");
		button.addActionListener(this);
		add(button, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new AWTExamples();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicked");
		
	}
}

package lab2;

import java.awt.event.*;
import javax.swing.*;


public class KeyEventJava extends JFrame implements KeyListener {

	JLabel label;
	JTextField text;
	public KeyEventJava() {
		setTitle("Prabesh 26197");
		setSize(200,150);
		label = new JLabel("Press any key");
		label.setBounds(50, 30, 300, 30);
		text = new JTextField();
		text.addKeyListener(this);
		text.setBounds(50, 80, 300, 30);
		add(label);
		add(text);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new KeyEventJava();

	}

	@Override
	public void keyTyped(KeyEvent e) {
        label.setText("Key Typed: " + e.getKeyChar());

	}

	@Override
	public void keyPressed(KeyEvent e) {
		label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
        label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
		
	}

}

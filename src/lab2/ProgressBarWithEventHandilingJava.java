package lab2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProgressBarWithEventHandilingJava extends JFrame {
	private JProgressBar progressBar;
    private JButton startButton;
    private Timer timer;
    private int progressValue = 0;

    public ProgressBarWithEventHandilingJava() {
        setTitle("JProgressBar Example with Event Handling");
        setSize(400, 150);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        startButton = new JButton("Start Progress");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startProgress();
            }
        });
        add(progressBar, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void startProgress() {
    	if (progressValue ==  100){
    		progressValue = 0;
    	}
        startButton.setEnabled(false);

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressValue += 2;
                progressBar.setValue(progressValue);

                if (progressValue >= 100) {
                    timer.stop();
                    startButton.setEnabled(true);
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new ProgressBarWithEventHandilingJava();
    }
}

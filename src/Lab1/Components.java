package lab1;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class Components extends JFrame {
		JPanel panel;
		JLabel nameLabel,passwordLabel,commentsLabel;
		JTextField nameField;
		JPasswordField passwordField;
		JTextArea commentsArea, resultArea;
		JButton submitButton;
		
		public Components() {
			setTitle("Swing Form Example");
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(400, 300);
	        
	        panel = new JPanel();
	        panel.setLayout(new GridLayout(4, 2, 10, 10));

	        nameLabel = new JLabel("Name:");
	        passwordLabel = new JLabel("Password:");
	        commentsLabel = new JLabel("Comments:");

	        nameField = new JTextField();
	        passwordField = new JPasswordField();
	        commentsArea = new JTextArea(5, 30);
	        submitButton = new JButton("Submit");
	        resultArea = new JTextArea(5, 30);
	        resultArea.setEditable(false);

	        panel.add(nameLabel);
	        panel.add(nameField);
	        panel.add(passwordLabel);
	        panel.add(passwordField);
	        panel.add(commentsLabel);
	        panel.add(submitButton);
	        
	        getContentPane().add(panel, BorderLayout.CENTER);
	        getContentPane().add(new JScrollPane(resultArea), BorderLayout.SOUTH);

	        submitButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String name = nameField.getText();
	                String password = new String(passwordField.getPassword());
	                String comments = commentsArea.getText();

	                resultArea.setText("Name: " + name + "\n" +
	                                    "Password: " + password + "\n" +
	                                    "Comments: " + comments);
	            }
	        });

	        setVisible(true);
	    }
		
	    public static void main(String[] args) {
	    	new Components();
	}
}

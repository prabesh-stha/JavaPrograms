package lab1;

	import javax.swing.*;

	public class JComboAndJList extends JFrame {

	    public JComboAndJList() {
	        setTitle("Simple JComboBox and JList");
	        setSize(300, 200);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

	        JComboBox<String> comboBox = new JComboBox<>(new String[] {"Item 1", "Item 2", "Item 3"});
	        add(comboBox);
	        JList<String> list = new JList<>(new String[] {"List Item 1", "List Item 2", "List Item 3"});
	        add(new JScrollPane(list));
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        new JComboAndJList();
	    }
	}


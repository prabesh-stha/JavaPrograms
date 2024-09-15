package lab2;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;


public class JTableAndJTreeJava extends JFrame {
	public JTableAndJTreeJava() {
		setLayout(new GridLayout(2,1));
		setSize(500,500);
		setTitle("JTable and JTree");
		DefaultMutableTreeNode collage=new DefaultMutableTreeNode("College");    
	    DefaultMutableTreeNode student=new DefaultMutableTreeNode("Student");  
	    collage.add(student);  
	    DefaultMutableTreeNode prabesh=new DefaultMutableTreeNode("prabesh");  
	    DefaultMutableTreeNode sanjeeb=new DefaultMutableTreeNode("sanjeeb");  
	    DefaultMutableTreeNode pranaya=new DefaultMutableTreeNode("pranaya");  
	    DefaultMutableTreeNode pratyus=new DefaultMutableTreeNode("pratyus"); 
	    DefaultMutableTreeNode sabib =new DefaultMutableTreeNode("sabib");  
	    student.add(prabesh); student.add(sanjeeb); student.add(pranaya); student.add(pratyus); student.add(sabib);      
	    JTree tree=new JTree(collage);  
	    add(tree);  
	    
	    String data[][] = { {"000","Prabesh","26196"},    
                {"001","Sanjeeb","26209"},    
                {"002","James","007"}}; 
		String column[] = {"Id", "Name", "Roll"};
		JTable table = new JTable(data, column);
		table.setBounds(30,40,200,300);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
	    
	    setVisible(true);  
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	}
	public static void main(String[] args) {  
	    new JTableAndJTreeJava();  
	}
}

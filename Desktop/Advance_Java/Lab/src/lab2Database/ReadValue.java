package lab2Database;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class ReadValue extends JFrame{

	Connection conn;
	DefaultTableModel model;
	JTable table;
	Statement st;
	ResultSet set;
	
	public ReadValue() throws ClassNotFoundException, SQLException {
		String[] column = {"ID", "First Name", "Last Name", "Contact Number"};
		model = new DefaultTableModel(null, column);
		table = new JTable(model);
		conn = new DatabaseConnection().getCon();
		st = conn.createStatement();
		String sql = "SELECT * FROM students";
		set = st.executeQuery(sql);
		
		while(set.next()) {
			int id = set.getInt("sid");
			String fname = set.getString("fname");
			String lname = set.getString("lname");
			int contact = set.getInt("contact");
			
			model.addRow(new Object[] {id, fname, lname, contact});
		}
		conn.close();
		add(table);
		
		setVisible(true);
		setSize(500,500);
		setTitle("Student List");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new ReadValue();

	}

}

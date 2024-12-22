package lab2;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Database {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		 Statement st;
		 Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
			System.out.println("Database Connection Successful");
			
			//Create Table
			st = conn.createStatement();
			st.executeUpdate("CREATE TABLE students(sid int, fname varchar(50), lname varchar(50), contact int);");
			System.out.println("Successfully created Table");
			
			//Insert Data
			st.executeUpdate("INSERT INTO students VALUES(26197,'Prabesh', 'Shrestha', 123456789);");
			st.executeUpdate("INSERT INTO students VALUES(26209,'Sanjeeb', 'Ghimire', 123456789);");
			st.executeUpdate("INSERT INTO students VALUES(27001,'Purna', 'Bahadur', 123456789);");
			st.executeUpdate("INSERT INTO students VALUES(27002,'Taylor', 'Swift', 123456789);");
			System.out.println("Value inserted");
			
			//Display Data
			String[] column = {"ID", "First Name", "Last Name", "Contact Number"};
			DefaultTableModel model = new DefaultTableModel(null, column);
			JTable table = new JTable(model);
			String sql = "SELECT * FROM students";
			ResultSet set = st.executeQuery(sql);
			
			while(set.next()) {
				int id = set.getInt("sid");
				String fname = set.getString("fname");
				String lname = set.getString("lname");
				int contact = set.getInt("contact");
				
				model.addRow(new Object[] {id, fname, lname, contact});
			}
			conn.close();
			JFrame frame = new JFrame("Student");
			 JScrollPane scrollPane = new JScrollPane(table);
			frame.add(scrollPane);
			
			frame.setVisible(true);
			frame.setSize(500,500);
			frame.setTitle("Student List");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			

	}

}

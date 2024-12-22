package lab2;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PreparedStatementProgram {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn;
        Statement st;
        
        // Load MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
        System.out.println("Database Connection Successful");
        

        // Update a Row
        String updateQuery = "UPDATE students SET fname = ?, lname = ?, contact = ? WHERE sid = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setString(1, "Kim");
        updateStmt.setString(2, "Kardashian");
        updateStmt.setInt(3, 555555555);
        updateStmt.setInt(4, 27002);
        int rowsUpdated = updateStmt.executeUpdate();
        System.out.println("Rows updated: " + rowsUpdated);

        // Delete a Row
        String deleteQuery = "DELETE FROM students WHERE sid = ?";
        PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
        deleteStmt.setInt(1, 27001);
        int rowsDeleted = deleteStmt.executeUpdate();
        System.out.println("Rows deleted: " + rowsDeleted);

        // Display Data
        String[] column = {"ID", "First Name", "Last Name", "Contact Number"};
        DefaultTableModel model = new DefaultTableModel(null, column);
        JTable table = new JTable(model);

        String selectQuery = "SELECT * FROM students";
        st = conn.createStatement();
        ResultSet set = st.executeQuery(selectQuery);

        while (set.next()) {
            int id = set.getInt("sid");
            String fname = set.getString("fname");
            String lname = set.getString("lname");
            int contact = set.getInt("contact");
            model.addRow(new Object[]{id, fname, lname, contact});
        }
        conn.close();

        // Add the JTable to a JScrollPane to display column headers
        JScrollPane scrollPane = new JScrollPane(table);

        // Create JFrame and add JScrollPane
        JFrame frame = new JFrame("Prabesh 26197");
        frame.add(scrollPane);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

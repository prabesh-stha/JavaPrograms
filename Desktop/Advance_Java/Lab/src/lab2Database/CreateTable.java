package lab2Database;

import java.sql.*;

public class CreateTable{
	Connection con;
	Statement st;
	
	
	public CreateTable() throws ClassNotFoundException, SQLException{
		con = new DatabaseConnection().getCon();
		st = con.createStatement();
		String query = "CREATE TABLE students(sid int, fname varchar(50), lname varchar(50), contact int);";
		st.executeUpdate(query);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new CreateTable();

	}

}

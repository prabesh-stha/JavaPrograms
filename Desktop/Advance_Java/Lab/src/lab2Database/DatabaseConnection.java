package lab2Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/users";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	Connection conn;
	
	public DatabaseConnection() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL,USER,PASSWORD);
		System.out.println("Database Connection Successful");
		
	}
	
	public Connection getCon() {
		return conn;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DatabaseConnection();

	}

}

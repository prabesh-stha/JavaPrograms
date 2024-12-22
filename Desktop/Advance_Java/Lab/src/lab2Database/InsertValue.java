package lab2Database;

import java.sql.*;

public class InsertValue {
	Connection con;
	PreparedStatement pst;
	
	public InsertValue() throws ClassNotFoundException, SQLException {
		con = new DatabaseConnection().getCon();
		String sql = "INSERT INTO students VALUES(?,?,?,?);";
		pst = con.prepareStatement(sql);
		pst.setInt(1,2);
		pst.setString(2,"Sanjeeb");
		pst.setString(3, "Ghimire");
		pst.setInt(4, 1234567890);
		pst.executeUpdate();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		new InsertValue();

	}

}

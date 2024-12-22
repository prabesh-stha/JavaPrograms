package lab2;

import java.sql.*;

public class TransactionProgram {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
        System.out.println("Connected to the database!");
        String balanceQuery = "SELECT id, balance FROM accounts WHERE id = ?";
        PreparedStatement fetchStmt = connection.prepareStatement(balanceQuery);
        System.out.println("Balances before transaction:");
        fetchBalance(fetchStmt, 26209);
        fetchBalance(fetchStmt, 26197);
        connection.setAutoCommit(false);
        String sql1 = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String sql2 = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        PreparedStatement deductStmt = connection.prepareStatement(sql1);
        PreparedStatement creditStmt = connection.prepareStatement(sql2);
        deductStmt.setDouble(1, 500); // Deduct 500
        deductStmt.setInt(2, 26209); // From account ID 26209
        deductStmt.executeUpdate();
        creditStmt.setDouble(1, 500); // Add 500
        creditStmt.setInt(2, 26197); // To account ID 26197
        creditStmt.executeUpdate();
        connection.commit();
        System.out.println("Transaction committed successfully.");
        System.out.println("Balances after transaction:");
        fetchBalance(fetchStmt, 26209);
        fetchBalance(fetchStmt, 26197);
        connection.setAutoCommit(true);
        deductStmt.close();
        creditStmt.close();
        fetchStmt.close();
        connection.close();
    }
    private static void fetchBalance(PreparedStatement stmt, int accountId) throws SQLException {
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            System.out.println("Account ID: " + rs.getInt("id") + ", Balance: " + rs.getDouble("balance"));
        }
        rs.close();
    }
}

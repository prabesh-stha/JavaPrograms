package lab2;


import java.sql.*;

public class ResultSetAdditionalProperties {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "";

        // Example query
        String query = "SELECT id, name, age FROM person";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // 1. Create a Statement with a scrollable and updateable ResultSet
            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE
            );

            // 2. Execute the query and obtain the ResultSet
            ResultSet resultSet = statement.executeQuery(query);

            // 3. Fetch Size - Setting the fetch size for efficient data retrieval
            resultSet.setFetchSize(50); // Example: fetch 50 rows at a time

            // 4. Scroll the ResultSet in both directions
            System.out.println("Moving forward through the ResultSet:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id + ": " + name + " (Age: " + age + ")");
            }

            // Move cursor back to the beginning of the result set (because the ResultSet is scrollable)
            System.out.println("\nMoving backward through the ResultSet:");
            if (resultSet.last()) {
                do {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println(id + ": " + name + " (Age: " + age + ")");
                } while (resultSet.previous());
            }

            // 5. Update ResultSet
            System.out.println("\nUpdating a record in the ResultSet:");
            if (resultSet.first()) {
                resultSet.updateString("name", "John Doe");
                resultSet.updateInt("age", 35);
                resultSet.updateRow();  // Apply the changes to the database
                System.out.println("Updated the first record.");
            }

            // 6. Demonstrate ResultSet metadata
            System.out.println("\nResultSet Metadata:");
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("Number of columns: " + metaData.getColumnCount());
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.println("Column " + i + ": " + metaData.getColumnName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

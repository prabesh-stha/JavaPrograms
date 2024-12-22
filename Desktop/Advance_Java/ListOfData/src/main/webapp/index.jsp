<%@page import="servletPackage.Database"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Table</title>

</head>
<body>
    <h1>Users Table</h1>
    <table border="1px">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <%
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    // Get the connection from the utility class
                    conn = Database.getConnection();
                    
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM person");

                    // Loop through the result set and populate the table rows
                    while (rs.next()) {
            %>
                        <tr>
                            <td><%= rs.getInt("id") %></td>
                            <td><%= rs.getString("name") %></td>
                            <td><%= rs.getInt("age") %></td>
                        </tr>
            <%
                    }
                } catch (Exception e) {
                    out.println("<tr><td colspan='4' style='color: red; text-align: center;'>Error: " + e.getMessage() + "</td></tr>");
                } finally {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                }
            %>
        </tbody>
    </table>
</body>
</html>

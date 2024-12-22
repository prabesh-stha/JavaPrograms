<%@ page import="jakarta.servlet.http.HttpSession" %>
<html>
<body>
    <h2>Welcome to the Home Page!</h2>
    <%
        // Retrieve the username from the session
        session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            if (username != null) {
    %>
                <p>Hello, <%= username %>! You are logged in.</p>
    <%
            } else {
    %>
                <p>You are not logged in.</p>
    <%
            }
        } else {
    %>
            <p>No session found. Please log in.</p>
    <%
        }
    %>
    <a href="logout">Logout</a>
</body>
</html>

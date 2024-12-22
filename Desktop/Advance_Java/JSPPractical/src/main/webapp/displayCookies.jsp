<%@ page import="jakarta.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Cookies</title>
</head>
<body>
    <h1>Saved Cookies</h1>
    <%
        // Get cookies from the request
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<p>" + cookie.getName() + ": " + cookie.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found!</p>");
        }
    %>
    <a href="index.html">Go Back</a>
</body>
</html>

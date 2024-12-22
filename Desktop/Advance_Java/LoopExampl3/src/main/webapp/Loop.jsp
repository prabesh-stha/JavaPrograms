<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello Friends</title>
</head>
<body>
    <h1>Printing "Hello Friends" 20 Times</h1>
    <%
        for (int i = 1; i <= 20; i++) {
    %>
        <p style="margin: 0;
            padding: 0;">Hello Friends</p>
    <%
        }
    %>
</body>
</html>

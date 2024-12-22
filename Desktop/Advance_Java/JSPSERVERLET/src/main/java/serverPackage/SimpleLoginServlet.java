package serverPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;

@WebServlet("/login")
public class SimpleLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the username from the form
        String username = request.getParameter("username");

        // Create a session and store the username in the session
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        // Redirect to the home.jsp page
        response.sendRedirect("home.jsp");
    }
}

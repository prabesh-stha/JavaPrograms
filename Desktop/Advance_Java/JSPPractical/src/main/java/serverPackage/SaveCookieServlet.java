package serverPackage;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveCookie")
public class SaveCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve data from the form
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        // Create cookies
        Cookie usernameCookie = new Cookie("username", username);
        Cookie emailCookie = new Cookie("email", email);

        // Set the max age of cookies (in seconds)
        usernameCookie.setMaxAge(60 * 60 * 24); // 1 day
        emailCookie.setMaxAge(60 * 60 * 24);   // 1 day

        // Add cookies to the response
        response.addCookie(usernameCookie);
        response.addCookie(emailCookie);

        // Redirect to JSP to display cookies
        response.sendRedirect("displayCookies.jsp");
    }
}

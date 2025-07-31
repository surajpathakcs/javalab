import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "CookieSessionServlet", urlPatterns = {"/cookieSession"})
public class CookieSessionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // ---- COOKIE PART ----
        Cookie[] cookies = request.getCookies();
        String userCookieVal = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("sudipa".equals(c.getName())) {
                    userCookieVal = c.getValue();
                    break;
                }
            }
        }

        // If no cookie found, create one
        if (userCookieVal == null) {
            Cookie userCookie = new Cookie("sudipa", "Sudipa");
            userCookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(userCookie);
            userCookieVal = "Created new cookie 'Sudipa'";
        } else {
            userCookieVal = "Found cookie with value: " + userCookieVal;
        }

        // ---- SESSION PART ----
        HttpSession session = request.getSession();
        String sessionVal = (String) session.getAttribute("sudipaCookie");

        // If no session attribute, create one
        if (sessionVal == null) {
            session.setAttribute("sudipaCookie", "SudipaCookie");
            sessionVal = "Created new session having value 'SudipaCookie'";
        } else {
            sessionVal = "Found session with value: " + sessionVal;
        }

        // ---- HTML RESPONSE ----
        out.println("<html><body>");
        out.println("<h2>Cookie & Session Example</h2>");
        out.println("<p>" + userCookieVal + "</p>");
        out.println("<p>" + sessionVal + "</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

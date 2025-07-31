package SumServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SumServlet", urlPatterns = {"/sum"})
public class SumServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String numStr = request.getParameter("number");
        int sum = 0;
        
        try (PrintWriter out = response.getWriter()) {
            int num = Integer.parseInt(numStr);

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            out.println("<html><body>");
            out.println("<h2>Sum of digits: " + sum + "</h2>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><body>");
                out.println("<h2>Invalid input! Please enter a valid number.</h2>");
                out.println("</body></html>");
            }
        }
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

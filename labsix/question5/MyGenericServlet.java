import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MyGenericServlet")
public class MyGenericServlet extends GenericServlet {

    protected void processRequest(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Hello from MyGenericServlet</h1>");
        }
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

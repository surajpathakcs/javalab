import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASS = ""; // update your password here

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            if ("POST".equalsIgnoreCase(request.getMethod())) {
                // Insert employee
                int eid = Integer.parseInt(request.getParameter("eid"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                double salary = Double.parseDouble(request.getParameter("salary"));

                try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement ps = con.prepareStatement(
                         "INSERT INTO Employee (Eid, Name, Address, Salary) VALUES (?, ?, ?, ?)")) {
                    ps.setInt(1, eid);
                    ps.setString(2, name);
                    ps.setString(3, address);
                    ps.setDouble(4, salary);
                    int rows = ps.executeUpdate();
                    out.println("<p>Inserted " + rows + " record(s) successfully.</p>");
                } catch (SQLException e) {
                    out.println("<p>Error inserting: " + e.getMessage() + "</p>");
                }
            }

            // Always display all employees
            try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM Employee")) {
                
                out.println("<h2>Employee List</h2>");
                out.println("<table border='1' cellpadding='5'>");
                out.println("<tr><th>Eid</th><th>Name</th><th>Address</th><th>Salary</th></tr>");
                while (rs.next()) {
                    out.printf("<tr><td>%d</td><td>%s</td><td>%s</td><td>%.2f</td></tr>",
                        rs.getInt("Eid"),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getDouble("Salary"));
                }
                out.println("</table>");
            } catch (SQLException e) {
                out.println("<p>Error fetching employees: " + e.getMessage() + "</p>");
            }

            // Simple HTML form to add new employee
            out.println("<h3>Add New Employee</h3>");
            out.println("<form method='post' action='employee'>");
            out.println("Eid: <input name='eid' type='number' required><br>");
            out.println("Name: <input name='name' type='text' required><br>");
            out.println("Address: <input name='address' type='text' required><br>");
            out.println("Salary: <input name='salary' type='number' step='0.01' required><br>");
            out.println("<input type='submit' value='Add Employee'>");
            out.println("</form>");
        } catch (ClassNotFoundException e) {
            throw new ServletException("MySQL Driver not found", e);
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
}

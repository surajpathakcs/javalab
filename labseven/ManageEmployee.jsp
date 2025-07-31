<%@ page import="java.sql.*, java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Manage Employees</title></head>
<body>
<h2>Employees with Salary below 5000</h2>

<%
    String jdbcURL = "jdbc:mysql://localhost:3306/company";
    String jdbcUser = "root";
    String jdbcPass = ""; // put your password here

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);

    String action = request.getParameter("action");
    String eidStr = request.getParameter("eid");

    if ("delete".equals(action) && eidStr != null) {
        // Delete employee
        PreparedStatement psDel = conn.prepareStatement("DELETE FROM Employee WHERE Eid = ?");
        psDel.setInt(1, Integer.parseInt(eidStr));
        psDel.executeUpdate();
        out.println("<p>Employee with Eid " + eidStr + " deleted.</p>");
    } else if ("update".equals(action) && eidStr != null) {
        // Update employee if form submitted
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String salaryStr = request.getParameter("salary");

        if (name != null && address != null && salaryStr != null) {
            PreparedStatement psUpd = conn.prepareStatement(
                "UPDATE Employee SET Name=?, Address=?, Salary=? WHERE Eid=?");
            psUpd.setString(1, name);
            psUpd.setString(2, address);
            psUpd.setDouble(3, Double.parseDouble(salaryStr));
            psUpd.setInt(4, Integer.parseInt(eidStr));
            psUpd.executeUpdate();
            out.println("<p>Employee with Eid " + eidStr + " updated.</p>");
        }
    }

    // Fetch employees with salary < 5000
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE Salary < 5000");

    while (rs.next()) {
        int eid = rs.getInt("Eid");
        String name = rs.getString("Name");
        String address = rs.getString("Address");
        double salary = rs.getDouble("Salary");

        // Show form for update
%>
        <form method="post" action="ManageEmployee.jsp">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="eid" value="<%= eid %>" />
            Eid: <%= eid %><br>
            Name: <input type="text" name="name" value="<%= name %>" /><br>
            Address: <input type="text" name="address" value="<%= address %>" /><br>
            Salary: <input type="number" step="0.01" name="salary" value="<%= salary %>" /><br>
            <input type="submit" value="Update" />
        </form>
        <form method="post" action="ManageEmployee.jsp" style="margin-top:5px;">
            <input type="hidden" name="action" value="delete" />
            <input type="hidden" name="eid" value="<%= eid %>" />
            <input type="submit" value="Delete" onclick="return confirm('Delete employee <%= eid %>?');" />
        </form>
        <hr>
<%
    }
    rs.close();
    stmt.close();
    conn.close();
%>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>Simple Interest Calculator</title></head>
<body>
    <h2>Simple Interest Calculator</h2>
    <form method="post">
        Principal: <input type="number" name="principal" required><br>
        Rate (%): <input type="number" name="rate" step="0.01" required><br>
        Time (years): <input type="number" name="time" step="0.01" required><br>
        <input type="submit" value="Calculate">
    </form>

    <%
        String pStr = request.getParameter("principal");
        String rStr = request.getParameter("rate");
        String tStr = request.getParameter("time");
        if (pStr != null && rStr != null && tStr != null) {
            try {
                double principal = Double.parseDouble(pStr);
                double rate = Double.parseDouble(rStr);
                double time = Double.parseDouble(tStr);
                double interest = (principal * rate * time) / 100;
                out.println("<h3>Simple Interest: " + interest + "</h3>");
            } catch (NumberFormatException e) {
                out.println("<h3>Invalid input. Please enter numeric values.</h3>");
            }
        }
    %>
</body>
</html>

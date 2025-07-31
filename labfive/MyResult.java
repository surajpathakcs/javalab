import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class MyResult {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "")) {
            // Scrollable ResultSet
            Statement scrollStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = scrollStmt.executeQuery("SELECT * FROM Employee");
            rs.first();
            System.out.println("Scrollable ResultSet:\nEid: " + rs.getInt("Eid") + ", Name: " + rs.getString("Name"));

            // Updatable ResultSet
            Statement updateStmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = updateStmt.executeQuery("SELECT * FROM Employee WHERE Eid = 1");
            if (rs.next()) {
                System.out.println("\nUpdatable ResultSet:\nBefore: Salary = " + rs.getDouble("Salary"));
                rs.updateDouble("Salary", 10000);
                rs.updateRow();
                rs.refreshRow();
                System.out.println("After: Salary = " + rs.getDouble("Salary"));
            }

            // CachedRowSet
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:mysql://localhost:3306/company");
            crs.setUsername("root");
            crs.setPassword("");
            crs.setCommand("SELECT * FROM Employee");
            crs.execute();

            if (crs.next()) {
                System.out.println("\nCachedRowSet:\nBefore: Salary = " + crs.getDouble("Salary"));
                crs.updateDouble("Salary", 20000);
                crs.updateRow();
                conn.setAutoCommit(false);
                crs.acceptChanges(conn);
                conn.commit();
                crs.first();
                System.out.println("After: Salary = " + crs.getDouble("Salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

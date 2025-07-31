import java.sql.*;
import java.util.Scanner;

public class Employee {


    static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            int choice;
            do {
                System.out.println("\n--- employee CRUD Menu ---");
                System.out.println("1. Add employee");
                System.out.println("2. View employees");
                System.out.println("3. Update employee");
                System.out.println("4. Delete employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: addemployee(); break;
                    case 2: viewemployees(); break;
                    case 3: updateemployee(); break;
                    case 4: deleteemployee(); break;
                    case 5: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice.");
                }
            } while (choice != 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addemployee() {
        try {
            System.out.print("Enter Eid: ");
            int eid = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            String sql = "INSERT INTO employee (Eid, Name, Address, Salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eid);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setDouble(4, salary);

            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("employee added successfully.");
            else System.out.println("Failed to add employee.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void viewemployees() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            System.out.println("\n--- employee List ---");
            while (rs.next()) {
                System.out.println("Eid: " + rs.getInt("Eid") +
                        ", Name: " + rs.getString("Name") +
                        ", Address: " + rs.getString("Address") +
                        ", Salary: " + rs.getDouble("Salary"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void updateemployee() {
        try {
            System.out.print("Enter Eid to update: ");
            int eid = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Address: ");
            String address = scanner.nextLine();
            System.out.print("Enter new Salary: ");
            double salary = scanner.nextDouble();

            String sql = "UPDATE employee SET Name=?, Address=?, Salary=? WHERE Eid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setDouble(3, salary);
            pstmt.setInt(4, eid);

            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("employee updated successfully.");
            else System.out.println("employee not found.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void deleteemployee() {
        try {
            System.out.print("Enter Eid to delete: ");
            int eid = scanner.nextInt();

            String sql = "DELETE FROM employee WHERE Eid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eid);

            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("employee deleted successfully.");
            else System.out.println("employee not found.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

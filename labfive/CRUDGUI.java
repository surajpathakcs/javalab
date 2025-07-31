import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CRUDGUI extends JFrame {

    // Fields
    JTextField eidField, nameField, addressField, salaryField;
    JButton btnCreate, btnRead, btnUpdate, btnDelete;

    // Constructor
    public CRUDGUI() {
        setTitle("Employee CRUD");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // UI Components
        add(new JLabel("EID:"));
        eidField = new JTextField(); add(eidField);

        add(new JLabel("Name:"));
        nameField = new JTextField(); add(nameField);

        add(new JLabel("Address:"));
        addressField = new JTextField(); add(addressField);

        add(new JLabel("Salary:"));
        salaryField = new JTextField(); add(salaryField);

        btnCreate = new JButton("Create");
        btnRead = new JButton("Read");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        add(btnCreate); add(btnRead);
        add(btnUpdate); add(btnDelete);

        setVisible(true);

        // Actions
        btnCreate.addActionListener(e -> create());
        btnRead.addActionListener(e -> read());
        btnUpdate.addActionListener(e -> update());
        btnDelete.addActionListener(e -> delete());
    }

    // DB Connection method
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Company", "root", ""); // Change password if needed
    }

    // CRUD Operations
    void create() {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?, ?)");
            ps.setInt(1, Integer.parseInt(eidField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, addressField.getText());
            ps.setDouble(4, Double.parseDouble(salaryField.getText()));
            int result = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Inserted: " + result + " row(s)");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    void read() {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee WHERE Eid=?");
            ps.setInt(1, Integer.parseInt(eidField.getText()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nameField.setText(rs.getString("Name"));
                addressField.setText(rs.getString("Address"));
                salaryField.setText(String.valueOf(rs.getDouble("Salary")));
            } else {
                JOptionPane.showMessageDialog(this, "No record found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    void update() {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Employee SET Name=?, Address=?, Salary=? WHERE Eid=?");
            ps.setString(1, nameField.getText());
            ps.setString(2, addressField.getText());
            ps.setDouble(3, Double.parseDouble(salaryField.getText()));
            ps.setInt(4, Integer.parseInt(eidField.getText()));
            int result = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Updated: " + result + " row(s)");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    void delete() {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Employee WHERE Eid=?");
            ps.setInt(1, Integer.parseInt(eidField.getText()));
            int result = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Deleted: " + result + " row(s)");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    // Main Method
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL Driver not found");
            return;
        }
        new CRUDGUI();
    }
}

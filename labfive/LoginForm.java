import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login");
        JTextField uidField = new JTextField(); uidField.setBounds(100, 30, 150, 20);
        JPasswordField pwdField = new JPasswordField(); pwdField.setBounds(100, 60, 150, 20);
        JButton okBtn = new JButton("OK"); okBtn.setBounds(50, 100, 80, 30);
        JButton cancelBtn = new JButton("Cancel"); cancelBtn.setBounds(150, 100, 80, 30);

        f.add(new JLabel("User ID:")).setBounds(30, 30, 80, 20);
        f.add(new JLabel("Password:")).setBounds(30, 60, 80, 20);
        f.add(uidField); f.add(pwdField); f.add(okBtn); f.add(cancelBtn);
        f.setSize(300, 200); f.setLayout(null); f.setVisible(true); f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        KeyAdapter ka = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'l') {
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "password");
                         PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE Uid=? AND Password=?")) {
                        ps.setString(1, uidField.getText());
                        ps.setString(2, new String(pwdField.getPassword()));
                        ResultSet rs = ps.executeQuery();
                        JOptionPane.showMessageDialog(f, rs.next() ? "Login successful" : "Invalid login");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (e.getKeyChar() == 'c') {
                    uidField.setText(""); pwdField.setText(""); uidField.requestFocus();
                }
            }
        };
        uidField.addKeyListener(ka); pwdField.addKeyListener(ka);
    }
}

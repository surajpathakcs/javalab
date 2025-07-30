/*
    3. Write a java program to create login form with TooltipText and validation
     and display the username and password when login button is clicked otherwise displa an error message.
*/

import javax.swing.*;
import java.awt.event.*;

public class ValidationExample extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;
    JLabel resultLabel;

    ValidationExample() {
        setTitle("Login Form");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 150, 25);
        usernameField.setToolTipText("Enter your username");
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 150, 25);
        passwordField.setToolTipText("Enter your password");
        add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 100, 80, 30);
        loginBtn.addActionListener(this);
        add(loginBtn);

        resultLabel = new JLabel("");
        resultLabel.setBounds(20, 140, 250, 25);
        add(resultLabel);
    }

    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (user.isEmpty() || pass.isEmpty()) {
            resultLabel.setText("Error: Fields can't be empty");
        } else {
            resultLabel.setText("User: " + user + ", Pass: " + pass);
        }
    }

    public static void main(String[] args) {
        new ValidationExample().setVisible(true);
    }
}

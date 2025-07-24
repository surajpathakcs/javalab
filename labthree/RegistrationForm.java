/*
    Question 4:Write a java program using swing component to create  student  registration form with field ( text field for name , address , 
    email , password , radiobutton for gender , checkbox for hobbies , coutry as dropdown list , opinion as text area , one button for submit).
    Your program dispaly the student information when user click on submit button.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
    JTextField nameField, addressField, emailField;
    JPasswordField passwordField;
    JRadioButton maleButton, femaleButton;
    JCheckBox readingBox, sportsBox, musicBox;
    JComboBox<String> countryDropdown;
    JTextArea opinionArea;
    JButton submitButton;

    public RegistrationForm() {
        // Frame setup
        frame = new JFrame("Student Form");
        frame.setSize(450, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 20);
        nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 20);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 70, 100, 20);
        addressField = new JTextField();
        addressField.setBounds(150, 70, 200, 20);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 110, 100, 20);
        emailField = new JTextField();
        emailField.setBounds(150, 110, 200, 20);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 150, 100, 20);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 20);

        // Gender (Radio Buttons)
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 190, 100, 20);
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        maleButton.setBounds(150, 190, 80, 20);
        femaleButton.setBounds(240, 190, 100, 20);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        // Hobbies (Checkboxes)
        JLabel hobbiesLabel = new JLabel("Hobbies:");
        hobbiesLabel.setBounds(30, 230, 100, 20);
        readingBox = new JCheckBox("Reading");
        sportsBox = new JCheckBox("Sports");
        musicBox = new JCheckBox("Music");
        readingBox.setBounds(150, 230, 80, 20);
        sportsBox.setBounds(240, 230, 80, 20);
        musicBox.setBounds(330, 230, 80, 20);

        // Country Dropdown
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(30, 270, 100, 20);
        String[] countries = {"Nepal", "India", "USA", "UK", "Canada"};
        countryDropdown = new JComboBox<>(countries);
        countryDropdown.setBounds(150, 270, 200, 20);

        // Opinion (TextArea)
        JLabel opinionLabel = new JLabel("Opinion:");
        opinionLabel.setBounds(30, 310, 100, 20);
        opinionArea = new JTextArea();
        JScrollPane opinionScroll = new JScrollPane(opinionArea);
        opinionScroll.setBounds(150, 310, 200, 80);
        opinionScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 420, 100, 30);
        submitButton.addActionListener(this);

        // Add components to frame
        frame.add(nameLabel); frame.add(nameField);
        frame.add(addressLabel); frame.add(addressField);
        frame.add(emailLabel); frame.add(emailField);
        frame.add(passwordLabel); frame.add(passwordField);
        frame.add(genderLabel); frame.add(maleButton); frame.add(femaleButton);
        frame.add(hobbiesLabel); frame.add(readingBox); frame.add(sportsBox); frame.add(musicBox);
        frame.add(countryLabel); frame.add(countryDropdown);
        frame.add(opinionLabel); frame.add(opinionScroll);
        frame.add(submitButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Gather data
        String name = nameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "Not selected");

        String hobbies = "";
        if (readingBox.isSelected()) hobbies += "Reading ";
        if (sportsBox.isSelected()) hobbies += "Sports ";
        if (musicBox.isSelected()) hobbies += "Music ";
        if (hobbies.isEmpty()) hobbies = "None";

        String country = (String) countryDropdown.getSelectedItem();
        String opinion = opinionArea.getText();

        // Display in dialog
        String message = "Name: " + name +
                         "\nAddress: " + address +
                         "\nEmail: " + email +
                         "\nPassword: " + password +
                         "\nGender: " + gender +
                         "\nHobbies: " + hobbies +
                         "\nCountry: " + country +
                         "\nOpinion:\n" + opinion;

        JOptionPane.showMessageDialog(frame, message);
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}

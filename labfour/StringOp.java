/*
    Design a GUI form using swing with a text field, a text label for displaying the input message 
    "Input any String" and three button with caption CheckPalindrome, Reverse, and FindVowels. 
    Write a complete program for above scenario and for checking palindrome in first button, reverse it 
    after clicking second button and extract vowel from it after clicking third button.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StringOp extends JFrame implements ActionListener {
    JLabel label;
    JTextField inputField;
    JButton palindromeBtn, reverseBtn, vowelBtn;
    JTextArea resultArea;

    public StringOp() {
        setTitle("String Ops");
        setSize(400, 300);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());

        label = new JLabel("Input any String:");
        inputField = new JTextField(20);

        palindromeBtn = new JButton("CheckPalindrome");
        reverseBtn = new JButton("Reverse");
        vowelBtn = new JButton("FindVowels");

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);

        palindromeBtn.addActionListener(this);
        reverseBtn.addActionListener(this);
        vowelBtn.addActionListener(this);

        add(label);
        add(inputField);
        add(palindromeBtn);
        add(reverseBtn);
        add(vowelBtn);
        add(new JScrollPane(resultArea));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String txt = inputField.getText();

        if (txt.isEmpty()) {
            resultArea.setText("Please enter something.");
            return;
        }

        if (e.getSource() == palindromeBtn) {
            String rev = new StringBuilder(txt).reverse().toString();
            if (txt.equalsIgnoreCase(rev)) {
                resultArea.setText("It's a Palindrome.");
            } else {
                resultArea.setText("Not a Palindrome.");
            }
        }

        if (e.getSource() == reverseBtn) {
            String rev = new StringBuilder(txt).reverse().toString();
            resultArea.setText("Reversed: " + rev);
        }

        if (e.getSource() == vowelBtn) {
            StringBuilder v = new StringBuilder();
            for (char c : txt.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) != -1) {
                    v.append(c).append(" ");
                }
            }
            resultArea.setText("Vowels: " + v.toString().trim());
        }
    }

    public static void main(String[] args) {
        new StringOp();
    }
}

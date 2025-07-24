/*
    Question 2: Write a GUI application to calculate Simple Interest. Use three text fields for input and fourth text field for output . 
    Your program should display simple Inetest if user presses the mouse and show Compound Interest if the user releases the mouse.
 */

import javax.swing.*;
import java.awt.event.*;

public class SimpleInterestApp {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Interest Calculator");

        // Create labels
        JLabel l1 = new JLabel("Principal:");
        JLabel l2 = new JLabel("Rate (%):");
        JLabel l3 = new JLabel("Time (years):");
        JLabel l4 = new JLabel("Result:");

        // Create text fields
        JTextField principalField = new JTextField();
        JTextField rateField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        // Set positions
        l1.setBounds(30, 30, 100, 20);
        principalField.setBounds(140, 30, 150, 20);

        l2.setBounds(30, 60, 100, 20);
        rateField.setBounds(140, 60, 150, 20);

        l3.setBounds(30, 90, 100, 20);
        timeField.setBounds(140, 90, 150, 20);

        l4.setBounds(30, 160, 100, 20);
        resultField.setBounds(140, 160, 150, 20);

        // Create a button (we'll use it to detect mouse events)
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(100, 130, 120, 25);

        // Add mouse listener
        calculateButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Calculate Simple Interest
                try {
                    double p = Double.parseDouble(principalField.getText());
                    double r = Double.parseDouble(rateField.getText());
                    double t = Double.parseDouble(timeField.getText());

                    double si = (p * r * t) / 100;
                    resultField.setText("Simple Interest: " + String.format("%.2f", si));
                } catch (Exception ex) {
                    resultField.setText("Invalid Input!");
                }
            }

            public void mouseReleased(MouseEvent e) {
                // Calculate Compound Interest
                try {
                    double p = Double.parseDouble(principalField.getText());
                    double r = Double.parseDouble(rateField.getText());
                    double t = Double.parseDouble(timeField.getText());

                    double ci = p * Math.pow(1 + r / 100, t) - p;
                    resultField.setText("Compound Interest: " + String.format("%.2f", ci));
                } catch (Exception ex) {
                    resultField.setText("Invalid Input!");
                }
            }
        });

        // Add components to frame
        frame.add(l1); frame.add(principalField);
        frame.add(l2); frame.add(rateField);
        frame.add(l3); frame.add(timeField);
        frame.add(calculateButton);
        frame.add(l4); frame.add(resultField);

        // Frame settings
        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

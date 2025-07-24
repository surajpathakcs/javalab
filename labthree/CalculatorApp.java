/* 
    Question 1: Write a java program using swing components to add and substract two number. Use text fields for input and outputs. Your program
    should display the result when user press button.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3,l4;
    JTextField t1, t2, t3,t4;
    JButton b1;

    public CalculatorApp() {
        f = new JFrame();
        l1 = new JLabel("Num1:");
        l2 = new JLabel("Num2:");
        l3 = new JLabel("Sum:");
        l4 =new JLabel("Difference:");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        b1 = new JButton("Calculate");

        f.setSize(400, 200);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(b1);
        f.add(l3);
        f.add(t3);
        f.add(l4);
        f.add(t4);

        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n1 = Integer.parseInt(t1.getText());
            int n2 = Integer.parseInt(t2.getText());
            int sum = n1 + n2;
            int diff =n1-n2;
            t3.setText(String.valueOf(sum));
            t4.setText(String.valueOf(diff));
        } catch (NumberFormatException ex) {
            t3.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}



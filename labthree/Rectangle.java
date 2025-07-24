/*
    Question 3: Write a java program using swing component to find Area and Perimeter of rectangle . Use text field for input and output.
    Your program should display the result when user click a button.
 */

import javax.swing.*;
import java.awt.event.*;

class Rectangle {
    JFrame f;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1;

    public Rectangle() {
        f = new JFrame("Rectangle Area and Perimeter");
        l1 = new JLabel("Length:");
        l2 = new JLabel("Breadth:");
        l3 = new JLabel("Area:");
        l4 = new JLabel("Perimeter:");

        t1 = new JTextField(25); // length
        t2 = new JTextField(25); // breadth
        t3 = new JTextField(25); // area output
        t4 = new JTextField(25); // perimeter output

        b1 = new JButton("Calculate");

        // Frame settings
        f.setSize(500, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Positioning
        l1.setBounds(50, 50, 150, 20);
        t1.setBounds(200, 50, 200, 20);
        l2.setBounds(50, 100, 150, 20);
        t2.setBounds(200, 100, 200, 20);
        b1.setBounds(200, 150, 100, 30);
        l3.setBounds(50, 200, 150, 20);
        t3.setBounds(200, 200, 200, 20);
        l4.setBounds(50, 250, 150, 20);
        t4.setBounds(200, 250, 200, 20);

        // Add to frame
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(b1);
        f.add(l3); f.add(t3);
        f.add(l4); f.add(t4);

        f.setVisible(true);

        // Event handling
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    float length = Float.parseFloat(t1.getText());
                    float breadth = Float.parseFloat(t2.getText());

                    float area = length * breadth;
                    float perimeter = 2 * (length + breadth);

                    t3.setText(String.format("%.2f", area));
                    t4.setText(String.format("%.2f", perimeter));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Please enter valid numbers.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Rectangle();
    }
}

    



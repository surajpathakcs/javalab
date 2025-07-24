import javax.swing.*;
import java.awt.*;

public class MyGridBagLayoutEx {
    JFrame frame;
    JButton b1, b2, b3, b4;
    GridBagConstraints gbc;

    public MyGridBagLayoutEx() {
        frame = new JFrame("GridBagLayout Demo");
        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        b3 = new JButton("Button3");
        b4 = new JButton("Button4");

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

        frame.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(b1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(b2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(b3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(b4, gbc);
    }

    public static void main(String[] args) {
        new MyGridBagLayoutEx();
    }
}

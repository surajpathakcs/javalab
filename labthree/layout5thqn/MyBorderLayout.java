import javax.swing.*;
import java.awt.*;

public class MyBorderLayout {
    JFrame frame;
    JButton b1, b2, b3, b4, b5;

    public MyBorderLayout() {
        frame = new JFrame("BorderLayout Demo");
        b1 = new JButton("North");
        b2 = new JButton("South");
        b3 = new JButton("East");
        b4 = new JButton("West");
        b5 = new JButton("Center");

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2, BorderLayout.SOUTH);
        frame.add(b3, BorderLayout.EAST);
        frame.add(b4, BorderLayout.WEST);
        frame.add(b5, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MyBorderLayout();
    }
}

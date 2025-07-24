import javax.swing.*;
import java.awt.*;

public class MyGridLayoutEx {
    JFrame frame;
    JButton b1, b2, b3, b4;

    public MyGridLayoutEx() {
        frame = new JFrame("GridLayout Demo");
        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        b3 = new JButton("Button3");
        b4 = new JButton("Button4");

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

        frame.setLayout(new GridLayout(2, 2));
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
    }

    public static void main(String[] args) {
        new MyGridLayoutEx();
    }
}

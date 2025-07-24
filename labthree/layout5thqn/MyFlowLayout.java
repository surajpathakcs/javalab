import javax.swing.*;
import java.awt.*;

public class MyFlowLayout {
    JFrame frame;
    JButton b1,b2,b3,b4;

    public MyFlowLayout(){
        frame = new JFrame("FlowLayout Demo");
        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        b3 = new JButton("Button3");
        b4 = new JButton("Button4");

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

        frame.setLayout(new FlowLayout());
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
    }
    
    public static void main(String[] args) {
        new MyFlowLayout();
    }
}

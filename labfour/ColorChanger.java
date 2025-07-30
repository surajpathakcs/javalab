/**
 Write a java program to create TextArea on frame, when click on TextArea popup menu containing different color 
 as menu item shown and change background color of TextArea with corresponding menu item is clicked.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChanger extends JFrame {

    JTextArea area;
    JPopupMenu popup;

    public ColorChanger() {
        setTitle("Color Changer");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        area = new JTextArea("Right-click me to change the color of background");
        popup = new JPopupMenu();

        // add menu items
        addColorOption("Red", Color.RED);
        addColorOption("Green", Color.GREEN);
        addColorOption("Yellow", Color.YELLOW);

        // show popup on right-click
        area.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) popup.show(area, e.getX(), e.getY());
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) popup.show(area, e.getX(), e.getY());
            }
        });

        add(area);
        setVisible(true);
    }

    void addColorOption(String label, Color color) {
        JMenuItem item = new JMenuItem(label);
        item.addActionListener(e -> area.setBackground(color));
        popup.add(item);
    }

    public static void main(String[] args) {
        new ColorChanger();
    }
}

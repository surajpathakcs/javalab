/*
    5. Write a java program to illustrate the following Swing component
        a. JFileChooser
        b. Internal Frames
        c. JTable

*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;

public class SimpleSwingDemo extends JFrame {

    JDesktopPane desktop;

    SimpleSwingDemo() {
        setTitle("Swing FileChooser, Frame and Table Demo");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Desktop pane for internal frames
        desktop = new JDesktopPane();
        add(desktop);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem fileItem = new JMenuItem("Open File");
        JMenuItem frameItem = new JMenuItem("Open Internal Frame");
        JMenuItem tableItem = new JMenuItem("Show Table");

        menu.add(fileItem);
        menu.add(frameItem);
        menu.add(tableItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // FileChooser
        fileItem.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                JOptionPane.showMessageDialog(this, "File selected: " + file.getAbsolutePath());
            }
        });

        // Internal Frame
        frameItem.addActionListener(e -> {
            JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
            frame.setSize(200, 100);
            frame.add(new JLabel("Hello from inside!"));
            frame.setVisible(true);
            desktop.add(frame);
        });

        // Table
        tableItem.addActionListener(e -> {
            String[] cols = {"ID", "Name", "Course"};
            String[][] rows = {
                {"100", "Jyoti", ".Net"},
                {"101", "Saraswati", "Python"},
                {"102", "Jiban", "Java"}
            };

            JTable table = new JTable(new DefaultTableModel(rows, cols));
            JInternalFrame tableFrame = new JInternalFrame("Table", true, true, true, true);
            tableFrame.add(new JScrollPane(table));
            tableFrame.setSize(300, 200);
            tableFrame.setVisible(true);
            desktop.add(tableFrame);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleSwingDemo();
    }
}

/*
   2 Write a java program to create Menu and menu item with Accelerator and mnemonics. And handle appropriate event when menu item is clicked.
 */



import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuExample extends JFrame {

    public MenuExample() {
        // Frame settings
        setTitle("Menu Example with Mnemonics and Accelerators");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a "File" menu with mnemonic 'F'
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + F

        // Create menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Set keyboard accelerators
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // Ctrl + N
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK)); // Ctrl + E

        // Add action listeners
        newItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "New File Created"));
        exitItem.addActionListener(e -> System.exit(0));

        // Add items to the File menu
        fileMenu.add(newItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Add menu to the menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Optional: label for context
        add(new JLabel("Use Alt + F to open File Menu, Ctrl + N for New, Ctrl + E for Exit."), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MenuExample frame = new MenuExample();
        frame.setVisible(true);
    }
}


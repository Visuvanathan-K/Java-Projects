package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
  

	public MainMenu() {
        setTitle("Library Management System - Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        // Buttons for different features
        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(e -> new AddBookGUI());
        add(addBookButton);

        JButton removeBookButton = new JButton("Remove Book");
        removeBookButton.addActionListener(e -> new RemoveBookGUI());
        add(removeBookButton);

        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.addActionListener(e -> new ViewBooksGUI());
        add(viewBooksButton);

        JButton addStaffButton = new JButton("Add Staff");
        addStaffButton.addActionListener(e -> new AddStaffGUI());
        add(addStaffButton);

        JButton removeStaffButton = new JButton("Remove Staff");
        removeStaffButton.addActionListener(e -> new RemoveStaffGUI());
        add(removeStaffButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu());
    }
}

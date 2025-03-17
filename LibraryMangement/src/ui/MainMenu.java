package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Library Management System - Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10));

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

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            dispose();
            new LoginPage();
        });
        add(logoutButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}

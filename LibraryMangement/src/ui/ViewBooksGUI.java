package ui;

import feature.ViewBooks;

import javax.swing.*;
import java.awt.*;

public class ViewBooksGUI extends JFrame {
    public ViewBooksGUI() {
        setTitle("View Books");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea booksTextArea = new JTextArea();
        booksTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(booksTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Fetch and display books in the GUI
        ViewBooks viewBooks = new ViewBooks();
        String bookData = viewBooks.displayBooks();
        booksTextArea.setText(bookData);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewBooksGUI();
    }
}

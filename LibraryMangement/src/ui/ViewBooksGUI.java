package ui;

import feature.ViewBooks;
import javax.swing.*;

import database.Database;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewBooksGUI extends JFrame {
    public ViewBooksGUI() {
        setTitle("View Books");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area for displaying books
        JTextArea booksTextArea = new JTextArea();
        booksTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(booksTextArea);

        add(scrollPane, BorderLayout.CENTER);

        // Fetch and display books
        ViewBooks viewBooks = new ViewBooks();
        booksTextArea.setText(viewBooks.fetchBooksForGUI());

        setVisible(true);
    }
    
    public String fetchBooksForGUI() {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT * FROM books";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            sb.append("ID\tTitle\tAuthor\tQuantity\n");
            sb.append("-----------------------------------\n");
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");

                sb.append(bookId).append("\t")
                  .append(title).append("\t")
                  .append(author).append("\t")
                  .append(quantity).append("\n");
            }

        } catch (SQLException e) {
            sb.append("Error fetching books: ").append(e.getMessage());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        new ViewBooksGUI();
    }
}

package ui;

import feature.AddBook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookGUI extends JFrame {
    private JTextField bookIdField, titleField, authorField, quantityField;

    public AddBookGUI() {
        setTitle("Add Book");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels and text fields
        add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        add(bookIdField);

        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Author:"));
        authorField = new JTextField();
        add(authorField);

        add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        add(quantityField);

        // Buttons
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new AddBookListener());
        add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);

        setVisible(true);
    }

    private class AddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String bookId = bookIdField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            int quantity;

            try {
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Quantity must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            AddBook addBook = new AddBook();
            if (addBook.addBook(bookId, title, author, quantity)) {
                JOptionPane.showMessageDialog(null, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add the book.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new AddBookGUI();
    }
}

package ui;

import feature.RemoveBook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBookGUI extends JFrame {
    private JTextField bookIdField;

    public RemoveBookGUI() {
        setTitle("Remove Book");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        add(bookIdField);

        JButton removeButton = new JButton("Remove Book");
        removeButton.addActionListener(new RemoveBookListener());
        add(removeButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);

        setVisible(true);
    }

    private class RemoveBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String bookId = bookIdField.getText();

            if (bookId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Book ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            RemoveBook removeBook = new RemoveBook();
            if (removeBook.removeBook(Integer.parseInt(bookId))) {
                JOptionPane.showMessageDialog(null, "Book removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to remove the book. Check Book ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new RemoveBookGUI();
    }
}


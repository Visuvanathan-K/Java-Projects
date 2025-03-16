package feature;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBook {
    public boolean addBook(String bookId, String title, String author, int quantity) {
        String query = "INSERT INTO books (book_id, title, author, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, bookId);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setInt(4, quantity);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error while adding the book: " + e.getMessage());
            return false;
        }
    }
}

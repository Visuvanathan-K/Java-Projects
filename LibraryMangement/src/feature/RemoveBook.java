package feature;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveBook {
    public boolean removeBook(String bookId) {
        String query = "DELETE FROM books WHERE book_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, bookId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row is deleted

        } catch (SQLException e) {
            System.err.println("Error while removing the book: " + e.getMessage());
            return false;
        }
    }
}

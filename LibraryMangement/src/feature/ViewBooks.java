package feature;

import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewBooks {
    public String displayBooks() {
        StringBuilder bookList = new StringBuilder();
        String query = "SELECT * FROM books";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            bookList.append("ID\tTitle\tAuthor\tGenre\tQuantity\tAvailable\n");
            bookList.append("--------------------------------------------------------\n");

            while (rs.next()) {
                bookList.append(
                        rs.getInt("book_id")).append("\t")
                        .append(rs.getString("title")).append("\t")
                        .append(rs.getString("author")).append("\t")
                        .append(rs.getString("genre")).append("\t")
                        .append(rs.getInt("quantity")).append("\t")
                        .append(rs.getBoolean("availability_status") ? "Yes" : "No")
                        .append("\n");
            }

        } catch (SQLException e) {
            bookList.append("Error retrieving books: ").append(e.getMessage());
        }

        return bookList.toString();  // Return the formatted data
    }
}

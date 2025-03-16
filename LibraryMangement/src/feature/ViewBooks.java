package feature;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewBooks {

    public void displayAllBooks() {
        String query = "SELECT * FROM books";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Library Books:");
            System.out.println("ID\tTitle\tAuthor\tQuantity");

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");

                System.out.println(bookId + "\t" + title + "\t" + author + "\t" + quantity);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving books: " + e.getMessage());
        }
    }

	public String fetchBooksForGUI() {
		// TODO Auto-generated method stub
		return null;
	}
}

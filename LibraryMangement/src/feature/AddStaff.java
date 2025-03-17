package feature;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStaff {
    public boolean addStaff(String name, String role, String contactInfo) {
        String query = "INSERT INTO staff (name, role, contact_info) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setString(3, contactInfo);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error while adding staff: " + e.getMessage());
            return false;
        }
    }
}

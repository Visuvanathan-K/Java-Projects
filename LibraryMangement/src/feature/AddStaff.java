package feature;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStaff {
    public boolean addStaff(String staffId, String name, String role, String email) {
        String query = "INSERT INTO staff (staff_id, name, role, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, staffId);
            stmt.setString(2, name);
            stmt.setString(3, role);
            stmt.setString(4, email);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error while adding the staff: " + e.getMessage());
            return false;
        }
    }
}

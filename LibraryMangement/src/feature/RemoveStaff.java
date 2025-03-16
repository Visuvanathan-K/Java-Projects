package feature;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveStaff {
    public boolean removeStaff(String staffId) {
        String query = "DELETE FROM staff WHERE staff_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, staffId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returns true if the staff was removed successfully

        } catch (SQLException e) {
            System.err.println("Error while removing the staff: " + e.getMessage());
            return false;
        }
    }
}

package edu.univ.erp.auth;

import edu.univ.erp.data.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthRepository {

    public AuthUser findByUsername(String username) {
        String sql = "SELECT user_id, username, role, status, password_hash " +
                     "FROM users_auth WHERE username = ?";

        try (Connection conn = DatabaseConnection.getAuthConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int userId = rs.getInt("user_id");
                    String uname = rs.getString("username");
                    String role = rs.getString("role");
                    String status = rs.getString("status");
                    String pwdHash = rs.getString("password_hash");

                    return new AuthUser(userId, uname, role, status, pwdHash);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // later replace by proper logging
        }
        return null;
    }
}

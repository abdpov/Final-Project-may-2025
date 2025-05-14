package agency.services;

import agency.models.User;
import java.sql.*;

public class AuthService {
    private final Connection connection;

    public AuthService(Connection connection) {
        this.connection = connection;
    }

    public User authenticate(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("account_type"),
                            rs.getString("full_name"),
                            rs.getDouble("salary"),
                            rs.getInt("experience")
                    );
                }
            }
        }
        return null;
    }
}
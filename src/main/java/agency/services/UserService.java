// agency/services/UserService.java
package agency.services;

import agency.models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private Connection connection;

    public UserService(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("account_type"),
                        rs.getString("full_name"),
                        rs.getDouble("salary"),
                        rs.getInt("experience")
                ));
            }
        }
        return users;
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

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
        return null;
    }

    public boolean updateUserSalary(int userId, double newSalary) throws SQLException {
        String sql = "UPDATE users SET salary = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, newSalary);
            stmt.setInt(2, userId);
            return stmt.executeUpdate() > 0;
        }
    }
}
package agency.services;

import agency.models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final Connection connection;

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

    public boolean updateSalary(int userId, double newSalary) throws SQLException {
        String sql = "UPDATE users SET salary = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, newSalary);
            stmt.setInt(2, userId);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean addEmployee(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password, account_type, full_name, salary, experience) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getAccountType());
            stmt.setString(4, user.getFullName());
            stmt.setDouble(5, user.getSalary());
            stmt.setInt(6, user.getExperience());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean removeEmployee(int userId) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0;
        }
    }
}
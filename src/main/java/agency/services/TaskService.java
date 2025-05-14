package agency.services;

import agency.models.Task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final Connection connection;

    public TaskService(Connection connection) {
        this.connection = connection;
    }

    public boolean createTask(String description, int assignedTo) throws SQLException {
        String sql = "INSERT INTO tasks (description, assigned_to, status) VALUES (?, ?, 'pending')";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, description);
            stmt.setInt(2, assignedTo);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Task> getTasksByEmployee(int employeeId, boolean completed) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String status = completed ? "completed" : "pending";
        String sql = "SELECT * FROM tasks WHERE assigned_to = ? AND status = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            stmt.setString(2, status);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    tasks.add(new Task(
                            rs.getInt("id"),
                            rs.getString("description"),
                            rs.getInt("assigned_to"),
                            rs.getString("status")
                    ));
                }
            }
        }
        return tasks;
    }

    public boolean completeTask(int taskId) throws SQLException {
        String sql = "UPDATE tasks SET status = 'completed' WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, taskId);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteTask(int taskId) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, taskId);
            return stmt.executeUpdate() > 0;
        }
    }
}
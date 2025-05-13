import java.sql.*;
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/real_estate_agency";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password_here";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

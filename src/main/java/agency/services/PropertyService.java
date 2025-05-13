// agency/services/PropertyService.java
package agency.services;

import agency.models.Property;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyService {
    private Connection connection;

    public PropertyService(Connection connection) {
        this.connection = connection;
    }

    public List<Property> getPropertiesByStatus(String status) throws SQLException {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM properties WHERE status = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                properties.add(new Property(
                        rs.getInt("id"),
                        rs.getString("address"),
                        rs.getString("type"),
                        rs.getString("status"),
                        rs.getDouble("price"),
                        rs.getInt("owner_id"),
                        rs.getInt("tenant_id"),
                        rs.getString("rent_period"),
                        rs.getDouble("monthly_rent")
                ));
            }
        }
        return properties;
    }

    public boolean updatePropertyStatus(int propertyId, String newStatus) throws SQLException {
        String sql = "UPDATE properties SET status = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, propertyId);
            return stmt.executeUpdate() > 0;
        }
    }
}
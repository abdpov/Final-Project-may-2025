// agency/models/Property.java
package agency.models;

public class Property {
    private int id;
    private String address;
    private String type;
    private String status;
    private double price;
    private int ownerId;
    private int tenantId;
    private String rentPeriod;
    private double monthlyRent;

    public Property(int id, String address, String type, String status,
                    double price, int ownerId, int tenantId,
                    String rentPeriod, double monthlyRent) {
        this.id = id;
        this.address = address;
        this.type = type;
        this.status = status;
        this.price = price;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.rentPeriod = rentPeriod;
        this.monthlyRent = monthlyRent;
    }

    // Геттеры и сеттеры для всех полей
}
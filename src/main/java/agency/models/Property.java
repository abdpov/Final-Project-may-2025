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

    // Геттеры
    public int getId() { return id; }
    public String getAddress() { return address; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public double getPrice() { return price; }
    public int getOwnerId() { return ownerId; }
    public int getTenantId() { return tenantId; }
    public String getRentPeriod() { return rentPeriod; }
    public double getMonthlyRent() { return monthlyRent; }

    // Сеттеры
    public void setStatus(String status) { this.status = status; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }
    public void setRentPeriod(String rentPeriod) { this.rentPeriod = rentPeriod; }
    public void setMonthlyRent(double monthlyRent) { this.monthlyRent = monthlyRent; }
}
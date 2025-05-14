package agency.models;

public class Client {
    private int id;
    private String fullName;
    private String region;
    private String contactInfo;

    public Client(int id, String fullName, String region, String contactInfo) {
        this.id = id;
        this.fullName = fullName;
        this.region = region;
        this.contactInfo = contactInfo;
    }

    // Геттеры
    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getRegion() { return region; }
    public String getContactInfo() { return contactInfo; }
}
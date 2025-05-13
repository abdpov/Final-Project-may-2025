package agency.models;

// agency/models/User.java
public class User {
    private int id;
    private String username;
    private String password;
    private String accountType;
    private String fullName;
    private double salary;
    private int experience;

    public User(int id, String username, String password, String accountType,
                String fullName, double salary, int experience) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        this.fullName = fullName;
        this.salary = salary;
        this.experience = experience;
    }

    // Геттеры и сеттеры для всех полей
    public int getId() { return id; }
    public String getUsername() { return username; }
    // ... остальные геттеры и сеттеры
}
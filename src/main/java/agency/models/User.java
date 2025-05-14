package agency.models;

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

    // Геттеры
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getAccountType() { return accountType; }
    public String getFullName() { return fullName; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }

    // Сеттеры
    public void setSalary(double salary) { this.salary = salary; }
    public void setExperience(int experience) { this.experience = experience; }
}
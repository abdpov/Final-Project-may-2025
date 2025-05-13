// agency/models/Employee.java
package agency.models;

public class Employee extends User {
    private String department;
    private String position;

    public Employee(int id, String username, String password, String accountType,
                    String fullName, double salary, int experience,
                    String department, String position) {
        super(id, username, password, accountType, fullName, salary, experience);
        this.department = department;
        this.position = position;
    }

    // Геттеры и сеттеры
    public String getDepartment() { return department; }
    public String getPosition() { return position; }
    // ... сеттеры
}
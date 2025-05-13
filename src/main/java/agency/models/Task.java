// agency/models/Task.java
package agency.models;

public class Task {
    private int id;
    private String description;
    private int assignedTo;
    private String status;

    public Task(int id, String description, int assignedTo, String status) {
        this.id = id;
        this.description = description;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    // Геттеры и сеттеры
}
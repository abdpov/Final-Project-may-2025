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

    // Геттеры
    public int getId() { return id; }
    public String getDescription() { return description; }
    public int getAssignedTo() { return assignedTo; }
    public String getStatus() { return status; }

    // Сеттеры
    public void setStatus(String status) { this.status = status; }
}
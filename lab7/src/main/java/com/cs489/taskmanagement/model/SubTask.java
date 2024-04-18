package com.cs489.taskmanagement.model;

import jakarta.persistence.*;

@Entity
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subtaskId;
    private String title;
    private String description;
    private String priority;
    private String status;

    @ManyToOne
    @JoinColumn(name = "taskId")
    private Task task;

    // Constructor
    public SubTask() {
    }

    public SubTask(String title, String description, String priority, String status, Task task) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.task = task;
    }

    // Getters and setters
    public int getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(int subtaskId) {
        this.subtaskId = subtaskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

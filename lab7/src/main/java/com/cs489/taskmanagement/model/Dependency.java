package com.cs489.taskmanagement.model;

import jakarta.persistence.*;

@Entity
public class Dependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dependencyId;

    @ManyToOne
    @JoinColumn(name = "predecessorTaskId")
    private Task predecessorTask;

    @ManyToOne
    @JoinColumn(name = "successorTaskId")
    private Task successorTask;

    private String type;

    // Constructor
    public Dependency() {
    }

    public Dependency(Task predecessorTask, Task successorTask, String type) {
        this.predecessorTask = predecessorTask;
        this.successorTask = successorTask;
        this.type = type;
    }

    // Getters and setters
    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public Task getPredecessorTask() {
        return predecessorTask;
    }

    public void setPredecessorTask(Task predecessorTask) {
        this.predecessorTask = predecessorTask;
    }

    public Task getSuccessorTask() {
        return successorTask;
    }

    public void setSuccessorTask(Task successorTask) {
        this.successorTask = successorTask;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
package com.cs489.taskmanagement.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    private String role;
    private String password;

    // One-to-many relationship with Assignment
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assignment> assignments;

    // One-to-many relationship with Comment
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    // Constructor
    public User() {
    }

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // Add assignment to user
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
        assignment.setUser(this);
    }

    // Remove assignment from user
    public void removeAssignment(Assignment assignment) {
        assignments.remove(assignment);
        assignment.setUser(null);
    }

    // Add comment to user
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setUser(this);
    }

    // Remove comment from user
    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setUser(null);
    }
}

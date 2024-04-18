package com.cs489.taskmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs489.taskmanagement.model.Assignment;
import com.cs489.taskmanagement.repositories.AssignmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(int assignmentId) {
        return assignmentRepository.findById(assignmentId);
    }

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(int assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    public Assignment updateAssignment(int assignmentId, Assignment updatedAssignment) {
        return assignmentRepository.findById(assignmentId)
                .map(existingAssignment -> {
                    existingAssignment.setUser(updatedAssignment.getUser());
                    existingAssignment.setTask(updatedAssignment.getTask());
                    existingAssignment.setAssignedDate(updatedAssignment.getAssignedDate());
                    existingAssignment.setDeadline(updatedAssignment.getDeadline());
                    return assignmentRepository.save(existingAssignment);
                })
                .orElse(null);
    }
}

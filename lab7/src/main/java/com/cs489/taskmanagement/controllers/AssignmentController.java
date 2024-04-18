package com.cs489.taskmanagement.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs489.taskmanagement.model.Assignment;
import com.cs489.taskmanagement.services.AssignmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/{assignmentId}")
    public Optional<Assignment> getAssignmentById(@PathVariable int assignmentId) {
        return assignmentService.getAssignmentById(assignmentId);
    }

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @DeleteMapping("/{assignmentId}")
    public void deleteAssignment(@PathVariable int assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
    }

    @PutMapping("/{assignmentId}")
    public Assignment updateAssignment(@PathVariable int assignmentId, @RequestBody Assignment updatedAssignment) {
        return assignmentService.updateAssignment(assignmentId, updatedAssignment);
    }
}
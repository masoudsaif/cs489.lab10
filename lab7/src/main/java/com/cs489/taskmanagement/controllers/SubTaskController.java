package com.cs489.taskmanagement.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs489.taskmanagement.model.SubTask;
import com.cs489.taskmanagement.services.SubTaskService;

import java.util.List;

@RestController
@RequestMapping("/api/subtasks")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @PostMapping
    public SubTask createSubtask(@RequestBody SubTask subTask) {
        return subTaskService.createSubTask(subTask);
    }

    @GetMapping("/{id}")
    public SubTask getSubTaskById(@PathVariable int id) {
        return subTaskService.getSubTaskById(id);
    }

    @GetMapping
    public List<SubTask> getAllSubTasks() {
        return subTaskService.getAllSubTasks();
    }

    @PutMapping("/{id}")
    public SubTask updateSubTask(@PathVariable int id, @RequestBody SubTask updatedSubTask) {
        return subTaskService.updateSubTask(id, updatedSubTask);
    }

    @DeleteMapping("/{id}")
    public void deleteSubTask(@PathVariable int id) {
        subTaskService.deleteSubTask(id);
    }
}

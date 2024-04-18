package com.cs489.taskmanagement.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs489.taskmanagement.model.SubTask;
import com.cs489.taskmanagement.repositories.SubTaskRepository;

import java.util.List;

@Service
public class SubTaskService {

    @Autowired
    private SubTaskRepository subTaskRepository;

    public SubTask createSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    public SubTask getSubTaskById(int id) {
        return subTaskRepository.findById(id).orElse(null);
    }

    public List<SubTask> getAllSubTasks() {
        return subTaskRepository.findAll();
    }

    public SubTask updateSubTask(int id, SubTask updatedSubTask) {
        SubTask existingSubtask = subTaskRepository.findById(id).orElse(null);
        if (existingSubtask != null) {
            existingSubtask.setTitle(updatedSubTask.getTitle());
            existingSubtask.setDescription(updatedSubTask.getDescription());
            existingSubtask.setPriority(updatedSubTask.getPriority());
            existingSubtask.setStatus(updatedSubTask.getStatus());
            existingSubtask.setTask(updatedSubTask.getTask());
            return subTaskRepository.save(existingSubtask);
        }
        return null;
    }

    public void deleteSubTask(int id) {
        subTaskRepository.deleteById(id);
    }
}
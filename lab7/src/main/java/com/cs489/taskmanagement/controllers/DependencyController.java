package com.cs489.taskmanagement.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs489.taskmanagement.model.Dependency;
import com.cs489.taskmanagement.services.DependencyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dependencies")
public class DependencyController {

    private final DependencyService dependencyService;

    @Autowired
    public DependencyController(DependencyService dependencyService) {
        this.dependencyService = dependencyService;
    }

    @GetMapping
    public List<Dependency> getAllDependencies() {
        return dependencyService.getAllDependencies();
    }

    @GetMapping("/{dependencyId}")
    public Optional<Dependency> getDependencyById(@PathVariable int dependencyId) {
        return dependencyService.getDependencyById(dependencyId);
    }

    @PostMapping
    public Dependency createDependency(@RequestBody Dependency dependency) {
        return dependencyService.createDependency(dependency);
    }

    @PutMapping("/{dependencyId}")
    public Dependency updateDependency(@PathVariable int dependencyId, @RequestBody Dependency updatedDependency) {
        return dependencyService.updateDependency(dependencyId, updatedDependency);
    }

    @DeleteMapping("/{dependencyId}")
    public void deleteDependency(@PathVariable int dependencyId) {
        dependencyService.deleteDependency(dependencyId);
    }
}

package com.cs489.taskmanagement.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs489.taskmanagement.model.Dependency;
import com.cs489.taskmanagement.repositories.DependencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DependencyService {

    private final DependencyRepository dependencyRepository;

    @Autowired
    public DependencyService(DependencyRepository dependencyRepository) {
        this.dependencyRepository = dependencyRepository;
    }

    public List<Dependency> getAllDependencies() {
        return dependencyRepository.findAll();
    }

    public Optional<Dependency> getDependencyById(int dependencyId) {
        return dependencyRepository.findById(dependencyId);
    }

    public Dependency createDependency(Dependency dependency) {
        return dependencyRepository.save(dependency);
    }

    public Dependency updateDependency(int dependencyId, Dependency updatedDependency) {
        return dependencyRepository.findById(dependencyId)
            .map(existingDependency -> {
                existingDependency.setPredecessorTask(updatedDependency.getPredecessorTask());
                existingDependency.setSuccessorTask(updatedDependency.getSuccessorTask());
                existingDependency.setType(updatedDependency.getType());
                return dependencyRepository.save(existingDependency);
            })
            .orElse(null);
    }

    public void deleteDependency(int dependencyId) {
        dependencyRepository.deleteById(dependencyId);
    }
}

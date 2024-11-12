package com.toDoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository
public class TaskRepository {

    private List<Tasks> tasks = new ArrayList<>();

    // Find all tasks
    public List<Tasks> findAll() {
        return tasks;
    }

    // Create a new task
    public void create(Tasks task) {
        if (task != null && findById(task.id()).isEmpty()) {
            tasks.add(task);
        } else {
            throw new IllegalArgumentException("Task with the same ID already exists");
        }
    }

    // Find a task by ID
    public Optional<Tasks> findById(Integer id) {
        return tasks.stream()
                .filter(task -> task.id().equals(id))
                .findFirst();
    }

    // Update a task (replace the old one)
    public void update(Tasks task, Integer id) {
        findById(id).ifPresent(existingTask -> {
            tasks.set(tasks.indexOf(existingTask), task);
        });
    }

    // Delete a task by ID
    public boolean delete(Integer id) {
        return tasks.removeIf(task -> task.id().equals(id));
    }

    // Initialize repository with sample data
    @PostConstruct
    private void init() {
        tasks.add(new Tasks(
            1,
            "Do a to-do list",
            TaskPriority.HIGH,
            false,
            LocalDate.now()
        ));
    }
}

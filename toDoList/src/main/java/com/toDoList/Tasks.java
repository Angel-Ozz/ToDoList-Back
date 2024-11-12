package com.toDoList;

import java.time.LocalDate;
import jakarta.validation.constraints.NotEmpty;

public class Tasks {
    private Integer id;
    @NotEmpty
    private String taskName;
    private TaskPriority taskPriority;
    private LocalDate creationDate;
    private Boolean completed;
    private LocalDate taskDueDate;

    // No-argument constructor (required for Jackson)
    public Tasks() {
    }

    // constr with dueDate
    public Tasks(Integer id, String taskName, TaskPriority taskPriority, Boolean completed, LocalDate taskDate) {
        this.id = id;
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.creationDate = LocalDate.now();
        this.completed = completed;
        this.taskDueDate = taskDate;
    }

    // constr wthout dueDate
    public Tasks(Integer id, String taskName, TaskPriority taskPriority, Boolean completed) {
        this.id = id;
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.creationDate = LocalDate.now();
        this.completed = completed;
        this.taskDueDate = null;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(LocalDate taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

}

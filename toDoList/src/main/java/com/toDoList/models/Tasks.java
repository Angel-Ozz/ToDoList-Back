package com.toDoList.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toDoList.TaskPriority;

import jakarta.validation.constraints.Size; //javax dsnt work with spring
import jakarta.validation.constraints.NotEmpty;

public class Tasks {
    @Id
    private Integer id;
    @NotEmpty
    @Size(max = 120)
    private String taskName;
    private TaskPriority taskPriority;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // USed for deserialization protection, because it was always
                                                          // setting it to null
    private LocalDate creationDate = LocalDate.now();
    private Boolean completed;
    private LocalDate taskDueDate;
    private LocalDate doneDate;

    // this bcause json serialization and des
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
        if (completed != null && completed && (this.completed == null || !this.completed)) {
            this.completed = true;
            this.doneDate = LocalDate.now();
        } else if (completed != null && !completed) {
            this.completed = false;
            this.doneDate = null;
        }
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(LocalDate taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public LocalDate getDoneDate() {
        return doneDate;
    }

}

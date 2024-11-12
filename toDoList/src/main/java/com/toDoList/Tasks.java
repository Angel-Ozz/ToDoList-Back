package com.toDoList;


import java.time.LocalDate;
import jakarta.validation.constraints.NotEmpty;

public record Tasks(

    Integer id,  
    @NotEmpty String taskName,
    TaskPriority taskPriority,
    Boolean Completed,
    LocalDate taskDueDate
    
) {
     



}

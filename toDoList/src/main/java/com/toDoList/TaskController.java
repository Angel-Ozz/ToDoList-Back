package com.toDoList;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tasks")
public class TaskController {

     private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping("")
    List<Tasks> findAll(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    Tasks findById(@PathVariable Integer id) throws Exception{

        Optional <Tasks> task = taskRepository.findById(id);
        if(task.isEmpty()){
            throw new Exception();
        }
        return task.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create (@Valid @RequestBody Tasks task){
        taskRepository.create(task);
    }

    //put
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Tasks task, @PathVariable Integer id){
        taskRepository.update(task, id);
    }
    
    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        taskRepository.delete(id);
    }

    
}

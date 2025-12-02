package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = service.createTask(task);
        return ResponseEntity.status(201).body(savedTask);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = service.findAllTask();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getById(@PathVariable long id) {
        Task task = service.findByTaskId(id);
        if(task !=null)
            return ResponseEntity.ok(task);                     // if found
        return ResponseEntity.status(404).body(null);           // if not found
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> UpdateTaskById(@PathVariable long id ,@RequestBody  Task updatedTask ){
        Task task = service.updateTask(id , updatedTask);
        if(task !=null)
            return ResponseEntity.ok(task);
        return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable long id){          // capital Void -> NoBody
        boolean deleted = service.deleteById(id);
        if(deleted)
            return ResponseEntity.noContent().build();         //204
        return ResponseEntity.status(404).build();              //Not found
    }

}

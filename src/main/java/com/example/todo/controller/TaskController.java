package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return service.createTask(task.getTitle(), task.getDescription());
    }

    @GetMapping("/tasks")
    public List<Task> findAll() {
        return service.findAllTask();
    }

    @GetMapping("/tasks/{id}")
    public Task getById(@PathVariable long id) {
        return service.getByTaskId(id);
    }

    @PutMapping("/tasks/{id}")
    public Task UpdateTaskById(@PathVariable long id , @RequestBody Task task){
        return service.updateTask(id , task);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTaskById(@PathVariable long id){
        return service.deleteById(id);
    }

}

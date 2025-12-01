package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task){
        System.out.println("Incoming title = " + task.getTitle());
        System.out.println("Incoming description = " + task.getDescription());
        return service.createTask(task.getTitle() , task.getDescription());
    }

    @GetMapping("/tasks")
    public List<Task> findAll(){
        return service.findAllTask();
    }

}

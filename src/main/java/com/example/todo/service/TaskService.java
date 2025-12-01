package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.model.TaskStatus;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;


    public Task createTask(String title , String description){
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(TaskStatus.PENDING);
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedAt(now);
        task.setUpdatedAt(now);
        return repository.save(task);
    }


    public List<Task> findAllTask(){
        return repository.findAll();
    }

    public Task getByTaskId(long id){
        if(repository.existsById(id))
            return repository.findById(id).get();
        else
            return null;
    }

    public Task updateTask(Long id , Task newData){
        if(repository.existsById(id)) {
            Task existingTask = repository.findById(id).orElse(null);
            existingTask.setTitle(newData.getTitle());
            existingTask.setDescription(newData.getDescription());
            existingTask.setStatus(newData.getStatus());
            existingTask.setUpdatedAt(LocalDateTime.now());
            return repository.save(existingTask);
        }
        return null;
    }

    public String deleteById(long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Task Deleted Successfully..!";
        }
        return  "Task Not found!";
    }
}

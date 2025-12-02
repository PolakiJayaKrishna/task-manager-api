package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.model.TaskStatus;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;


    public Task createTask(Task task) {
        task.setStatus(TaskStatus.PENDING);
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedAt(now);
        task.setUpdatedAt(now);
        return repository.save(task);
    }



    public List<Task> findAllTask(){
        return repository.findAll();
    }

    public Task findByTaskId(long id){
        return repository.findById(id).orElse(null);
    }

    public Task updateTask(Long id , Task updatedTask){
        Optional<Task> existingOptionalTask = repository.findById(id);
        if(existingOptionalTask.isPresent()){
            Task existingTask = existingOptionalTask.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setUpdatedAt(LocalDateTime.now());
            return repository.save(existingTask);
        }
        return null;
    }

    public boolean deleteById(long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;                                    // true -> Deleted
        }
        return false;                                       //false -> Not found
    }

}

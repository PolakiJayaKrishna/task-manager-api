package com.example.todo.controller;
import com.example.todo.dto.TaskRequestDTO;
import com.example.todo.dto.TaskResponseDTO;
import com.example.todo.model.TaskStatus;
import com.example.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Valid  @RequestBody TaskRequestDTO requestDTO){
         TaskResponseDTO responseDTO= service.createTask(requestDTO);
        return ResponseEntity.status(201).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction) {
        List<TaskResponseDTO> responseList = service.findAllTask(page, size , sortBy , direction);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getById(@PathVariable long id) {
        TaskResponseDTO  responseDTO = service.findByTaskId(id);
        if(responseDTO !=null)
            return ResponseEntity.ok(responseDTO);                     // if found
        return ResponseEntity.status(404).body(null);           // if not found
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTaskById(@PathVariable long id ,@Valid @RequestBody  TaskRequestDTO updatedTask ){
        TaskResponseDTO task = service.updateTask(id , updatedTask);
        if(task !=null)
            return ResponseEntity.ok(task);
        return ResponseEntity.status(404).body((Map.of("error" , "Task Not Found...")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable long id){          // capital Void -> NoBody
        boolean deleted = service.deleteById(id);
        if(deleted)
            return ResponseEntity.noContent().build();         //204
        return ResponseEntity.status(404).build();              //Not found
    }

    @GetMapping("search")
    public ResponseEntity<List<TaskResponseDTO>> searchTasks(@RequestParam("title") String title){
        List<TaskResponseDTO> results = service.searchByTitle(title);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/status")
    public ResponseEntity<List<TaskResponseDTO>> findByStatus(@RequestParam TaskStatus status){
        List<TaskResponseDTO> result = service.findTasksByStatus(status);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponseDTO> updatedStatus(@PathVariable long id , @RequestParam TaskStatus status){
        TaskResponseDTO updated = service.updateTaskStatus(id , status);
        if(updated == null) return ResponseEntity.status(404).build();
        return ResponseEntity.ok(updated);
    }
}

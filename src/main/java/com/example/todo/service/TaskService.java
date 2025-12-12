package com.example.todo.service;

import com.example.todo.dto.TaskResponseDTO;
import com.example.todo.dto.TaskRequestDTO;
import com.example.todo.model.Task;
import com.example.todo.model.TaskStatus;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;


    public TaskResponseDTO createTask(TaskRequestDTO requestDTO) {
        Task task = mapToEntity(requestDTO);
        task.setStatus(TaskStatus.PENDING);
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedAt(now);

        task.setUpdatedAt(now);
        Task savedTask = repository.save(task);
        return mapToResponseDTO(savedTask);
    }



    public List<TaskResponseDTO> findAllTask(int page , int size , String sortBy , String direction){
        Sort sort;
        if("desc".equalsIgnoreCase(direction))
            sort = Sort.by(sortBy).descending();
        else
            sort = Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size , sort);
        Page<Task> taskPage = repository.findAll(pageable);
        List<Task> tasks = taskPage.getContent();
        List<TaskResponseDTO> responseList = new ArrayList<>();
        for(Task task : tasks){
            TaskResponseDTO dto = mapToResponseDTO(task);
            responseList.add(dto);
        }
        return responseList;
    }

    public TaskResponseDTO findByTaskId(long id){
        Task task  =  repository.findById(id).orElse(null);
        if(task == null)    return null;
        return mapToResponseDTO(task);
    }

    public TaskResponseDTO updateTask(long id , TaskRequestDTO updatedTask){
        Optional<Task> existingOptionalTask = repository.findById(id);
        if(existingOptionalTask.isEmpty())  return null;
        Task existingTask = existingOptionalTask.get();
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setUpdatedAt(LocalDateTime.now());
        Task savedTask = repository.save(existingTask);
        return mapToResponseDTO(savedTask);
    }

    public boolean deleteById(long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;                                    // true -> Deleted
        }
        return false;                                       //false -> Not found
    }

    private Task mapToEntity(TaskRequestDTO dto){           // Controller ↔ Service: DTOs
        Task task = new Task();                             // Request Shape -> Memory Shape
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        return task;
    }
    private TaskResponseDTO mapToResponseDTO(Task task){    //Service ↔ Repository: Entities
        TaskResponseDTO dto = new TaskResponseDTO();        // Memory Shape -> Response Shape
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus().name());
        dto.setCreateAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());
        return dto;
    }
    public List<TaskResponseDTO> searchByTitle(String title){
        List<Task> tasks = repository.findByTitleContainingIgnoreCase(title);
        List<TaskResponseDTO> responseList = new ArrayList<>();
        for(Task task : tasks){
            TaskResponseDTO dto = mapToResponseDTO(task);
            responseList.add(dto);
        }
        return responseList;
    }

    public List<TaskResponseDTO> findTasksByStatus(TaskStatus status){
        List<Task> tasks = repository.findByStatus(status);
        List<TaskResponseDTO> responseDTOList = new ArrayList<>();
        for(Task task : tasks){
            TaskResponseDTO dto = mapToResponseDTO(task);
            responseDTOList.add(dto);
        }
        return responseDTOList;
    }

}

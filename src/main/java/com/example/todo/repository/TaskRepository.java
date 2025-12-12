package com.example.todo.repository;


import com.example.todo.model.Task;
import com.example.todo.model.TaskStatus;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleContainingIgnoreCase(String title);
    List<Task> findByStatus(TaskStatus status);
}

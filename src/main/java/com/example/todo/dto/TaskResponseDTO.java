package com.example.todo.dto;

import java.time.LocalDateTime;

public class TaskResponseDTO {                      // This DTO represents what the client receives.
    private Long id;
    private String title;
    private String description;
    private String status;                          // Status is a String, not TaskStatus, to avoid exposing internal enum structure.
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public TaskResponseDTO(){}

    public TaskResponseDTO(Long id, String title, String description, String status, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

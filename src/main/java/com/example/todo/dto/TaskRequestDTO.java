package com.example.todo.dto;

public class TaskRequestDTO {           // clean input structure with only editable fields.
    private String title;
    private String description;

    public TaskRequestDTO(){}

    public TaskRequestDTO(String title , String description){
        this.title = title;
        this.description = description;
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
}

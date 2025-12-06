package com.example.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequestDTO {           // clean input structure with only editable fields.

    @NotBlank(message = "Title is required.")
    @Size(min = 3 , max = 50 , message = "Title must be between 3 and 50 Characters")
    private String title;
    @NotBlank(message = "Description is required.")
    @Size(min = 5 , max = 200 , message = "Description must be between 5 and 200 Characters")
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

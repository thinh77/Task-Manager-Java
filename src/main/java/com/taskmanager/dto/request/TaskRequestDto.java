package com.taskmanager.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TaskRequestDto {
    @Pattern(regexp = "^[a-zA-Z0-9 ]{0,100}$", message = "Title must contain only letters, numbers and spaces and be less than 100 characters")
    private String title;
    private boolean completed=false;
}

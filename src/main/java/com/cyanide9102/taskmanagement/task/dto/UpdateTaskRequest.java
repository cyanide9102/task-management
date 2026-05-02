package com.cyanide9102.taskmanagement.task.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskRequest {

    private String title;
    private String description;
    private Boolean completed;
}

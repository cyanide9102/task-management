package com.cyanide9102.taskmanagement.task.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private Long ownerId;
}

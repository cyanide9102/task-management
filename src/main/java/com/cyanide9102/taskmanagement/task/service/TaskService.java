package com.cyanide9102.taskmanagement.task.service;

import com.cyanide9102.taskmanagement.task.dto.CreateTaskRequest;
import com.cyanide9102.taskmanagement.task.dto.TaskResponse;
import com.cyanide9102.taskmanagement.task.dto.UpdateTaskRequest;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(CreateTaskRequest dto, Long ownerId);

    List<TaskResponse> getTasksByOwner(Long ownerId);

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(Long id, UpdateTaskRequest dto);

    void deleteTask(Long id);
}

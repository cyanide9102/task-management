package com.cyanide9102.taskmanagement.task.controller;

import com.cyanide9102.taskmanagement.task.dto.CreateTaskRequest;
import com.cyanide9102.taskmanagement.task.dto.TaskResponse;
import com.cyanide9102.taskmanagement.task.dto.UpdateTaskRequest;
import com.cyanide9102.taskmanagement.task.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createTask(
            @Valid @RequestBody CreateTaskRequest request,
            Authentication authentication) {

        String ownerEmail = authentication.getName();
        return taskService.createTask(request, ownerEmail);
    }

    @GetMapping
    public List<TaskResponse> getTasksByOwner(@RequestParam Long ownerId) {

        return taskService.getTasksByOwner(ownerId);
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id) {

        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskRequest request) {

        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
    }
}

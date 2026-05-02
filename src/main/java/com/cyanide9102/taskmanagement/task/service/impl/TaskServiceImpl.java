package com.cyanide9102.taskmanagement.task.service.impl;

import com.cyanide9102.taskmanagement.common.exception.ResourceNotFoundException;
import com.cyanide9102.taskmanagement.task.dto.CreateTaskRequest;
import com.cyanide9102.taskmanagement.task.dto.TaskResponse;
import com.cyanide9102.taskmanagement.task.dto.UpdateTaskRequest;
import com.cyanide9102.taskmanagement.task.entity.Task;
import com.cyanide9102.taskmanagement.task.mapper.TaskMapper;
import com.cyanide9102.taskmanagement.task.repository.TaskRepository;
import com.cyanide9102.taskmanagement.task.service.TaskService;
import com.cyanide9102.taskmanagement.user.entity.User;
import com.cyanide9102.taskmanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public TaskResponse createTask(CreateTaskRequest dto, String ownerEmail) {

        User owner = userRepository.findByEmail(ownerEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        Task task = taskMapper.toEntity(dto, owner);

        taskRepository.save(task);

        return taskMapper.fromEntity(task);
    }

    @Override
    public List<TaskResponse> getTasksByOwner(Long ownerId) {

        List<Task> tasks = taskRepository.findByOwnerId(ownerId);

        return tasks.stream()
                .map(taskMapper::fromEntity)
                .toList();
    }

    @Override
    public TaskResponse getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found!"));

        return taskMapper.fromEntity(task);
    }

    @Override
    public TaskResponse updateTask(Long id, UpdateTaskRequest dto) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found!"));

        taskMapper.updateEntity(task, dto);

        taskRepository.save(task);

        return taskMapper.fromEntity(task);
    }

    @Override
    public void deleteTask(Long id) {

        Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(taskRepository::delete);
    }
}

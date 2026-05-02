package com.cyanide9102.taskmanagement.task.repository;

import com.cyanide9102.taskmanagement.task.entity.Task;
import com.cyanide9102.taskmanagement.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByOwner(User owner);
    List<Task> findByOwnerId(Long ownerId);
}

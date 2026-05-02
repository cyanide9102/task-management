package com.cyanide9102.taskmanagement.task.mapper;

import com.cyanide9102.taskmanagement.task.dto.CreateTaskRequest;
import com.cyanide9102.taskmanagement.task.dto.TaskResponse;
import com.cyanide9102.taskmanagement.task.dto.UpdateTaskRequest;
import com.cyanide9102.taskmanagement.task.entity.Task;
import com.cyanide9102.taskmanagement.user.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "completed", constant = "false")
    Task toEntity(CreateTaskRequest dto, User owner);

    @Mapping(target = "ownerId", source = "owner.id")
    TaskResponse fromEntity(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Task task, UpdateTaskRequest dto);
}

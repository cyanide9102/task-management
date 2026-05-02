package com.cyanide9102.taskmanagement.user.mapper;

import com.cyanide9102.taskmanagement.user.dto.CreateUserRequest;
import com.cyanide9102.taskmanagement.user.dto.UserResponse;
import com.cyanide9102.taskmanagement.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toEntity(CreateUserRequest dto);

    UserResponse fromEntity(User user);
}

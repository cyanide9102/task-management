package com.cyanide9102.taskmanagement.user.service;

import com.cyanide9102.taskmanagement.user.dto.CreateUserRequest;
import com.cyanide9102.taskmanagement.user.dto.UserResponse;

public interface UserService {

    UserResponse createUser(CreateUserRequest dto);

    UserResponse getUserById(Long id);
}

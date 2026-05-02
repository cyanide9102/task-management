package com.cyanide9102.taskmanagement.user.service.impl;

import com.cyanide9102.taskmanagement.common.exception.ResourceNotFoundException;
import com.cyanide9102.taskmanagement.user.dto.CreateUserRequest;
import com.cyanide9102.taskmanagement.user.dto.UserResponse;
import com.cyanide9102.taskmanagement.user.entity.User;
import com.cyanide9102.taskmanagement.user.mapper.UserMapper;
import com.cyanide9102.taskmanagement.user.repository.UserRepository;
import com.cyanide9102.taskmanagement.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(CreateUserRequest dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already in use!");
        }

        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user);

        return userMapper.fromEntity(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        return userMapper.fromEntity(user);
    }
}

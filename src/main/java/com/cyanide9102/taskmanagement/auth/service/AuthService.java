package com.cyanide9102.taskmanagement.auth.service;

import com.cyanide9102.taskmanagement.auth.dto.AuthResponse;
import com.cyanide9102.taskmanagement.auth.dto.LoginRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);
}

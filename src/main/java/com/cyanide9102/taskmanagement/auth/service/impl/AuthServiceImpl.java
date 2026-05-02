package com.cyanide9102.taskmanagement.auth.service.impl;

import com.cyanide9102.taskmanagement.auth.dto.AuthResponse;
import com.cyanide9102.taskmanagement.auth.dto.LoginRequest;
import com.cyanide9102.taskmanagement.auth.service.AuthService;
import com.cyanide9102.taskmanagement.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                ));

        String accessToken = jwtService.generateToken(authentication.getName());

        return new AuthResponse(accessToken);
    }
}

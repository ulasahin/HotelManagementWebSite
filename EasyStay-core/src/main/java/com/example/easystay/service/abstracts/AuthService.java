package com.example.easystay.service.abstracts;

import com.example.easystay.service.dtos.requests.auth.LoginRequest;
import com.example.easystay.service.dtos.requests.auth.RegisterRequest;
import com.example.easystay.service.dtos.responses.auth.RegisterResponse;

public interface AuthService {
    String login(LoginRequest request);
    RegisterResponse register(RegisterRequest request);
}

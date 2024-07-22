package com.example.easystay.controller;

import com.example.easystay.service.abstracts.AuthService;
import com.example.easystay.service.dtos.requests.auth.LoginRequest;
import com.example.easystay.service.dtos.requests.auth.RegisterRequest;
import com.example.easystay.service.dtos.responses.auth.RegisterResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auths")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@RequestBody RegisterRequest request){return authService.register(request);
    }
}

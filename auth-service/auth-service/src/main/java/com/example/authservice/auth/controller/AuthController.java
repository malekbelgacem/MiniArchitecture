package com.example.authservice.auth.controller;

import com.example.authservice.auth.dto.LoginRequest;
import com.example.authservice.auth.service.KeycloakTokenService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final KeycloakTokenService keycloakTokenService;

    public AuthController(KeycloakTokenService keycloakTokenService) {
        this.keycloakTokenService = keycloakTokenService;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {

        return keycloakTokenService.login(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
    }
}
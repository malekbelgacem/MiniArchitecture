package com.example.authservice.permission.service;

import com.example.authservice.permission.repository.UserPermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    private final UserPermissionRepository repository;

    public PermissionService(UserPermissionRepository repository) {
        this.repository = repository;
    }

    public boolean hasPermission(String username, String action) {
        return repository.existsByUsernameAndActionName(username, action);
    }
}
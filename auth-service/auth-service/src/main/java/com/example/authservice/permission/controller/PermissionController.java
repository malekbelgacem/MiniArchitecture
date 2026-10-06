package com.example.authservice.permission.controller;

import com.example.authservice.permission.service.PermissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/check")
    public boolean checkPermission(
            @RequestParam String username,
            @RequestParam String action
    ) {
        return permissionService.hasPermission(username, action);
    }
}
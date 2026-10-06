package com.example.authservice.permission.repository;

import com.example.authservice.permission.entity.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository
        extends JpaRepository<UserPermission, Integer> {

    boolean existsByUsernameAndActionName(
            String username,
            String actionName
    );
}
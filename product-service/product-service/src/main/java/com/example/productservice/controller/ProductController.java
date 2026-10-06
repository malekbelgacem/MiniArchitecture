package com.example.productservice.controller;

import com.example.productservice.auth.AuthClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final AuthClient authClient;

    public ProductController(AuthClient authClient) {
        this.authClient = authClient;
    }

    @GetMapping("/test-create")
    public String testCreatePermission(
            @RequestParam String username
    ) {

        boolean allowed =
                authClient.hasPermission(
                        username,
                        "CREATE_PRODUCT"
                );

        if (allowed) {
            return "ALLOWED";
        }

        return "DENIED";
    }
}
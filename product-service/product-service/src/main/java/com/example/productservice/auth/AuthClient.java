package com.example.productservice.auth;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean hasPermission(String username, String action) {

        String url =
                "http://localhost:8081/permissions/check"
                        + "?username=" + username
                        + "&action=" + action;

        Boolean result = restTemplate.getForObject(
                url,
                Boolean.class
        );

        return Boolean.TRUE.equals(result);
    }
}
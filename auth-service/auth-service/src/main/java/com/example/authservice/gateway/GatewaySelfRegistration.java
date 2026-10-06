package com.example.authservice.gateway;



import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class GatewaySelfRegistration {

    private final RestTemplate restTemplate = new RestTemplate();

    @EventListener(ApplicationReadyEvent.class)
    public void register() {

        Map<String, Object> body = new HashMap<>();

        body.put("serviceId", "auth");
        body.put("baseUrl", "http://localhost:8081");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        restTemplate.postForEntity(
                "http://localhost:8080/internal/gateway/register",
                request,
                String.class
        );

        System.out.println("Auth service registered with Gateway");
    }
}
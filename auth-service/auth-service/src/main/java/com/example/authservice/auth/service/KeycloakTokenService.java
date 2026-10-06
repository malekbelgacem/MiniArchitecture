package com.example.authservice.auth.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class KeycloakTokenService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> login(String username, String password) {

        String tokenUrl =
                "http://localhost:8085/realms/MiniArchitecture/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        body.add("grant_type", "password");
        body.add("client_id", "mini-auth-client");
        body.add("username", username);
        body.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    tokenUrl,
                    HttpMethod.POST,
                    request,
                    Map.class
            );

            return response.getBody();

        } catch (HttpClientErrorException ex) {
            System.out.println("KEYCLOAK STATUS: " + ex.getStatusCode());
            System.out.println("KEYCLOAK RESPONSE: " + ex.getResponseBodyAsString());
            throw ex;
        }
    }
}
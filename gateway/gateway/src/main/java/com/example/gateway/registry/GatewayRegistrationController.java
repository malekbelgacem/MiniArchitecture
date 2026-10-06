package com.example.gateway.registry;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/internal/gateway")
public class GatewayRegistrationController {

    private final ServiceRegistry serviceRegistry;

    public GatewayRegistrationController(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    @PostMapping("/register")
    public String register(@RequestBody ServiceRegistration registration) {

        serviceRegistry.register(registration);

        return "Service registered: " + registration.getServiceId();
    }

    @GetMapping("/services")
    public Collection<ServiceRegistration> getServices() {
        return serviceRegistry.getAllServices();
    }
}
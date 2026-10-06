package com.example.gateway.registry;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServiceRegistry {

    private final Map<String, ServiceRegistration> services =
            new ConcurrentHashMap<>();

    public void register(ServiceRegistration registration) {
        services.put(registration.getServiceId(), registration);
    }

    public Collection<ServiceRegistration> getAllServices() {
        return services.values();
    }
}
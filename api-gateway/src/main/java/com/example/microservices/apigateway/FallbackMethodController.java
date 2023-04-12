package com.example.microservices.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {
    @GetMapping("/fallback/{serviceName}")
    public String fallback(@PathVariable String serviceName) {
        System.out.println("Reached the Method but seems like error");
        return ("The " + serviceName + " service is taking too long to respond. Please try again later.");
    }
}

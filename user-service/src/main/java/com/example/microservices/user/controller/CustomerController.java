package com.example.microservices.user.controller;

import com.example.microservices.user.entity.Customer;
import com.example.microservices.user.services.CustomerService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class CustomerController {
    private final Tracer tracer;

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService, Tracer tracer) {
        this.customerService = customerService;
        this.tracer = tracer;
    }

    @GetMapping("/{id}")
    public Customer getUserById(@PathVariable Long id){
        Span span = tracer.buildSpan("Customer Service").start();
        span.setTag("userById", "userById");
        span.finish();
        return customerService.getUserById(id);
    }
    @PostMapping("/")
    public Customer createUser(@RequestBody Customer customer){
        Span span = tracer.buildSpan("Customer Service").start();
        span.setTag("createUser", "createUser");
        span.finish();
        return customerService.createUser(customer);
    }
}

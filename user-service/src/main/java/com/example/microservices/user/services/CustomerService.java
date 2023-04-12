package com.example.microservices.user.services;

import com.example.microservices.user.entity.Customer;

public interface CustomerService{
    Customer getUserById(Long id);

    Customer createUser(Customer customer);
}

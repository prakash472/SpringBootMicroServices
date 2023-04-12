package com.example.microservices.user.services;

import com.example.microservices.user.entity.Customer;
import com.example.microservices.user.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getUserById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer createUser(Customer customer) {
        log.info("Creating the users");
        return customerRepository.save(customer);
    }
}

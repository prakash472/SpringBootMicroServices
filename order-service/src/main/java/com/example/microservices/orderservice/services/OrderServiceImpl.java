package com.example.microservices.orderservice.services;

import com.example.microservices.orderservice.entity.OrderEntity;
import com.example.microservices.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository oderRepository;

    public OrderServiceImpl(OrderRepository oderRepository) {
        this.oderRepository = oderRepository;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return oderRepository.findAll();
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        oderRepository.save(order);
        return order;
    }

    @Override
    public OrderEntity getOrdersById(Long id) {
        return oderRepository.findById(id).get();
    }
}

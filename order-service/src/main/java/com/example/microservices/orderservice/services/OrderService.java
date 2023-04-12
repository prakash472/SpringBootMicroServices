package com.example.microservices.orderservice.services;

import com.example.microservices.orderservice.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getAllOrders();

    OrderEntity createOrder(OrderEntity order);

    OrderEntity getOrdersById(Long id);
}

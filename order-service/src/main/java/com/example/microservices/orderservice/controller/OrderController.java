package com.example.microservices.orderservice.controller;

import com.example.microservices.orderservice.OrderDetailsVO.Customer;
import com.example.microservices.orderservice.OrderDetailsVO.OrderDetailsVO;
import com.example.microservices.orderservice.OrderDetailsVO.Product;
import com.example.microservices.orderservice.entity.OrderEntity;
import com.example.microservices.orderservice.services.OrderService;
import io.opentracing.Span;
import io.opentracing.Tracer;

import lombok.extern.slf4j.Slf4j;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {
    private final RestTemplate restTemplate;
    private final OrderService orderService;

    private final Tracer tracer;

    public OrderController(OrderService orderService, RestTemplate restTemplate, Tracer tracer) {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
        this.tracer = tracer;
    }

    @GetMapping("/")
    public List<OrderEntity> getAllOrders(){
        return orderService.getAllOrders();
    }
    @PostMapping("/")
    public OrderEntity createOrder(@RequestBody OrderEntity order){
        return orderService.createOrder(order);
    }
//    @GetMapping("/{id}")
//    public OrderDetailsVO getOrderDetailsById(@PathVariable Long id) {
//        Span span = tracer.buildSpan("Order Service").start();
//        span.setTag("orderDetails", "orderDetails");
//        log.info("Getting the Order Details by Id");
//        OrderEntity orderEntity = orderService.getOrdersById(id);
//        Product product=restTemplate.getForObject("http://PRODUCT-SERVICE/products/"+orderEntity.getProductId(),Product.class);
//        Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/users/"+orderEntity.getCustomerId(),Customer.class);
//        OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
//        orderDetailsVO.setOrderId(id);
//        orderDetailsVO.setProductName(product.getName());
//        orderDetailsVO.setCustomerName(customer.getName());
//        orderDetailsVO.setPurchaseDate(orderEntity.getPurchaseDate());
//        span.finish();
//        return orderDetailsVO;
//    }
    @GetMapping("/{id}")
    public OrderDetailsVO getOrderDetailsById(@PathVariable Long id) {
        Span oderSpan = tracer.buildSpan("Order Service").start();
        oderSpan.setTag("orderDetails", "orderDetails");

        OrderEntity orderEntity = orderService.getOrdersById(id);

        // Creating a new span for the ORDER-SERVICE call with parent span set ot the current span
        Span productSpan = tracer.buildSpan("Product Service").asChildOf(oderSpan).start();
        Product product=restTemplate.getForObject("http://PRODUCT-SERVICE/products/"+orderEntity.getProductId(),Product.class);
        productSpan.finish();

        // Create a new span for the CUSTOMER-SERVICE call with parent span set to the current span
        Span customerSpan = tracer.buildSpan("Customer Service").asChildOf(oderSpan).start();
        Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/users/"+orderEntity.getCustomerId(),Customer.class);
        customerSpan.finish();

        OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
        orderDetailsVO.setOrderId(id);
        orderDetailsVO.setProductName(product.getName());
        orderDetailsVO.setCustomerName(customer.getName());
        orderDetailsVO.setPurchaseDate(orderEntity.getPurchaseDate());
        oderSpan.finish();
        return orderDetailsVO;
    }

}

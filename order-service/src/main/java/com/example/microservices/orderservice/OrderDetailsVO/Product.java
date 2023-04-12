package com.example.microservices.orderservice.OrderDetailsVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data@NoArgsConstructor@AllArgsConstructor
public class Product {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
}

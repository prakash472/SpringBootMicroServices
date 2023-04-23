package com.example.microservices.orderservice.OrderDetailsVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsVO {
    private Long orderId;
    private String productName;
    private String customerName;
    private LocalDate purchaseDate;
}

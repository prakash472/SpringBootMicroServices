package com.example.microservices.productservice.services;

import com.example.microservices.productservice.entity.Product;

public interface ProductService {
    Product getProductById(Long id);

    Product createProduct(Product product);
}

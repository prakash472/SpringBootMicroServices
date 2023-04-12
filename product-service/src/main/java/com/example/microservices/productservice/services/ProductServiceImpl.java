package com.example.microservices.productservice.services;

import com.example.microservices.productservice.entity.Product;
import com.example.microservices.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        log.info("Getting the Product by Id");
        return productRepository.findById(id).get();
    }

    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}


package com.example.microservices.productservice.controller;

import com.example.microservices.productservice.entity.Product;
import com.example.microservices.productservice.services.ProductService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {
    private final ProductService productService;
    private final Tracer tracer;
    public ProductController(ProductService productService, Tracer tracer) {
        this.productService = productService;
        this.tracer = tracer;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        Span span = tracer.buildSpan("Product Service").start();
        span.setTag("getProduct", "getProduct");
        span.finish();
        return productService.getProductById(id);
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        Span span = tracer.buildSpan("Product Service").start();
        span.setTag("createProduct", "createProduct");
        span.finish();
        return productService.createProduct(product);
    }
}

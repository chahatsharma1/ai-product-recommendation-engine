package com.ai.recommendation.ai_product_recommendation_engine.controller;

import com.ai.recommendation.ai_product_recommendation_engine.entity.Product;
import com.ai.recommendation.ai_product_recommendation_engine.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepo;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }
}
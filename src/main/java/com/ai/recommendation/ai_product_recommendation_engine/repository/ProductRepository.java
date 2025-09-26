package com.ai.recommendation.ai_product_recommendation_engine.repository;

import com.ai.recommendation.ai_product_recommendation_engine.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
package com.ai.recommendation.ai_product_recommendation_engine.repository;

import com.ai.recommendation.ai_product_recommendation_engine.entity.BrowsingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrowsingHistoryRepository extends JpaRepository<BrowsingHistory, Long> {
    List<BrowsingHistory> findTop10ByUserIdOrderByTimestampDesc(Long userId);
}
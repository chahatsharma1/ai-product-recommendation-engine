package com.ai.recommendation.ai_product_recommendation_engine.service;

import com.ai.recommendation.ai_product_recommendation_engine.repository.BrowsingHistoryRepository;
import com.ai.recommendation.ai_product_recommendation_engine.repository.ProductRepository;
import com.ai.recommendation.ai_product_recommendation_engine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final UserRepository userRepo;
    private final ProductRepository productRepo;
    private final BrowsingHistoryRepository historyRepo;
    private final LLMService llmService;

    public String generateRecommendations(Long userId) {
        var user = userRepo.findById(userId).orElseThrow();
        var history = historyRepo.findTop10ByUserIdOrderByTimestampDesc(userId);
        var products = productRepo.findAll();

        // Build prompt for AI
        StringBuilder prompt = new StringBuilder();
        prompt.append("User Preferences: ").append(user.getPreferences()).append("\n");
        prompt.append("Browsing History: ").append(history).append("\n");
        prompt.append("Available Products: ").append(products).append("\n");
        prompt.append("Recommend 3 products as JSON [{productId, reason}]");

        return llmService.getRecommendations(prompt.toString());
    }
}

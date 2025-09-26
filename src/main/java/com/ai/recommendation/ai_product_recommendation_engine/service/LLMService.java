package com.ai.recommendation.ai_product_recommendation_engine.service;

import org.springframework.stereotype.Service;

@Service
public class LLMService {

    public String getRecommendations(String prompt) {
        // TODO: Call OpenAI / Gemini API here
        return """
        [
          {"productId": 1, "reason": "Matches browsing history"},
          {"productId": 2, "reason": "Fits your budget and style"}
        ]
        """;
    }
}

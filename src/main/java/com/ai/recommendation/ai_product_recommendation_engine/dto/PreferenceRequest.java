package com.ai.recommendation.ai_product_recommendation_engine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreferenceRequest {
    private String budget;
    private String style;
    private List<String> categories;
}

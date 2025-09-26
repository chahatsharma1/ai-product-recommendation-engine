package com.ai.recommendation.ai_product_recommendation_engine.controller;

import com.ai.recommendation.ai_product_recommendation_engine.entity.BrowsingHistory;
import com.ai.recommendation.ai_product_recommendation_engine.repository.BrowsingHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class HistoryController {
    private final BrowsingHistoryRepository historyRepo;

    @PostMapping
    public BrowsingHistory addHistory(@RequestBody BrowsingHistory history) {
        history.setTimestamp(LocalDateTime.now());
        return historyRepo.save(history);
    }

    @GetMapping("/{userId}")
    public List<BrowsingHistory> getHistory(@PathVariable Long userId) {
        return historyRepo.findTop10ByUserIdOrderByTimestampDesc(userId);
    }
}

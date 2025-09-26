package com.ai.recommendation.ai_product_recommendation_engine.controller;

import com.ai.recommendation.ai_product_recommendation_engine.entity.User;
import com.ai.recommendation.ai_product_recommendation_engine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/preferences")
@RequiredArgsConstructor
public class PreferenceController {
    private final UserRepository userRepo;

    @PostMapping("/{userId}")
    public ResponseEntity<User> updatePreferences(@PathVariable Long userId, @RequestBody String preferences) {
        Optional<User> user = userRepo.findById(userId);


        return userRepo.findById(userId)
                .map(user -> {
                    user.setPreferences(preferences);
                    return ResponseEntity.ok(userRepo.save(user));
                }
                ).orElse(ResponseEntity.notFound().build());
    }
}

package com.ai.recommendation.ai_product_recommendation_engine.controller;

import com.ai.recommendation.ai_product_recommendation_engine.dto.MessageResponse;
import com.ai.recommendation.ai_product_recommendation_engine.dto.PreferenceRequest;
import com.ai.recommendation.ai_product_recommendation_engine.entity.User;
import com.ai.recommendation.ai_product_recommendation_engine.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/preferences")
@RequiredArgsConstructor
public class PreferenceController {
    private final UserRepository userRepo;
    private final ObjectMapper objectMapper;

    @PostMapping("/{userId}")
    public ResponseEntity<MessageResponse> updatePreferences(@PathVariable Long userId, @RequestBody PreferenceRequest request) {
        Optional<User> optionalUser = userRepo.findById(userId);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageResponse("User Does Not Exist"));
        }

        User user = optionalUser.get();

        try {
            String jsonPrefs = objectMapper.writeValueAsString(request);
            user.setPreferences(jsonPrefs);
            userRepo.save(user);

            return ResponseEntity.ok().body(new MessageResponse("Preferences Updated"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse("Invalid preferences format"));
        }

    }
}
package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.ChallengeRequest;
import me.yejinkim.springboot.dto.ChallengeResponse;
import me.yejinkim.springboot.service.ChallengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {
    private final ChallengeService ChallengeService;

    @PostMapping("/submit")
    public ResponseEntity<ChallengeResponse> submitChallenge(@RequestBody ChallengeRequest request, Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();
        ChallengeResponse response = ChallengeService.submitChallenge(userId, request);
        return ResponseEntity.ok(response);
    }
}


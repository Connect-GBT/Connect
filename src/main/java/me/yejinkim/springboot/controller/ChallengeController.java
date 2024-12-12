package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.ChallengeRequest;
import me.yejinkim.springboot.dto.ChallengeResponse;
import me.yejinkim.springboot.service.ChallengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping("/submit")
    public ResponseEntity<ChallengeResponse> submitChallenge(@RequestBody ChallengeRequest request, Authentication authentication) {
        // UserDetails 타입으로 사용자 정보 가져오기
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername(); // username을 사용하여 ID 조회 필요

        // ChallengeService에서 username을 사용해 userId를 조회하거나 필요한 로직을 수행
        Long userId = challengeService.getUserIdByUsername(username); // 추가된 메서드를 통해 userId 조회

        // ChallengeService를 통해 챌린지 제출 로직 처리
        ChallengeResponse response = challengeService.submitChallenge(userId, request);
        return ResponseEntity.ok(response);
    }
}

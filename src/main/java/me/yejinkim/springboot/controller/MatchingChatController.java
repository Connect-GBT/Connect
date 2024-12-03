package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.MatchingRequest;
import me.yejinkim.springboot.dto.MatchingResponse;
import me.yejinkim.springboot.service.MatchingChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/matching-chat")
public class MatchingChatController {

    private final MatchingChatService matchingChatService;

    @PostMapping("/match")
    public ResponseEntity<MatchingResponse> matchUsers(@RequestBody MatchingRequest request) {
        MatchingResponse response = matchingChatService.matchUsers(request);
        return ResponseEntity.ok(response);
    }
}

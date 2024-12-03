package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.ChatbotCounselingRequest;
import me.yejinkim.springboot.dto.ChatbotCounselingResponse;
import me.yejinkim.springboot.service.ChatbotCounselingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chatbot-counseling")
public class ChatbotCounselingController {

    private final ChatbotCounselingService chatbotCounselingService;

    @PostMapping("/counsel")
    public ResponseEntity<ChatbotCounselingResponse> counselUser(@RequestBody ChatbotCounselingRequest request) {
        ChatbotCounselingResponse response = chatbotCounselingService.counselUser(request);
        return ResponseEntity.ok(response);
    }
}

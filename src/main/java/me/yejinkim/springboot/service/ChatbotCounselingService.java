package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.ChatbotCounselingRequest;
import me.yejinkim.springboot.dto.ChatbotCounselingResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public class ChatbotCounselingService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String HUGGING_FACE_API_URL = "https://api-inference.huggingface.co/models/your-chatbot-model";
    private static final String HUGGING_FACE_API_KEY = "huggingface-api-key";

    public ChatbotCounselingResponse counselUser(ChatbotCounselingRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + HUGGING_FACE_API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(request.getUserMessage(), headers);

        ResponseEntity<String> response = restTemplate.exchange(
                HUGGING_FACE_API_URL,
                HttpMethod.POST,
                entity,
                String.class
        );

        String counselingResponse = response.getBody();
        return new ChatbotCounselingResponse(counselingResponse);
    }
}
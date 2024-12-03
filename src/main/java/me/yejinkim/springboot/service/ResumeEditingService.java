package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.ResumeEditRequest;
import me.yejinkim.springboot.dto.ResumeEditResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ResumeEditingService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String HUGGING_FACE_API_URL = "api";
    private static final String HUGGING_FACE_API_KEY = "api-key";

    public ResumeEditResponse editResume(ResumeEditRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + HUGGING_FACE_API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(request.getResumeText(), headers);

        ResponseEntity<String> response = restTemplate.exchange(
                HUGGING_FACE_API_URL,
                HttpMethod.POST,
                entity,
                String.class
        );

        String improvedText = response.getBody();
        return new ResumeEditResponse(improvedText);
    }
}

package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.StageDiagnosisRequest;
import me.yejinkim.springboot.dto.StageDiagnosisResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StageDiagnosisService {

    public StageDiagnosisResponse diagnoseStage(StageDiagnosisRequest request) {
        int score = calculateScore(request);
        String stage = determineStage(score);
        return new StageDiagnosisResponse(stage, "Your current diagnosis stage is: " + stage);
    }

    private int calculateScore(StageDiagnosisRequest request) {
        // Sample logic to calculate score based on user responses
        return request.getResponses().stream().mapToInt(Integer::intValue).sum();
    }

    private String determineStage(int score) {
        if (score < 10) {
            return "Stage 1";
        } else if (score < 20) {
            return "Stage 2";
        } else {
            return "Stage 3";
        }
    }
}

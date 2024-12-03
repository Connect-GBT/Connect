package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.TextSimulationRequest;
import me.yejinkim.springboot.dto.TextSimulationResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TextSimulationService {

    public TextSimulationResponse runSimulation(TextSimulationRequest request) {
        String feedback = "Your response was appropriate.";
        if (!isCorrectResponse(request.getUserResponse())) {
            feedback = "Your response could be improved. Consider being more empathetic.";
        }
        return new TextSimulationResponse(feedback);
    }

    private boolean isCorrectResponse(String response) {
        // Sample logic to determine if the response is correct
        return response.toLowerCase().contains("thank you");
    }
}

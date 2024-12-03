package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.TextSimulationRequest;
import me.yejinkim.springboot.dto.TextSimulationResponse;
import me.yejinkim.springboot.service.TextSimulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/text-simulation")
public class TextSimulationController {

    private final TextSimulationService textSimulationService;

    @PostMapping
    public ResponseEntity<TextSimulationResponse> runTextSimulation(@RequestBody TextSimulationRequest request) {
        TextSimulationResponse response = textSimulationService.runSimulation(request);
        return ResponseEntity.ok(response);
    }
}

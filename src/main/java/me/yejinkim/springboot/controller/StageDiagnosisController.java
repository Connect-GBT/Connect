package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.StageDiagnosisRequest;
import me.yejinkim.springboot.dto.StageDiagnosisResponse;
import me.yejinkim.springboot.service.StageDiagnosisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stage-diagnosis")
public class StageDiagnosisController {

    private final StageDiagnosisService stageDiagnosisService;

    @PostMapping
    public ResponseEntity<StageDiagnosisResponse> diagnoseStage(@RequestBody StageDiagnosisRequest request) {
        StageDiagnosisResponse response = stageDiagnosisService.diagnoseStage(request);
        return ResponseEntity.ok(response);
    }
}

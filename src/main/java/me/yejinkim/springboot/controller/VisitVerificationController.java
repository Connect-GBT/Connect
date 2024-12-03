package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.VisitVerificationRequest;
import me.yejinkim.springboot.dto.VisitVerificationResponse;
import me.yejinkim.springboot.service.VisitVerificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/visit")
public class VisitVerificationController {

    private final VisitVerificationService visitVerificationService;

    @PostMapping("/verify")
    public ResponseEntity<VisitVerificationResponse> verifyVisit(@RequestBody VisitVerificationRequest request) {
        VisitVerificationResponse response = visitVerificationService.verifyVisit(request);
        return ResponseEntity.ok(response);
    }
}

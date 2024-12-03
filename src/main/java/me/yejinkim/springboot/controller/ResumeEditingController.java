package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.ResumeEditRequest;
import me.yejinkim.springboot.dto.ResumeEditResponse;
import me.yejinkim.springboot.service.ResumeEditingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/resume-editing")
public class ResumeEditingController {

    private final ResumeEditingService resumeEditingService;

    @PostMapping("/edit")
    public ResponseEntity<ResumeEditResponse> editResume(@RequestBody ResumeEditRequest request) {
        ResumeEditResponse response = resumeEditingService.editResume(request);
        return ResponseEntity.ok(response);
    }
}

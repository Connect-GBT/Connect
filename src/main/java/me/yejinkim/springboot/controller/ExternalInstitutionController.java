package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.InstitutionResponse;
import me.yejinkim.springboot.service.ExternalInstitutionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/external-institutions")
public class ExternalInstitutionController {

    private final ExternalInstitutionService externalInstitutionService;

    @GetMapping
    public ResponseEntity<List<InstitutionResponse>> getInstitutions() {
        List<InstitutionResponse> institutions = externalInstitutionService.getAllInstitutions();
        return ResponseEntity.ok(institutions);
    }
}

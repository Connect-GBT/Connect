package me.yejinkim.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StageDiagnosisResponse {
    private String stage;
    private String message;
}

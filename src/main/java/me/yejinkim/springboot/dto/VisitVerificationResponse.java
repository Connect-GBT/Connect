package me.yejinkim.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VisitVerificationResponse {
    private boolean success;
    private String message;
}

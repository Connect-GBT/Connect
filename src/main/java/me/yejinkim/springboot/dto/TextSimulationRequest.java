package me.yejinkim.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TextSimulationRequest {
    private String scenario;
    private String userResponse;
}

package me.yejinkim.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitVerificationRequest {
    private double latitude;
    private double longitude;
    private Long targetLocationId;
}

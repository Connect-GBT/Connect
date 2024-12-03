package me.yejinkim.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InstitutionResponse {
    private String name;
    private String description;
    private String link;
}

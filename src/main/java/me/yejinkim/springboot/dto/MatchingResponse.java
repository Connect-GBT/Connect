package me.yejinkim.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MatchingResponse {
    private String matchedUser;
    private String message;
}

package me.yejinkim.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MatchingRequest {
    private List<String> interests;
}

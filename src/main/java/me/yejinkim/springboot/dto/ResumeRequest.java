package me.yejinkim.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResumeRequest {
    private String title;
    private String content;
}

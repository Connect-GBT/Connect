package me.yejinkim.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewsletterResponse {
    private String title;
    private String content;
}

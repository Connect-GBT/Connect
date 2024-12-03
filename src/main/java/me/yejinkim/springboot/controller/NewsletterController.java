package me.yejinkim.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.NewsletterResponse;
import me.yejinkim.springboot.service.NewsletterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/newsletter")

public class NewsletterController {
    private final NewsletterService newsletterService;

    @GetMapping("/today")
    public ResponseEntity<NewsletterResponse> getTodayNewsletter() {
        NewsletterResponse response = newsletterService.getTodayNewsletter();
        return ResponseEntity.ok(response);
    }

}





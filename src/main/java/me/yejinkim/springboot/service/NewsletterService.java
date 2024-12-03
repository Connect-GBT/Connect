package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.domain.Newsletter;
import me.yejinkim.springboot.dto.NewsletterResponse;
import me.yejinkim.springboot.repository.NewsletterRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NewsletterService {

    private final NewsletterRepository newsletterRepository;

    public NewsletterResponse getTodayNewsletter() {
        Newsletter todayNewsletter = newsletterRepository.findTopByOrderByDateDesc()
                .orElseThrow(() -> new IllegalArgumentException("No newsletter found for today."));
        return new NewsletterResponse(todayNewsletter.getTitle(), todayNewsletter.getContent());
    }
}

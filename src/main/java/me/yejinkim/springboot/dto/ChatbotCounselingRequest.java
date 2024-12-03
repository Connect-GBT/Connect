package me.yejinkim.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatbotCounselingRequest {
    private String userMessage;

    public ChatbotCounselingRequest(String userMessage) {
        this.userMessage = userMessage;
    }
}



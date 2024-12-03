package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.MatchingRequest;
import me.yejinkim.springboot.dto.MatchingResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchingChatService {

    public MatchingResponse matchUsers(MatchingRequest request) {
        // Sample logic to match users based on their interests
        String matchedUser = "User123"; // This should be replaced with matching logic
        return new MatchingResponse(matchedUser, "You have been matched with: " + matchedUser);
    }
}

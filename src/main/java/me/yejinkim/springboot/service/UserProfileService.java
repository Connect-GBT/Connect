package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.domain.User;
import me.yejinkim.springboot.dto.UserProfileResponse;
import me.yejinkim.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserProfileService {

    private final UserRepository userRepository;

    public UserProfileResponse getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserProfileResponse(user.getNickname(), user.getProfilePictureUrl(), user.getCurrentDay());
    }
}

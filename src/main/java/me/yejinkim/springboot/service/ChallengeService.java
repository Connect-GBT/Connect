package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.domain.ChallengePost;
import me.yejinkim.springboot.domain.User;
import me.yejinkim.springboot.dto.ChallengeRequest;
import me.yejinkim.springboot.dto.ChallengeResponse;
import me.yejinkim.springboot.repository.ChallengeRepository;
import me.yejinkim.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final UserRepository userRepository;

    public ChallengeResponse submitChallenge(Long userId, ChallengeRequest request) {
        ChallengePost challengePost = ChallengePost.builder()
                .userId(userId)
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        challengeRepository.save(challengePost);
        return new ChallengeResponse("챌린지가 성공적으로 제출되었습니다.");
    }

    public Optional<User> getUserIdByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    public Long getUserIdByUsername(String username) {
        return userRepository.findByNickname(username)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + username))
                .getId();
    }
}
package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.domain.ChallengePost;
import me.yejinkim.springboot.dto.ChallengeRequest;
import me.yejinkim.springboot.dto.ChallengeResponse;
import me.yejinkim.springboot.repository.ChallengeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public ChallengeResponse submitChallenge(Long userId, ChallengeRequest request) {
        ChallengePost challengePost = ChallengePost.builder()
                .userId(userId)
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        challengeRepository.save(challengePost);
        return new ChallengeResponse("챌린지가 성공적으로 제출되었습니다.");
    }
}

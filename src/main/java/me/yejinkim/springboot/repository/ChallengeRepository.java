package me.yejinkim.springboot.repository;

import me.yejinkim.springboot.domain.ChallengePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<ChallengePost, Long> {
}



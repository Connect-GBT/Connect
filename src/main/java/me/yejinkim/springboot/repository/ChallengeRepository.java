package me.yejinkim.springboot.repository;

import me.yejinkim.springboot.domain.ChallengePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<ChallengePost, Long> {

    // Find all ChallengePosts by a specific userId
    List<ChallengePost> findByUserId(Long userId);

    // Custom query to find ChallengePosts by title containing a keyword
    @Query("SELECT c FROM ChallengePost c WHERE c.title LIKE %:keyword%")
    List<ChallengePost> findByTitleContaining(@Param("keyword") String keyword);
}
package me.yejinkim.springboot.repository;

import me.yejinkim.springboot.domain.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {
    Optional<Newsletter> findTopByOrderByDateDesc();
}

package me.yejinkim.springboot.repository;

import me.yejinkim.springboot.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}

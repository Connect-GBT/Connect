package me.yejinkim.springboot.repository;

import me.yejinkim.springboot.domain.TargetLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetLocationRepository extends JpaRepository<TargetLocation, Long> {
}

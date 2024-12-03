package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.dto.InstitutionResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class ExternalInstitutionService {

    public List<InstitutionResponse> getAllInstitutions() {
        return Stream.of(
                new InstitutionResponse("Local Community Center", "A community-driven center offering various social activities.", "https://community-center.com"),
                new InstitutionResponse("Tech Meetup Group", "A group for tech enthusiasts to learn and network.", "https://tech-meetup.com"),
                new InstitutionResponse("Volunteer Organization", "An organization that provides volunteer opportunities.", "https://volunteer.org")
        ).collect(Collectors.toList());
    }
}

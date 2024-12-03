package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.domain.TargetLocation;
import me.yejinkim.springboot.dto.VisitVerificationRequest;
import me.yejinkim.springboot.dto.VisitVerificationResponse;
import me.yejinkim.springboot.repository.TargetLocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VisitVerificationService {

    private final TargetLocationRepository targetLocationRepository;

    public VisitVerificationResponse verifyVisit(VisitVerificationRequest request) {
        Optional<TargetLocation> targetLocationOpt = targetLocationRepository.findById(request.getTargetLocationId());

        if (targetLocationOpt.isPresent()) {
            TargetLocation targetLocation = targetLocationOpt.get();
            double distance = calculateDistance(request.getLatitude(), request.getLongitude(),
                    targetLocation.getLatitude(), targetLocation.getLongitude());

            if (distance <= 50.0) {
                return new VisitVerificationResponse(true, "Verification successful.");
            } else {
                return new VisitVerificationResponse(false, "You are not at the target location.");
            }
        } else {
            return new VisitVerificationResponse(false, "Target location not found.");
        }
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c * 1000;
    }
}

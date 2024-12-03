package me.yejinkim.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfileResponse {
    private String nickname;
    private String profilePictureUrl;
    private int currentDay;
}

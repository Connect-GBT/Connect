package me.yejinkim.springboot.service;

import lombok.RequiredArgsConstructor;
import me.yejinkim.springboot.domain.User;
import me.yejinkim.springboot.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String nickname) {
        return userRepository.findByNickname(nickname)
                .orElseThrow(() -> new IllegalArgumentException((nickname + " not found")));
    }
}
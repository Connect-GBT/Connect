package me.yejinkim.springboot.controller.repository;

import me.yejinkim.springboot.domain.User;
import me.yejinkim.springboot.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @DisplayName("닉네임으로 사용자 찾기에 성공하였습니다.")
    @Test
    public void shouldFindUserByNickname() {
        User user = User.builder()
                .nickname("nickname")
                .password("password")
                .nickname("testUser")
                .build();
        userRepository.save(user);

        Optional<User> found = userRepository.findByNickname("testUser");
        assertTrue(found.isPresent());
    }

}


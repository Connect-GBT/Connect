package me.yejinkim.springboot.controller.repository;

import me.yejinkim.springboot.domain.User;
import me.yejinkim.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void shouldFindUserByEmail() {
        User user = User.builder()
                .email("test@example.com")
                .password("password") // 필요한 필드 추가
                .nickname("testUser") // 필요한 필드 추가
                .build();
        userRepository.save(user);

        Optional<User> found = userRepository.findByEmail("test@example.com");
        assertTrue(found.isPresent());
    }

}

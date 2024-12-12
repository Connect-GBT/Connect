package me.yejinkim.springboot.controller.controller;

import me.yejinkim.springboot.controller.ChallengeController;
import me.yejinkim.springboot.repository.ChallengeRepository;
import me.yejinkim.springboot.service.ChallengeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@AutoConfigureMockMvc
public class ChallengeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChallengeService challengeService;

    @DisplayName("챌린지 제출 API 테스트에 성공하였습니다.")
    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void shouldReturn200WhenSubmitChallenge() throws Exception {
        mockMvc.perform(post("/api/challenge/submit")
                        .contentType("application/json")
                        .content("{\"title\": \"Challenge Title\", \"content\": \"Challenge Content\"}"))
                .andExpect(status().isOk());
    }
}


package me.yejinkim.springboot.controller.controller;

import me.yejinkim.springboot.controller.ChallengeController;
import me.yejinkim.springboot.service.ChallengeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChallengeController.class)
public class ChallengeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChallengeService challengeService; // 서비스 계층을 목 객체로 주입
    @Test
    public void shouldReturn200WhenSubmitChallenge() throws Exception {
        mockMvc.perform(post("/api/challenge/submit")
                        .contentType("application/json")
                        .content("{\"title\": \"Challenge Title\", \"content\": \"Challenge Content\"}"))
                .andExpect(status().isOk());

    }
}
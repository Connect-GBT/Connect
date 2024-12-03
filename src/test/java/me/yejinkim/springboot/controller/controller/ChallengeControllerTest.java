package me.yejinkim.springboot.controller.controller;

import me.yejinkim.springboot.controller.ChallengeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChallengeController.class)
public class ChallengeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200WhenGetChallenge() throws Exception {
        mockMvc.perform(get("/api/challenge"))
                .andExpect(status().isOk());
    }
}

package com.password.password.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.password.infra.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.password.password.domain.usecase.CheckPasswordUseCase.CheckPassword;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
class CheckPasswordIntegrationTest {

    private final String PATH = "/api/v1/password/check";

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldReturnOk() throws Exception {
        var cmd = CheckPassword.builder()
                .password(null)
                .build();

        var response = this.mock.perform(MockMvcRequestBuilders.post(PATH)
                .contentType(APPLICATION_JSON)
                .content(mapper.writeValueAsString(cmd)))
                .andExpect(status().isOk());
    }
}

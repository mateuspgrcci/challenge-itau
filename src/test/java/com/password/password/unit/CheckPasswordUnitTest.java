package com.password.password.unit;


import com.password.password.domain.service.CheckPasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.password.password.domain.usecase.CheckPasswordUseCase.CheckPassword;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPasswordUnitTest {

    private CheckPasswordService service;

    private CheckPassword.CheckPasswordBuilder builder;

    @BeforeEach
    void beforeEach() {
        service = new CheckPasswordService();

        builder = CheckPassword.builder().password("");
    }

    @Test
    void shouldReturnValidPassword() {
        var command = builder.password("AbTp9!fok").build();
        assertTrue(service.handle(command));
    }

    @Test
    void shouldReturnInvalidPasswordBecauseDontContainsUpperCase() {
        var command = builder.password("abtp9!fok").build();
        assertFalse(service.handle(command));
    }

    @Test
    void shouldReturnInvalidPasswordBecauseDontContainsLowerCase() {
        var command = builder.password("ABTP9!FOK").build();
        assertFalse(service.handle(command));
    }

    @Test
    void shouldReturnInvalidPasswordBecauseDontContainsSpecialCaracter() {
        var command = builder.password("AbTp91fok").build();
        assertFalse(service.handle(command));
    }

    @Test
    void shouldReturnInvalidPasswordBecauseDontContainsDigit() {
        var command = builder.password("AbTp@!fok").build();
        assertFalse(service.handle(command));
    }

    @Test
    void shouldReturnInvalidPasswordBecauseHasRepeatedCharacters() {
        var command = builder.password("AbTp9!foo").build();
        assertFalse(service.handle(command));
    }
}

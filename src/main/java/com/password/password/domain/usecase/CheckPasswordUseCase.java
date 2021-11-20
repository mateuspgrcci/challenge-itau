package com.password.password.domain.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


public interface CheckPasswordUseCase {

    boolean handle(@Validated CheckPassword command);

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class CheckPassword {

        @NotNull(message = "password is null")
        String password;
    }
}

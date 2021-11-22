package com.password.password.domain.service;

import com.password.password.domain.usecase.CheckPasswordUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CheckPasswordService implements CheckPasswordUseCase {

    @Override
    public boolean handle(CheckPassword command) {
        log.info(LocalDateTime.now() + " MSG=starting password validation.");

        var valid = command.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#!])(?:([0-9a-zA-Z$*&@#!])(?!\\1)){9,}$");

        log.info(LocalDateTime.now() + " MSG=password successfully validated, is {}.", valid ? "valid" : "invalid");

        return valid;
    }
}

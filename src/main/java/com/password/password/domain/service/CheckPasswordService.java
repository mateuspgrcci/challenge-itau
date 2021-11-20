package com.password.password.domain.service;

import com.password.password.domain.usecase.CheckPasswordUseCase;
import org.springframework.stereotype.Service;

@Service
public class CheckPasswordService implements CheckPasswordUseCase {

    @Override
    public boolean handle(CheckPassword command) {
        var regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#!])(?:([0-9a-zA-Z$*&@#!])(?!\\1)){9,}$";
        return command.getPassword()
                .matches(regex);
    }
}

package com.password.password.adapter;

import com.password.password.domain.usecase.CheckPasswordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.password.password.domain.usecase.CheckPasswordUseCase.CheckPassword;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/api/v1/password", produces = APPLICATION_JSON_VALUE)
public class PasswordController {

    private final CheckPasswordUseCase service;

    @PostMapping(path = "/check", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> check(@Validated @RequestBody CheckPassword command) {
        var valid = service.handle(command);

        return ResponseEntity.ok().body(valid);
    }
}

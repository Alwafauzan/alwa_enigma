package com.livecode.livecode_loan_app.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livecode.livecode_loan_app.model.AuthenticateRequest;
import com.livecode.livecode_loan_app.model.AuthenticationResponse;
import com.livecode.livecode_loan_app.model.RegisterRequest;
import com.livecode.livecode_loan_app.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticateRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}

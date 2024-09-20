package com.livecode.livecode_loan_app.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.livecode.livecode_loan_app.model.AppUser;
import com.livecode.livecode_loan_app.model.AuthenticateRequest;
import com.livecode.livecode_loan_app.model.AuthenticationResponse;
import com.livecode.livecode_loan_app.model.RegisterRequest;
import com.livecode.livecode_loan_app.repository.AppUserRepository;
import com.livecode.livecode_loan_app.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        private final AppUserRepository appUserRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtUtil jwtUtil;
        private final AuthenticationManager authManager;

        public AuthenticationResponse register(RegisterRequest request) {
                if (appUserRepository.existsByEmail(request.getEmail())) {
                        throw new RuntimeException("Email already exists");
                }
                var appUser = AppUser.builder()
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(request.getRole())
                                .build();
                appUserRepository.save(appUser);
                var jwtToken = jwtUtil.generateToken(appUser);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

        public AuthenticationResponse authenticate(AuthenticateRequest request) {
                if (request.getEmail() == null || request.getEmail().isBlank()) {
                        throw new RuntimeException("Email is required");
                }
                authManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));
                var appUser = appUserRepository.findByEmail(request.getEmail())
                                .orElseThrow();
                var jwtToken = jwtUtil.generateToken(appUser);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }
}

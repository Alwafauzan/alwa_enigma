package com.livecode.livecode_loan_app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.livecode.livecode_loan_app.model.AppUser;
import com.livecode.livecode_loan_app.model.AuthenticateRequest;
import com.livecode.livecode_loan_app.model.AuthenticationResponse;
import com.livecode.livecode_loan_app.model.RegisterRequest;
import com.livecode.livecode_loan_app.model.Role;
import com.livecode.livecode_loan_app.repository.AppUserRepository;
import com.livecode.livecode_loan_app.service.AuthenticationService;
import com.livecode.livecode_loan_app.util.JwtUtil;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AuthenticationServiceTest {

    @Test
    void register_success() {
        RegisterRequest request = RegisterRequest.builder()
                .email("yamatekudasai@gmail.com")
                .password("1234")
                .role(Role.ADMIN)
                .build();
        AppUserRepository appUserRepository = mock(AppUserRepository.class);
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        AuthenticationService authenticationService = new AuthenticationService(appUserRepository, passwordEncoder,
                new JwtUtil(), null);
        AuthenticationResponse response = authenticationService.register(request);
        assertNotNull(response.getToken());
    }

    @Test
    void register_email_is_exist() {
        RegisterRequest request = RegisterRequest.builder()
                .email("yamatekudasai@gmail.com")
                .password("1234")
                .role(Role.ADMIN)
                .build();
        AppUserRepository appUserRepository = mock(AppUserRepository.class);
        when(appUserRepository.existsByEmail(request.getEmail())).thenReturn(true);
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        AuthenticationService authenticationService = new AuthenticationService(appUserRepository, passwordEncoder,
                new JwtUtil(), null);
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> authenticationService.register(request));
        assertEquals("Email already exists", exception.getMessage());
    }

    @Test
    void authenticate_success() {
        AuthenticateRequest request = AuthenticateRequest.builder()
                .email("yamatekudasai@gmail.com")
                .password("1234")
                .build();
        AppUserRepository appUserRepository = mock(AppUserRepository.class);
        AppUser appUser = AppUser.builder()
                .email(request.getEmail())
                .password("1234")
                .build();
        when(appUserRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(appUser));
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        AuthenticationManager authManager = mock(AuthenticationManager.class);
        JwtUtil jwtUtil = mock(JwtUtil.class);
        when(jwtUtil.generateToken(appUser)).thenReturn("token");
        AuthenticationService authenticationService = new AuthenticationService(appUserRepository, passwordEncoder,
                jwtUtil,
                authManager);
        AuthenticationResponse response = authenticationService.authenticate(request);
        assertNotNull(response.getToken());
    }

    @Test
    void authenticate_email_is_null() {
        AuthenticateRequest request = AuthenticateRequest.builder()
                .password("1234")
                .build();
        AppUserRepository appUserRepository = mock(AppUserRepository.class);
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        AuthenticationManager authManager = mock(AuthenticationManager.class);
        JwtUtil jwtUtil = mock(JwtUtil.class);
        AuthenticationService authenticationService = new AuthenticationService(appUserRepository, passwordEncoder,
                jwtUtil,
                authManager);
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> authenticationService.authenticate(request));
        assertEquals("Email is required", exception.getMessage());
    }
}

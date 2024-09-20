package com.example.jwt_student.util;

import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ValidationUtil {
    private final Validator validator;

    public void validate(Object obj) {
        Set<ConstraintViolation<Object>> result = validator.validate(obj);
        if (!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }
    }
}

// spring security
// authentication
// encrypt
// decrypt
// jwt
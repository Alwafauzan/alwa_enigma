package com.example.jwt_student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt_student.model.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, String> {
    Optional<UserCredential> findByEmail(String email);
}

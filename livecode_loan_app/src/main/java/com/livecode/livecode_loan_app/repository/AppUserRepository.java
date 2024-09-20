package com.livecode.livecode_loan_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livecode.livecode_loan_app.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByEmail(String email);

    boolean existsByEmail(String email);
}

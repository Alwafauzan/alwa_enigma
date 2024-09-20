package com.livecode.livecode_loan_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livecode.livecode_loan_app.model.InstalmentType;

public interface InstalmentTypeRepository extends JpaRepository<InstalmentType, String> {
    Optional<InstalmentType> findByid(String id);
}

// oke sejauh ini aman
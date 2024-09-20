package com.livecode.livecode_loan_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livecode.livecode_loan_app.model.LoanType;

public interface LoanTypeRepository extends JpaRepository<LoanType, String> {
    Optional<LoanType> findByid(String id);
}

// oke sejauh ini aman
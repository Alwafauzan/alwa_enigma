package com.livecode.livecode_loan_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livecode.livecode_loan_app.model.LoanTransaction;

public interface LoanTransactionRepository extends JpaRepository<LoanTransaction, String> {
    Optional<LoanTransaction> findByid(String id);
}

// oke sejauh ini aman
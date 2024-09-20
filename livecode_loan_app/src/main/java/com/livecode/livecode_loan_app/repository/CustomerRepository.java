package com.livecode.livecode_loan_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livecode.livecode_loan_app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByid(String id);
}

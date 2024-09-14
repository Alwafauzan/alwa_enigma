package com.example.cobajwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cobajwt.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

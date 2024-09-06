package com.example.coba_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coba_customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Object findByPhoneNumber(String phoneNumber);

}
// oke sejauh ini aman
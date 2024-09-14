package com.example.coba_customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coba_customer.model.Meja;

public interface MejaRepository extends JpaRepository<Meja, String> {
    Optional<Meja> findById(String id);
}

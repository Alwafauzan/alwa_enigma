package com.example.coba_customer.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
    Optional<Transaksi> findById(String id);
}

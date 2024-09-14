package com.example.coba_customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coba_customer.model.Transaksi;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
    Optional<Transaksi> findById(String id);
}

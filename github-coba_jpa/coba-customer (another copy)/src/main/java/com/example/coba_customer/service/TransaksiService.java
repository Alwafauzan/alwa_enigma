package com.example.coba_customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coba_customer.model.Transaksi;
import com.example.coba_customer.repository.TransaksiRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransaksiService {

    private final TransaksiRepository transaksiRepository;

    // create
    public Transaksi saveTransaksi(Transaksi transaksi) {
        return transaksiRepository.save(transaksi);
    }

    // read
    public List<Transaksi> getAllTransaksis() {
        return transaksiRepository.findAll();
    }
}

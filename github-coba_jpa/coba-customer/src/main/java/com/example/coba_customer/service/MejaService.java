package com.example.coba_customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coba_customer.model.Meja;
import com.example.coba_customer.repository.MejaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MejaService {

    private final MejaRepository mejaRepository;

    public List<Meja> getAllMejas() {
        return mejaRepository.findAll();
    }

    // // read by id
    // public Optional<Meja> getMejaByid(String id) {
    // return mejaRepository.findByid(id);
    // }
}

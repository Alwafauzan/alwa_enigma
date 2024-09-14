package com.example.coba_customer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coba_customer.model.Meja;
import com.example.coba_customer.service.MejaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/meja")
@RequiredArgsConstructor
public class MejaController {

    private final MejaService mejaService;

    @GetMapping
    public List<Meja> getAllMejas() {
        return mejaService.getAllMejas();
    }

    // @GetMapping("/{id}")
    // public Meja getMejaById(@PathVariable String id) {
    // return mejaService.getMejaByid(id);
    // }
}

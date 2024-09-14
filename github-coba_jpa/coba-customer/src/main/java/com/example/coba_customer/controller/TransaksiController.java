package com.example.coba_customer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coba_customer.model.Transaksi;
import com.example.coba_customer.service.TransaksiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transaksi")
@RequiredArgsConstructor
public class TransaksiController {

    private final TransaksiService transaksiService;

    // create
    @PostMapping("/create")
    public Transaksi saveTransaksi(@RequestBody Transaksi transaksi) {
        return transaksiService.saveTransaksi(transaksi);
    }

    // read
    @GetMapping
    public List<Transaksi> getAllTransaksis() {
        return transaksiService.getAllTransaksis();
    }

    // @GetMapping("/{id}")
    // public Transaksi getTransaksiById(@PathVariable String id) {
    // return transaksiService.getTransaksiByid(id);
    // }
}

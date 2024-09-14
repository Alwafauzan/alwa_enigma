package com.example.coba_customer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "m_transaksi")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jumlah_transaksi", nullable = false, unique = true)
    private Long jumlahTransaksi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_meja")
    // @JsonIgnore // Mengabaikan properti siswa saat serialisasi JSON
    @JsonBackReference // Mengatur bahwa sisi ini adalah referensi balik
    private Meja mejaConnections;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    // @JsonIgnore // Mengabaikan properti siswa saat serialisasi JSON
    @JsonBackReference // Mengatur bahwa sisi ini adalah referensi balik
    private Customer customerConnections;

    // bodok

}

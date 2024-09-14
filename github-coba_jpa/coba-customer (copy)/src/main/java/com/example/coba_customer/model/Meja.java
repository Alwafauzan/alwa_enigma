package com.example.coba_customer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "m_table")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Meja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "meja_name", nullable = false, unique = true)
    private String mejaName;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    // @JsonIgnore // Mengabaikan properti siswa saat serialisasi JSON
    @JsonBackReference // Mengatur bahwa sisi ini adalah referensi balik
    private Customer customerConnections;

    @OneToMany(mappedBy = "mejaConnections", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Mengatur bahwa sisi ini adalah "owner"
    private List<Transaksi> transaksiConnections;
}

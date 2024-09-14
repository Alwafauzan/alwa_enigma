package com.example.coba_customer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "m_customer")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "is_member")
    private Boolean isMember;

    @OneToMany(mappedBy = "customerConnections", cascade = CascadeType.ALL)
    @JsonManagedReference // Mengatur bahwa sisi ini adalah "owner"
    private List<Meja> mejaConnections;

    // @OneToMany(mappedBy = "customerConnections", cascade = CascadeType.ALL, fetch
    // = FetchType.LAZY)
    // @JsonManagedReference // Mengatur bahwa sisi ini adalah "owner"
    // private List<Transaksi> transaksiConnections;
}

// {"name":"tita","phoneNumber":"089609000732","isMember":true}
// sampe mana tadi
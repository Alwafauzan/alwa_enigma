package com.uhukuhuk.MyStore.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
    private String phone;
    private String address;
    private String password;
    private String role;
    private Date createdAt;

    public AppUser(String firstName, String lastName, String email, String phone, String address, String password,
            String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.role = role;
    }
}

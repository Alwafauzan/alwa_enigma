package com.livecode.livecode_loan_app.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date dateOfBirth;
    @Column
    private String phone;
    @Column
    private String status;
    @OneToOne
    private AppUser user;
}

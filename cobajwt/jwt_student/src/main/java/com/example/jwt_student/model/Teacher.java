package com.example.jwt_student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_jwt_teacher")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;
    @Column
    private String nip;
    @Column(unique = true)
    private String name;
    @Column
    private String email;
    @Column(unique = true)
    private String password;

    @OneToOne
    @JoinColumn(name = "tbl_jwt_user_credential")
    private UserCredential userCredential;

}

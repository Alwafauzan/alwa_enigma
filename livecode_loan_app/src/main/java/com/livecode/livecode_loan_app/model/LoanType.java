package com.livecode.livecode_loan_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loan_type")
@Entity
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String type;
    @Column
    private Double maxLoan;

}

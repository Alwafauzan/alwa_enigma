package com.livecode.livecode_loan_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoanTransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private Long transactionDate;
    @Column
    private Double nominal;
    @ManyToOne
    @JoinColumn(name = "loan_transaction_id")
    private LoanTransaction loanTransaction;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus; // enum
    @Column
    private Long createdAt;
    @Column
    private Long updatedAt;
}

enum LoanStatus {
    PAID,
    UNPAID
}
